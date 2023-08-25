package com.bipul.subset;

import java.util.ArrayList;

//printing all sub-sequence of a string using iteration (instead of recursion)
public class allSubsequenceIteration {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(printSubsequence(str));
    }

    static ArrayList<String> printSubsequence(String str){
        ArrayList<String> listSubseq = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            //possibilities with index i (adding them to the existing possibilities)
            int existingAnswers = listSubseq.size();
            if(existingAnswers != 0){
                for(int j=0; j<existingAnswers; j++){
                    listSubseq.add(listSubseq.get(j) + str.charAt(i));
                }
            }else{
                listSubseq.add(String.valueOf(str.charAt(i)));
                listSubseq.add("");
            }
        }
        return listSubseq;
    }
}
