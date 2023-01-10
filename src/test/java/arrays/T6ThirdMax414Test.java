package arrays;

import org.junit.Test;

import java.util.Arrays;

/*
Given an integer array , return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.nums

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
 */
public class T6ThirdMax414Test {

    @Test
    public void solutionTest() {
        int[] nums = {1,2,2};
        int result = thirdMax(nums); // 1
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public int thirdMax(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 1) {
            return nums[0];
        }

        long max = Long.MIN_VALUE, sMax = Long.MIN_VALUE, tMax = Long.MIN_VALUE;
        for (int i : nums) {
            if (i > max) {
                tMax = sMax;
                sMax = max;
                max = i;
            } else if (i > sMax && i != max) {
                tMax = sMax;
                sMax = i;
            } else if (i > tMax && i != sMax && i != max) {
                tMax = i;
            }
        }

        return tMax == Long.MIN_VALUE ? (int) max : (int) tMax;
    }

}