package com.bipul.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNbr {

    static HashMap<String, String> digitHash = new HashMap<>();

    public static void main(String[] args) {

        //assigning the hash values - easy approach - more space complexity
        digitHash.put("2", "abc");
        digitHash.put("3", "def");
        digitHash.put("4", "ghi");
        digitHash.put("5", "jkl");
        digitHash.put("6", "mno");
        digitHash.put("7", "pqrs");
        digitHash.put("8", "tuv");
        digitHash.put("9", "wxyz");

        String digits = "27";
        printLetterCombinations(digits, "");
        List<String> listCombinations = returnLetterCombinations(digits, "");
        System.out.println(listCombinations);

        //BETTER APPROACH WITH LESS SPACE COMPLEXITY: a solution without using hash-values and using a diff logic
        printLetterCombinationsRangeApproach(digits, "");

    }

    static void printLetterCombinations(String upStr, String pStr){
        if(upStr.isEmpty()){
            System.out.println(pStr);
            return;
        }
        char digit = upStr.charAt(0);
        String charsInDigit = digitHash.get(String.valueOf(digit));
        for (char c : charsInDigit.toCharArray()) {
            printLetterCombinations(upStr.substring(1), pStr+String.valueOf(c));
        }
    }

    static List<String> returnLetterCombinations(String upStr, String pStr){
        List<String> strCombinations = new ArrayList<>();

        if(upStr.isEmpty()){
            strCombinations.add(pStr);
            return strCombinations;
        }
        char digit = upStr.charAt(0);
        String charsInDigit = digitHash.get(String.valueOf(digit));
        for (char c : charsInDigit.toCharArray()) {
            strCombinations.addAll(returnLetterCombinations(upStr.substring(1), pStr+String.valueOf(c)));
        }
        return strCombinations;
    }

    //a solution without using hash-values and using a diff logic
    //here we are calculating the recursive functions to run on the basis of position of the digits
    static void printLetterCombinationsRangeApproach(String upStr, String pStr) {
        if (upStr.isEmpty()) {
            System.out.println(pStr);
            return;
        }

        int digit = upStr.charAt(0) - '0';
        int start = (digit-2)*3;
        if(digit>7)
            start++;
        int end = start+3;
        if (digit == 7 || digit == 9)
            end++;

        for (int i = start; i < end; i++) {
            char ch = (char) ('a'+i);
            printLetterCombinationsRangeApproach(upStr.substring(1), pStr+ch);
        }
    }
}
