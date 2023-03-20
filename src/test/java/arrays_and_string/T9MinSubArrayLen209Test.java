package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.
*/

public class T9MinSubArrayLen209Test {

    @Test
    public void runTest() {
        assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(1, minSubArrayLen(4, new int[]{1, 4, 4}));
        assertEquals(0, minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(8, minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
        assertEquals(3, minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        assertEquals(2, minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }

}
