package hashtable;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class T7TwoSum1Test {

    @Test
    public void runTest() {
        assertThat(twoSum(new int[]{2, 7, 11, 15}, 9)).isEqualTo(new int[]{0, 1});
        assertThat(twoSum(new int[]{3, 2, 4}, 6)).isEqualTo(new int[]{1, 2});
        assertThat(twoSum(new int[]{3, 3}, 6)).isEqualTo(new int[]{0, 1});
        assertThat(twoSum(new int[]{-3, 2, 6}, 3)).isEqualTo(new int[]{0, 2});
        assertThat(twoSum(new int[]{3, 5, -9, 0}, -9)).isEqualTo(new int[]{2, 3});
        assertThat(twoSum(new int[]{3, 5, -9, 9}, 0)).isEqualTo(new int[]{2, 3});
        assertThat(twoSum(new int[]{1, 5, -9, 3}, -6)).isEqualTo(new int[]{2, 3});
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= target) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= target) continue;
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

}
