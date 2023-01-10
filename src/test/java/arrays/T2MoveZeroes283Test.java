package arrays;

import org.junit.Test;

/*
Given an integer array , move all 's to the end of it while maintaining the relative order of the non-zero elements.nums0
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Input: nums = [0]
Output: [0]
 */
public class T2MoveZeroes283Test {

    @Test
    public void solutionTest() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);// [1,3,12,0,0]

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZero];
                nums[nonZero] = temp;
                nonZero++;
            }
        }
    }

}