package com.bipul.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeProblems {
    public static void main(String[] args) {
//        System.out.println(countNumberOfWaysToReach(3,3, 1, 1)); //assuming only right and down direction possible
//        printPathsToDestination(3,3,1,1, new ArrayList<>());
//        printPathsToDestinationWithDiagonal(3,3,1,1,new ArrayList<>());

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

//        printMazePathWithObstacles(maze, 0, 0, 1, 2, new ArrayList<>());
//        printAllDirectionPaths(maze, 0, 0, 2, 2, new ArrayList<>());
        int[][] matrixToPrint = new int[maze.length][maze[0].length];
        printMatrixAndPathsAllDirection(maze, 0, 0, 2, 2, new ArrayList<>(), matrixToPrint, 1);
    }

    //**Good ques to understand concepts/fundamentals**
    //movements to all the 4 directions allowed (not diagonal);
    static void printAllDirectionPaths(boolean[][] maze, int startRow, int startCol, int targetRow, int targetCol, List<String> path){
        if(startRow == targetRow && startCol == targetCol){
            System.out.println(path);
            return;
        }

        //if a false cell - return - this is because it has already been traversed in the same path - and we don't want subsequent below calls to come back to this cell
        if(!maze[startRow][startCol])
            return;

        //setting the flag as false to not repeat (treat the path already traversed as blockers - so that we don't go back there in 1 iteration/path)
        maze[startRow][startCol] = false;

        //going down
        if(startRow < maze.length-1){
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("D");
            printAllDirectionPaths(maze, startRow+1, startCol, targetRow, targetCol, existingPaths);
        }

        //going right
        if(startCol < maze[0].length-1){
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("R");
            printAllDirectionPaths(maze, startRow, startCol+1, targetRow, targetCol, existingPaths);
        }

        //going up
        if(startRow > 0){ //since it can not go up once it reaches the index 0
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("U");
            printAllDirectionPaths(maze, startRow-1, startCol, targetRow, targetCol, existingPaths);
        }

        //going left
        if(startCol > 0){ //since it can not go left once it reaches the index 0
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("L");
            printAllDirectionPaths(maze, startRow, startCol-1, targetRow, targetCol, existingPaths);
        }

        //setting the flag again as true so that other paths can traverse through the maze - while going back to the parent function
        maze[startRow][startCol] = true;
    }

    //print the matrix along with the paths printed in printAllDirectionPaths
    static void printMatrixAndPathsAllDirection(boolean[][] maze, int startRow, int startCol, int targetRow, int targetCol, List<String> path, int[][] matrixToPrint, int step) {
        if (startRow == targetRow && startCol == targetCol) {
            matrixToPrint[startRow][startCol] = step; //since destination is also a step
            for(int[] row: matrixToPrint){
                System.out.println(Arrays.toString(row));
            }
            System.out.println(path);
            System.out.println();
            return;
        }

        //if a false cell - return - this is because it has already been traversed in the same path - and we don't want subsequent below calls to come back to this cell
        if (!maze[startRow][startCol]){
            return;
        }

        //setting the flag as false to not repeat (treat the path already traversed as blockers - so that we don't go back there in 1 iteration/path)
        maze[startRow][startCol] = false;

        matrixToPrint[startRow][startCol] = step;
        //going down
        if (startRow < maze.length - 1) {
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("D");
            printMatrixAndPathsAllDirection(maze, startRow + 1, startCol, targetRow, targetCol, existingPaths, matrixToPrint, step+1);
        }

        //going right
        if (startCol < maze[0].length - 1) {
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("R");
            printMatrixAndPathsAllDirection(maze, startRow, startCol + 1, targetRow, targetCol, existingPaths, matrixToPrint, step+1);
        }

        //going up
        if (startRow > 0) { //since it can not go up once it reaches the index 0
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("U");
            printMatrixAndPathsAllDirection(maze, startRow - 1, startCol, targetRow, targetCol, existingPaths, matrixToPrint, step+1);
        }

        //going left
        if (startCol > 0) { //since it can not go left once it reaches the index 0
            ArrayList<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("L");
            printMatrixAndPathsAllDirection(maze, startRow, startCol - 1, targetRow, targetCol, existingPaths, matrixToPrint, step+1);
        }

        //setting the flag again as true so that other paths can traverse through the maze - while going back to the parent function
        maze[startRow][startCol] = true;
        matrixToPrint[startRow][startCol] = 0;
    }

    //assumption: only right and down movement allowed (not handling invalid inputs for now)
    static void printPathsToDestination(int startRow, int startCol, int targetRow, int targetCol, List<String> path){
        if(startRow == targetRow && startCol == targetCol){
            System.out.println(path);
            return;
        }
        //going down
        if(startRow > targetRow){ //we only go down only if we aren't already in the target row
            List<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("D");
            printPathsToDestination(startRow-1, startCol, targetRow, targetCol, existingPaths);
        }
        //going right
        if(startCol > targetCol){//we only go right only if we aren't already in the target row
            List<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("R");
            printPathsToDestination(startRow, startCol-1, targetRow, targetCol, existingPaths);
        }
    }

    //assumption: right, down and diagonal movement allowed (not handling invalid inputs for now)
    static void printPathsToDestinationWithDiagonal(int startRow, int startCol, int targetRow, int targetCol, List<String> path){
        if(startRow == targetRow && startCol == targetCol){
            System.out.println(path);
            return;
        }
        //going down
        if(startRow > targetRow){ //we only go down only if we aren't already in the target row
            List<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("D");
            printPathsToDestinationWithDiagonal(startRow-1, startCol, targetRow, targetCol, existingPaths);
        }
        //going right
        if(startCol > targetCol){//we only go right only if we aren't already in the target row
            List<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("R");
            printPathsToDestinationWithDiagonal(startRow, startCol-1, targetRow, targetCol, existingPaths);
        }
        //going diagonal
        if(startCol > targetCol && startRow > targetRow){//we only go diagonal only if we aren't already in the target position
            List<String> existingPaths = new ArrayList<>(path);
            existingPaths.add("O"); //O denotes diagonal
            printPathsToDestinationWithDiagonal(startRow-1, startCol-1, targetRow, targetCol, existingPaths);
        }
    }

    //given a 2d boolean array (maze) with obstacles as false, traverse from startRow/startCol to targetRow/targetCol
    //since a maze - it starts with 0,0 and ends at maze length-1
    //directions allowed - right, down, diagonal
    static void printMazePathWithObstacles(boolean[][] maze, int startRow, int startCol, int targetRow, int targetCol, List<String> path){
        if(targetRow>maze.length-1 || targetCol>maze[0].length-1){
            System.out.println("Invalid target row/col given");
            return;
        }

        if(startRow == targetRow && startCol == targetCol){
            System.out.println(path);
            return;
        }

        //return if found an obstacle
        if(!maze[startRow][startCol])
            return;

        if(startRow < maze.length-1){ //we only go down if we aren't already in the target row
            List<String> existingPath = new ArrayList<>(path);
            existingPath.add("D");
            printMazePathWithObstacles(maze, startRow+1, startCol, targetRow, targetCol, existingPath);
        }

        if(startCol < maze[0].length-1){ //we only go down if we aren't already in the target row
            List<String> existingPath = new ArrayList<>(path);
            existingPath.add("R");
            printMazePathWithObstacles(maze, startRow, startCol+1, targetRow, targetCol, existingPath);
        }

        if(startRow < maze.length-1 && startCol < maze[0].length-1){ //we only go down if we aren't already in the target row
            List<String> existingPath = new ArrayList<>(path);
            existingPath.add("O");
            printMazePathWithObstacles(maze, startRow+1, startCol+1, targetRow, targetCol, existingPath);
        }
    }

    //assumption: only right and down movement allowed (not handling invalid inputs for now)
    static int countNumberOfWaysToReach(int startRow, int startCol, int targetRow, int targetCol){
        int count = 0;
        if(startRow == targetRow || startCol == targetCol)
            return 1; //because only 1 direction possible now- right or down respectively
        //going down
        count += countNumberOfWaysToReach(startRow-1, startCol, targetRow, targetCol);
        //going right
        count += countNumberOfWaysToReach(startRow, startCol-1, targetRow, targetCol);
        return count;
    }
}
