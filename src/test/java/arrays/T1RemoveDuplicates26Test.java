package arrays;

import org.junit.Test;

public class T1RemoveDuplicates26Test {

    @Test
    public void solutionTest() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);// [0,1,2,3,4,_,_,_,_,_]
        System.out.println(i);

        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int resultSize = 1;
        int currentNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != currentNum) {
                nums[resultSize++] = nums[i];
                currentNum = nums[i];
            }
        }

        return resultSize;
    }

}