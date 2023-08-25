package com.bipul.subset.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudokuInput = new int[][]{
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };

        boolean isSolved = solveSudoku(sudokuInput);
        if(isSolved){
            System.out.println("Final solved Sudoku: ");
            print(sudokuInput); //prints the last solved sudoku
        }
        else
            System.out.println("Sudoku solution possibility: " + isSolved);
    }

    static boolean solveSudoku(int[][] sudoku){

        //finding an empty cell (here, that will mean a value of 0)
        int row = -1, col = -1; //setting defaults as -1 for an empty row/col
        boolean emptyCellFound = false;
        int n = sudoku.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(sudoku[i][j] == 0){
                    row = i;
                    col = j;
                    emptyCellFound = true;
                    break;
                }
            }
            if(emptyCellFound) //since we already found an empty cell in the row
                break;
        }

        //checking if the sudoku is already solved - we won't find any empty cell after the search above (kind of base condition for true cases)
        if(!emptyCellFound) //sudoku solved
            return true;

        //try to place the elements from 1-9 in that and make subsequent calls
        for(int i=1; i<=9; i++){ //trying to place elements 1-9
            if(numSafeToPut(sudoku, row, col, i)){
                sudoku[row][col] = i; //put the number in the board
                if(solveSudoku(sudoku)){ //recurse the func to try and place other elements
                    return true; //this means the sudoku is solved
                }
                else
                    sudoku[row][col] = 0; //backtrack
            }
        }

        return false; //true when sudoku can't be solved
    }

    static boolean numSafeToPut(int[][] sudoku, int row, int col, int number){
        //check row
        for(int i=0; i<sudoku[0].length; i++){
            if(sudoku[row][i] == number)
                return false;
        }

        //check col
        for(int i=0; i<sudoku.length; i++){
            if(sudoku[i][col] == number)
                return false;
        }

        //check grid
        //getting the starting index of the grid
        int sqroot = (int) Math.sqrt(sudoku.length); //in 9*9 board - it will be 3, basically it denotes the grid size
        int startRow = row - (row%sqroot);
        int startCol = col - (col%sqroot);
        for(int i=startRow; i<startRow+sqroot; i++){
            for(int j=startCol; j<startCol+3; j++){
                if(sudoku[i][j] == number)
                    return false;
            }
        }

        return true;
    }

    static void print(int[][] sudoku){
        for(int[] row: sudoku){
            for(int cell: row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
