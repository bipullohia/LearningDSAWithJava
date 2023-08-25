package com.bipul.subset.backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] matrix = new boolean[n][n];
        System.out.println("Count: " + printNKnights(matrix, 0, 0, n));
    }

    static int printNKnights(boolean[][] matrix, int row, int col, int countOfKnights){
        int count = 0;

        if(countOfKnights == 0){
            print(matrix);
            System.out.println();
            return 1;
        }

        //if the execution reaches the n*nth element (last element of the matrix) - just return since nothing more can be done
        if(row == matrix.length-1 && col == matrix[0].length-1)
            return 0;

        //our intention is to keep trying to place the knight, so once we reach the end of the row, we continue with the next row
        if(col == matrix.length){
            count += printNKnights(matrix, row+1, 0, countOfKnights);
            return count;
        }

        if(isSafeForKnight(matrix, row, col)){
            matrix[row][col] = true;
            //start checking a new row since we are at the last col of the row
            count += printNKnights(matrix, row, col+1, countOfKnights-1);
            matrix[row][col] = false;
        }

        //in any case - keep moving ahead (we don't return a count since we didn't place a Knight)
        //if it's not safe to put the knight above - just move ahead
        count += printNKnights(matrix, row, col+1, countOfKnights);

        return count;
    }

    //we have to check 4 directions - two up, 1 left(up) and 1 right(up). We don't check the positions yet to be filled in the later iterations
    static boolean isSafeForKnight(boolean[][] matrix, int row, int col){

        //check for left-up
        if(isValidMatrix(matrix, row-2, col-1)){
            if(matrix[row-2][col-1])
                return false;
        }

        //check for right-up
        if(isValidMatrix(matrix, row-2, col+1)){
            if(matrix[row-2][col+1])
                return false;
        }

        //check for up-left
        if(isValidMatrix(matrix, row-1, col-2)){
            if(matrix[row-1][col-2])
                return false;
        }

        //check for up-right
        if(isValidMatrix(matrix, row-1, col+2)){
            if(matrix[row-1][col+2])
                return false;
        }
        return true;
    }

    static boolean isValidMatrix(boolean[][] matrix, int row, int col){
        if(row>=0 && row<matrix.length && col>=0 && col<matrix[0].length)
            return true;
        return false;
    }

    static void print(boolean[][] matrix){
        for(boolean[] row: matrix){
            for(boolean cell: row){
                if(cell)
                    System.out.print("K ");
                else
                    System.out.print("x ");
            }
            System.out.println();
        }
    }
}