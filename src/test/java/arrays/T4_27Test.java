package arrays;

import org.junit.Test;

import java.util.Arrays;

/*
Given an integer array and an integer , remove all occurrences of in in-place. The relative order of the elements may be changed.numsvalvalnums

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
 */
public class T4_27Test {

    @Test
    public void solutionTest() {
        int[] nums = {3, 2, 2, 3};
        int result = removeElement(nums, 3); // 2,4,3,1
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int tmp = nums[i];
                nums[i] = nums[length];
                nums[length] = tmp;
                length++;
            }
        }

        return length;
    }

}