package com.bipul;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        boolean gameOver = false;
        char[][] board = new char[3][3];
        char player = 'X'; //we have two players 'X' and 'O', by default it starts with X
        Scanner sc = new Scanner(System.in);

        //initializing the board with empty char
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        System.out.println("Let's play Tic Tac Toe..");
        System.out.println("For every player, give the i and j index (0-2) to be marked on the board");

        while (!gameOver){
            displayBoard(board);
            System.out.println("Player " + player + "'s turn!");
            int i = sc.nextInt();
            int j = sc.nextInt();

            //validate input and proceed
            if(board[i][j] == '-'){
                board[i][j] = player; //marking the position
                //check for game over
                if(isGameOver(board, player)){
                    gameOver = true;
                    System.out.println("Player " + player + " wins!");
                    displayBoard(board);
                }else{
                    player = player == 'X' ? 'O' : 'X'; //player change
                }
            }else{
                System.out.println("Invalid position provided in the input!");
            }
        }
    }

    private static boolean isGameOver(char[][] board, char player){
        //check rows
        for (int row = 0; row < 3; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) return true;
        }

        //check columns
        for (int col = 0; col < 3; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) return true;
        }

        //check diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true; //top left to bottom right diagonal
        if(board[2][0] == player && board[1][1] == player && board[0][2] == player) return true; //bottom left to top right diagonal

        return false;
    }

    private static void displayBoard(char[][] board){
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
