package arrays;

import org.junit.Test;

/*
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
*/
public class T27Test {

    @Test
    public void solutionTest() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement(nums, 2);// [0,1,3,0,4,_,_,_]
        System.out.println(i);

        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int resultSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[resultSize++] = nums[i];
            }
        }

        return resultSize;
    }

}