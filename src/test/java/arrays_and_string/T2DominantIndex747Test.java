package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is,
return the index of the largest element, or return -1 otherwise.
Input: nums = [3,6,1,0]
Output: 1
*/

public class T2DominantIndex747Test {

    @Test
    public void runTest() {
        assertEquals(1, dominantIndex(new int[]{3, 6, 1, 0}));
        assertEquals(-1, dominantIndex(new int[]{1, 2, 3, 4}));
    }

    public int dominantIndex(int[] nums) {
        int result = -1, firstMax = 0, secondMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                result = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        if (firstMax / 2 >= secondMax) return result;
        return -1;
    }

}
