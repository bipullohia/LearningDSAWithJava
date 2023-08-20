package com.bipul.subsets;

import java.util.ArrayList;
import java.util.List;

public class DiceRollCombinations {
    public static void main(String[] args) {
        int num = 4;
        printDiceRollCombos(num, new ArrayList<>());
        List<List<Integer>> diceRollCombos = returnDiceRollCombos(num, new ArrayList<>());
        System.out.println(diceRollCombos);

        printDiceRollCombosVarFace(num, new ArrayList<>(), 8);
    }

    //targetNum can be thought of unprocessed variable - here it has to turn to 0
    static void printDiceRollCombos(int targetNum, List<Integer> processedList){
        if(targetNum == 0){
            System.out.println(processedList);
            return;
        }

        for(int i=1; i<=targetNum; i++){
            List<Integer> listCombinations = new ArrayList<>(processedList);
            listCombinations.add(i);
            printDiceRollCombos(targetNum-i, listCombinations);
        }
    }

    static List<List<Integer>> returnDiceRollCombos(int targetNum, List<Integer> processedList){
        List<List<Integer>> result = new ArrayList<>();
        if(targetNum == 0){
            result.add(processedList);
            return result;
        }

        for(int i=1; i<=6 && i<=targetNum; i++){ //NOTE: don't forget to add i<=6 because of the dice constrains
            List<Integer> listCombinations = new ArrayList<>(processedList);
            listCombinations.add(i);
            result.addAll(returnDiceRollCombos(targetNum-i, listCombinations));
        }
        return result;
    }


    //dice face if not 6 - can be passed in the arg
    static void printDiceRollCombosVarFace(int targetNum, List<Integer> processedList, int facesOfDice){
        if(targetNum == 0){
            System.out.println(processedList);
            return;
        }

        for(int i=1; i<=facesOfDice && i<=targetNum; i++){
            List<Integer> listCombinations = new ArrayList<>(processedList);
            listCombinations.add(i);
            printDiceRollCombosVarFace(targetNum-i, listCombinations, facesOfDice);
        }
    }
}
