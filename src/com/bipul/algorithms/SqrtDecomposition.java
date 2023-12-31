package com.bipul.algorithms;

import java.util.Arrays;

//also called Mo's algo I think
public class SqrtDecomposition {

    //find the sum of range in the given query - similar technique for other range queries
    //can be used for any rule based range question
    public int rangeQuery(int[] arr, int l, int r){
        int len = arr.length;

        //building preprocessed block/chunk array
        int sqrt = (int) Math.sqrt(len);

        //the blocks array should have indices till the sqrt value of n+1 (+1 to store extra spill-off items)
        //suppose we have 10 elements, and sqrt value is 3. So we store 3*3 = 9 in 3 blocks. We would need 4th to store the 10th item (spilloff) -> hence sqrt+1
        int[] blocks = new int[sqrt+1];
        int block_id = -1; //start with -1, +1 to 0

        //forming the block array. We aren't storing any value yet. We can do any query, eg. sum later
        for (int i = 0; i < len; i++) {
            //new block is starting
            if(i % sqrt == 0){
                block_id++;
            }
            blocks[block_id] += arr[i]; //keep adding to the current block!
        }
        System.out.println("Block array: " + Arrays.toString(blocks));
        return query(blocks, arr, l, r, sqrt);
    }

    //we will do the sum query here
    private static int query(int[] blocks, int[] arr, int l, int r, int sqrt){
        int ans = 0;
            //left
            while (l%sqrt != 0 && l<r && l!=0){
                ans += ans+arr[l];
                l++;
            }
            //middle
            while (l + sqrt <= r){
                ans += blocks[l/sqrt];
                l += sqrt; //we move the entire block forward
            }
            //right
            while(l <= r && l<arr.length){
                ans += arr[l];
                l++;
            }
        return ans;
    }

    private void update(int[] blocks, int[] arr, int i, int val, int sqrt){
        int block_id = i/sqrt;
        blocks[block_id] += (val - arr[i]); //new value - old value in the block sum
        arr[i] = val; //update the original array
    }
}
