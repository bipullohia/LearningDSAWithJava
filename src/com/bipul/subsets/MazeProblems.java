package com.bipul.subsets;

import java.util.ArrayList;
import java.util.List;

public class MazeProblems {
    public static void main(String[] args) {
//        System.out.println(countNumberOfWaysToReach(3,3, 1, 1)); //assuming only right and down direction possible
//        printPathsToDestination(3,3,1,1, new ArrayList<>());
        printPathsToDestinationWithDiagonal(3,3,1,1,new ArrayList<>());
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
