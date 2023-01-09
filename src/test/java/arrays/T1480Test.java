package arrays;

import org.junit.Test;

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
*/
public class T1480Test {

    @Test
    public void solutionTest(){
        int [] request = {1, 2, 3, 4};
        int[] res = runningSum(request);
        for (int re : res) {
            System.out.print(re + ", ");
        }
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}