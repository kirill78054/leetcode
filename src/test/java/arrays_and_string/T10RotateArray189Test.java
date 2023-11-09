package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
*/

public class T10RotateArray189Test {

    @Test
    public void runTest() {
        int[] numsFirst = {1, 2, 3, 4, 5, 6, 7};
        minSubArrayLen(numsFirst, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, numsFirst);

        int[] numsSecond = {-1, -100, 3, 99};
        minSubArrayLen(numsSecond, 2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, numsSecond);

        int[] numbsThird = {1, 2};
        minSubArrayLen(numbsThird, 3);
        assertArrayEquals(new int[]{2, 1}, numbsThird);
    }

    public void minSubArrayLen(int[] nums, int k) {
        if(k >= nums.length) {
            k = k % nums.length;
        }

        int [] tmpArrray = new int[k];

        int x = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            tmpArrray[x] = nums[i];
            x++;
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < tmpArrray.length; i++) {
            nums[i] = tmpArrray[i];
        }
    }

}
