package arrays;

import org.junit.Test;

import java.util.Arrays;

/*
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
 */
public class T5HeightChecker1051Test {

    @Test
    public void solutionTest() {
        int[] nums = {2,1,2,1,1,2,2,1};
        int result = heightChecker(nums); // 1,1,1,2,3,4
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public int heightChecker(int[] nums) {
        int [] mas = new int[nums.length];
        System.arraycopy(nums, 0, mas, 0, nums.length);
        for (int i = 0; i < nums.length - 1 ; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != mas[i]) {
                result++;
            }
        }

        return result;
    }

}