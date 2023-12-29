package com.bipul.algorithms;

import com.bipul.datastructures.heap.implementation.MinHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {
    //BitSet can be used here for encoder and decoder for better implementation!
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    //we want to create our MinHeap/PQ in the constructor itself!
    public HuffmanCoder(String feeder) throws Exception {

        //create the frequency map of the feeder
        HashMap<Character, Integer> fMap = getFrequencyMap(feeder);

        //create the min heap using the freq map
        MinHeap<Node> heap = new MinHeap<>();
        //creating a set of all the entries in the map
        Set<Map.Entry<Character, Integer>> entrySet = fMap.entrySet();
        for(Map.Entry<Character, Integer> entry: entrySet){
            heap.insert(new Node(entry.getKey(), entry.getValue()));
        }

        //while heap size remains 1, remove 2 elements and combine
        while (heap.size() != 1){
            Node first = heap.remove();
            Node second = heap.remove();

            Node node = new Node('\0', first.cost+second.cost);
            node.left = first;
            node.right = second;
            heap.insert(node);
        }

        //Now we have the MinHeap, we want to get the root node of the heap (full tree node) and form encoder and decoder
        Node ft = heap.remove();
        //initialize the encoder/decoder
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        initialiseEncoderDecoder(ft, ""); //osf will be blank when starting
    }

    //recursive function to create the output for encode/decode
    //osf => output so far
    private void initialiseEncoderDecoder(Node node, String osf){
        if(node == null) return;

        //whenever we find a leaf node, we put the value in the encoder and decoder hashmaps
        if(node.left == null && node.right == null){
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }

        //recurse left and right and append 0 or 1 respectively
        initialiseEncoderDecoder(node.left, osf + "0");
        initialiseEncoderDecoder(node.right, osf + "1");
    }

    //create the frequency map for the given string
    private HashMap<Character, Integer> getFrequencyMap(String feeder){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            Character chr = feeder.charAt(i);
            freqMap.put(chr, freqMap.getOrDefault(chr, 0) + 1);
        }
        return freqMap;
    }

    public String encode(String data){
        StringBuilder encodedStr = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            Character ch = data.charAt(i);
            encodedStr.append(encoder.get(ch));
        }
        return encodedStr.toString();
    }

    public String decode(String encodedData){
        StringBuilder decodedStr = new StringBuilder();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < encodedData.length(); i++) {
            Character ch = encodedData.charAt(i);
            key.append(ch);
            if(decoder.containsKey(key.toString())){
                decodedStr.append(decoder.get(key.toString()));
                key = new StringBuilder();
            }
        }
        return decodedStr.toString();
    }

    private class Node implements Comparable<Node>{
        Character data;
        int cost; //another term for frequency
        Node left;
        Node right;

        public Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

}
