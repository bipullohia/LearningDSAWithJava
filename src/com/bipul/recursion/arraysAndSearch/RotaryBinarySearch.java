package com.bipul.recursion.arraysAndSearch;

public class RotaryBinarySearch {

    /*
        Suppose an array is given:
        [5,6,7,8,9,1,2,3] - this array is sorted in rotation
        We have to find if an element n is present in the above array
     */

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int target = 6;
        System.out.println(RBS(arr, target, 0, arr.length-1));
    }

    /* Implementation
    Assumptions:
    1.

    Params:
    array to be searched into, target element, start element, end element

    Return value:
    position of the element (-1 if not found)
 */
    static int RBS(int[] arr, int target, int s, int e){
        //base condition - means the search is complete now
        if(s>e)
            return -1;

        int m = s + (e-s)/2;
        if(arr[m] == target)
            return m;

        //if first half of the array is less than mid - first half is sorted
        if(arr[s] <= arr[m]){
            //check if key is also in this range
            if(target >= arr[s] && target <= arr[m])
                return RBS(arr, target, s, m-1);
            else
                return RBS(arr, target, m+1, e);
        }

        //if the first half of the array is not sorted compared to mid, we know the flip point is in the first half, and so let's check if target is in 2nd half
        if(target >= arr[m] && target <= arr[e])
            return RBS(arr, target, m+1, e);
        //the flip exists somewhere in first half and the target is this first half
        else
            return RBS(arr, target, s, m-1);
    }
}
