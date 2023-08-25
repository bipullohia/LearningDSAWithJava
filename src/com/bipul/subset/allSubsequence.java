package com.bipul.subset;

import java.util.ArrayList;

//printing all sub-sequence of a string using recursion
public class allSubsequence {
    public static void main(String[] args) {
        String str = "ab";
        printSubsequence(str, "");

        ArrayList<String> arrStr = arrayListSubsequence1(str, "", new ArrayList<String>());
        System.out.println(arrStr);

        ArrayList<String> arrStr2 = arrayListSubsequence1(str, "", new ArrayList<String>());
        System.out.println(arrStr2);
    }

    //the case where we don't have the arrayList in the func argument
    static ArrayList<String> arrayListSubsequence2(String unprocessedStr, String processedStr){
        ArrayList<String> arrStr = new ArrayList<>();
        if(unprocessedStr.isEmpty()){
            arrStr.add(processedStr);
            return arrStr;
        }
        arrStr.addAll(arrayListSubsequence2(unprocessedStr.substring(1), processedStr + unprocessedStr.charAt(0)));
        arrStr.addAll(arrayListSubsequence2(unprocessedStr.substring(1), processedStr));

        //this returns the final output array
        return arrStr;
    }

    //the case where we have the arrayList in the func argument
    static ArrayList<String> arrayListSubsequence1(String unprocessedStr, String processedStr, ArrayList<String> arrStr){
        if(unprocessedStr.isEmpty()){
            arrStr.add(processedStr);
            return arrStr;
        }
        arrayListSubsequence1(unprocessedStr.substring(1), processedStr + unprocessedStr.charAt(0), arrStr);
        arrayListSubsequence1(unprocessedStr.substring(1), processedStr, arrStr);

        //this returns the final output array
        return arrStr;
    }

    static void printSubsequence(String unprocessedStr, String processedStr){
        if(unprocessedStr.isEmpty()){
            System.out.println(processedStr);
            return;
        }

        //the include case - where the char at 0 is included in the processed string
        printSubsequence(unprocessedStr.substring(1), processedStr + unprocessedStr.charAt(0));

        //the exclude case - where the char at 0 is not included in the processed string
        printSubsequence(unprocessedStr.substring(1), processedStr);
    }
}
