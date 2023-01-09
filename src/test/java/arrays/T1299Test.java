package arrays;

import org.junit.Test;

/*
Given an array , replace every element in that array with the greatest element among the elements to its right,
and replace the last element with .arr-1

After doing so, return the array.
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Input: arr = [400]
Output: [-1]
*/
public class T1299Test {

    @Test
    public void solutionTest() {
        int[] nums = {17, 18, 5, 4, 6, 1}; // [18,6,6,6,1,-1]
        int[] ints = replaceElements(nums);
        for (int x : ints) {
            System.out.print(x + " ");
        }
    }

    public int[] replaceElements(int[] arr) {
        int curMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = curMax;
            curMax = Math.max(curMax, tmp);
        }
        return arr;
    }

}