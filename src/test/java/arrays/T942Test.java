package arrays;

import org.junit.Test;

/*
Given an array of integers , return true if and only if it is a valid mountain array.arr
Input: arr = [3,5,5]
Output: false
[1,1,1,1,1,1,1,2,1]
Input: arr = [0,3,2,1]
Output: true
*/
public class T942Test {

    @Test
    public void solutionTest() {
        int[] nums = {0,3,2,1};
        System.out.println(validMountainArray(nums));
    }

    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int max = 0;
        int positionMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                positionMax = i;
            }
        }
        if (positionMax == 0 || max == arr[arr.length - 1]) return false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (i < positionMax) {
                if (arr[i] >= arr[i + 1]) {
                    return false;
                }
            } else {
                if (arr[i] <= arr[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

}