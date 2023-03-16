package arrays_and_string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
Given an integer array of integers, group these integers into pairs such that the sum of for all is maximized.
Return the maximized sum.nums2nn(a1, b1), (a2, b2), ..., (an, bn)min(ai, bi)i
*/

public class T7ArrayPairSum561Test {

    @Test
    public void runTest() {
        assertEquals(4, arrayPairSum(new int[]{1, 4, 3, 2}));
        assertEquals(9, arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
        assertEquals(7, arrayPairSum(new int[]{7,3,1,0,0,6}));
        assertEquals(1, arrayPairSum(new int[]{1, 4}));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
