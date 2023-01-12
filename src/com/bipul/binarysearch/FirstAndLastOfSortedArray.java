package com.bipul.binarysearch;

public class FirstAndLastOfSortedArray {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = firstAndLastIndexOfSortedArray(arr, target);
        System.out.println(ans[0] + "; " + ans[1]);
    }

    static int[] firstAndLastIndexOfSortedArray(int[] arr, int target){
        int ans[] = {-1, -1};
        ans[0] = binarySearchIndex(arr, target, true);
        if(ans[0] != -1){
            ans[1] = binarySearchIndex(arr, target, false);
        }
        return ans;
    }

    static int binarySearchIndex(int[] arr, int target, boolean isStart){
        int ans = -1;
        int s = 0;
        int e = arr.length-1;
        while(s<=e) {
            int m = s + (e - s) / 2;
            if (target == arr[m]) {
                ans = m;
                if(isStart){
                    e=m-1;
                }else{
                    s=m+1;
                }
            } else if (target > arr[m])
                s = s+1;
            else
                e = m-1;
        }
        return ans;
    }
}
