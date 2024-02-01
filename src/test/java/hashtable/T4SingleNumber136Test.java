package hashtable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class T4SingleNumber136Test {

    @Test
    public void runTest() {
        int resOne = singleNumber(new int[]{2, -1, 2});
        assertThat(resOne).isEqualTo(-1);
        int resTwo = singleNumber(new int[]{4, 1, 2, 1, 2});
        assertThat(resTwo).isEqualTo(4);

        int resThree = singleNumber(new int[]{1});
        assertThat(resThree).isEqualTo(1);

        int resFour = singleNumber(new int[]{1, 2, -1, -5, 33, 1, 2, -5, 33});
        assertThat(resFour).isEqualTo(-1);
    }

    public int singleNumberMe(int[] nums) {
        Set<Integer> uniqueNumbs = new HashSet<>();

        for (int num : nums) {
            if (!uniqueNumbs.add(num)) {
                uniqueNumbs.remove(num);
            }
        }
        return uniqueNumbs.iterator().next();
    }

    public int singleNumber(int[] nums) {
        return xor(0, nums);
    }

    private int xor(int index, int[] nums) {
        if (index >= nums.length) return 0;
        return nums[index++] ^ xor(index, nums);
    }

}
