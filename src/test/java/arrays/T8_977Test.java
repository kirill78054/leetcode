package arrays;

import org.junit.Test;

/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
public class T8_977Test {

    @Test
    public void solutionTest() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);

        for (int num : result) System.out.print(num + " ");
    }

    public int[] sortedSquares(int[] nums) {
        int start = 0, end = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int startNum = nums[start] * nums[start];
            int endNum = nums[end] * nums[end];
            if (endNum > startNum) {
                result[i] = endNum;
                end--;
            } else {
                result[i] = startNum;
                start++;
            }
        }

        return result;
    }

}