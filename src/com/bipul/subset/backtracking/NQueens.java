package com.bipul.subset.backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {

        //N Queens problem means we have to find various valid ways in which n queens can be placed in a nxn matrix
        int n = 4;
        boolean[][] matrixToPrint = new boolean[n][n];

        System.out.println("Count: " + printNQueenMatrix(matrixToPrint, 0));
    }

    static int printNQueenMatrix(boolean[][] matrix, int row){
        //count will store the number of results
        int count = 0;

        //when it's past the last row of the matrix, print the matrix - this means what we have traversed through all the rows of matrix
        if(row == matrix.length){
            print(matrix);
            System.out.println();
            return 1; //since this means we have found 1 count of the possible n queen placement
        }

        //for this row - traverse through all the columns and recurse for the subsequent rows
        for(int i=0; i<matrix[0].length; i++){
            //check if it's safe to put the Queen here
            if(safetyCheckForQueen(matrix, row, i)){
                matrix[row][i] = true; //mark the cell as true to denote queen has been placed
                count += printNQueenMatrix(matrix, row+1); //call the func again to check for subsequent rows
                matrix[row][i] = false; //backtracking the cell to false for other iterations to have clean slate
            }
        }

        return count;
    }

    static boolean safetyCheckForQueen(boolean[][] matrix, int row, int col){
        //we don't check the rows below the mentioned row (down direction) - because they will be traversed in subsequent recursive calls by the parent func
        //we don't check the left or right direction because we place only 1 Queen in a row so that's won't happen

        //check left-diagonal direction
        int minForLeftD = Integer.min(row, col); //this denotes the number of cells we have to check the left diag of matrix for this cell
        for(int i=1; i<=minForLeftD; i++){
            if(matrix[row-i][col-i])
                return false;
        }

        //check up direction
        for(int i=row-1; i>=0; i--){ //row-1 in initializer because we would start with the row above it;
            if(matrix[i][col])
                return false;
        }

        //check right-diagonal direction
        int minForRightD = Integer.min(row, matrix[0].length-1-col); //this denotes the number of cells we have to check the right diag of matrix for this cell
        for(int i=1; i<=minForRightD; i++){
            if(matrix[row-i][col+i])
                return false;
        }

        return true;
    }

    static void print(boolean[][] matrix){
        for(boolean[] row: matrix){
            for(boolean cell: row){
                if(cell)
                    System.out.print("Q ");
                else
                    System.out.print("x ");
            }
            System.out.println();
        }
    }
}
