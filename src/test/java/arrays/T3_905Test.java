package arrays;

import org.junit.Test;

import java.util.Arrays;

/*
Given an integer array , move all the even integers at the beginning of the array followed by all the odd integers.nums
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
 */
public class T3_905Test {

    @Test
    public void solutionTest() {
        int[] nums = {3, 1, 2, 4};
        int[] result = sortArrayByParity(nums); // 2,4,3,1
        System.out.println(Arrays.toString(result));
    }

    public int[] sortArrayByParity(int[] nums) {
        int parity = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[i];
                nums[i] = nums[parity];
                nums[parity] = tmp;
                parity++;
            }
        }
        return nums;
    }

}