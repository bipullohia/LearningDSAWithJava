package com.bipul.algorithms;

//An algorithm used for string and substring matching using hash values
public class KarpRabin {

    private final int PRIME = 101; //used for generating hashcode

    private double calculateHash(String str){
        double hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash + str.charAt(i)*Math.pow(PRIME, i);
        }
        return hash;
    }
    //Here, we will try to match substring using something called rolling search (remove 1 char and add 1 char to the search)
    private double updateHash(double prevHash, int patternLength, int oldChar, int newChar){
        double newHash = (prevHash-oldChar)/PRIME;
        newHash = newHash + newChar*Math.pow(PRIME, patternLength-1);
        return newHash;
    }

    //karp rabin algo (find a pattern in text)
    public void search(String text, String pattern){
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, pattern.length())); //taking the first set of chars for comparison (we will keep moving this by 1)

        for (int i = 0; i < text.length()-pattern.length(); i++) {
            if(textHash == patternHash){
                if(text.substring(i, i+pattern.length()).equals(pattern)){
                    System.out.println("Found at index: " + i);
                    return;
                }
            }

            if(i<text.length()-pattern.length()){ //check again to prevent out of bounds
                textHash = updateHash(textHash, pattern.length(), text.charAt(i), text.charAt(i+pattern.length()));
            }
        }

        System.out.println("Oops, No such pattern found");
    }
}
