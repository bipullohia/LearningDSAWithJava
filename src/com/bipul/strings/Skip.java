package com.bipul.strings;

public class Skip {
    public static void main(String[] args) {
        String str = "hello Omello";
        char charToSkip = 'l';
        String strToSkip = "llo";

        skipChar(str, "", charToSkip);
        skipChar2(str, charToSkip);

        System.out.println();
        System.out.println(skipString(str, strToSkip));
    }

    /*
    Skip a Char - will skip a particular char from the input string
    Skip a String - will skip a phrase/string from the input string
     */

    static String skipString(String inputStr, String strToSkip){
        if(inputStr.isEmpty()) return "";

        if(inputStr.startsWith(strToSkip)){
            return skipString(inputStr.substring(strToSkip.length()), strToSkip);
        }else{
            return inputStr.charAt(0) + skipString(inputStr.substring(1), strToSkip);

        }
    }

    //this will print the result char by char
    //in this way, we are accumulating the result in a param in recursive func itself
    static void skipChar(String inputStr, String result, char charToSkip){
        if(inputStr.isEmpty()){
            //input string becomes empty, we can print the result
            System.out.println(result);
            return;
        }

        char c = inputStr.charAt(0);
        if(c == charToSkip){
            //input string will now move to the next char, result will have no additional chars in the string
            skipChar(inputStr.substring(1), result, charToSkip);
        }else{
            //input string will now move to the next char, result will have this char added in the string
            skipChar(inputStr.substring(1), result+c, charToSkip);
        }
    }

    //this will not need an argument for result, since it will print step by step anyway
    static void skipChar2(String inputStr, char charToSkip){
        if(inputStr.isEmpty()){
            return;
        }

        char c = inputStr.charAt(0);
        if(c != charToSkip)
            //prints the char if it is not the one to be skipped
            System.out.print(c);

        //goes on to process the next set of chars in the string
        skipChar2(inputStr.substring(1), charToSkip);
    }

}
