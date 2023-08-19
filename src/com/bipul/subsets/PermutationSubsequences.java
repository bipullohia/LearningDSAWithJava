package com.bipul.subsets;

import java.util.ArrayList;
import java.util.List;

//printing all the subsets of the array
public class PermutationSubsequences {
    public static void main(String[] args) {
        String str = "abc";
        printPermutations(str, "");
        ArrayList<String> permStringList = returnPermutationList(str, "");
        System.out.println(permStringList);

        System.out.println(countPermutationsOfString(str, ""));
    }

    // upStr => unprocessedStr, pStr => processedStr,
    static void printPermutations(String upStr, String pStr){
        if(upStr.isEmpty()){
            System.out.println(pStr);
            return;
        }

        char c = upStr.charAt(0);
        for(int i=0; i<=pStr.length(); i++){
            //logic for diff permutations of char in the string
            String s = pStr.substring(0,i) + c + pStr.substring(i);
            printPermutations(upStr.substring(1), s);
        }
    }

    //returns the list of possible permutations of the string in response
    private static ArrayList<String> returnPermutationList(String upStr, String pStr) {
        ArrayList<String> listStr = new ArrayList<>();

        if(upStr.isEmpty()){
            listStr.add(pStr);
            return listStr;
        }

        char c = upStr.charAt(0);
        for(int i=0; i<=pStr.length(); i++){
            String s = pStr.substring(0,i) + c + pStr.substring(i);
            listStr.addAll(returnPermutationList(upStr.substring(1), s));
        }
        return listStr;
    }

    private static int countPermutationsOfString(String upStr, String pStr){
        int count = 0;
        if(upStr.isEmpty()){
            return ++count; //we can better return 1 for clarity as it will always be 1
        }

        char c = upStr.charAt(0);
        for(int i=0; i<=pStr.length(); i++){
            //logic for diff permutations of char in the string
            String s = pStr.substring(0,i) + c + pStr.substring(i);
            count += countPermutationsOfString(upStr.substring(1), s);
        }
        return count;
    }

}