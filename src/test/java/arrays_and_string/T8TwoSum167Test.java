package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
*/

public class T8TwoSum167Test {

    @Test
    public void runTest() {
        assertArrayEquals(new int[]{4, 5}, twoSum(new int[]{-1, -1, -1, 0, 1}, 1));
        assertArrayEquals(new int[]{1, 5}, twoSum(new int[]{-1, -1, -1, 0, 1}, 0));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
        assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{-1, 0, 1}, 0));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return new int[]{++left, ++right};
    }

}
