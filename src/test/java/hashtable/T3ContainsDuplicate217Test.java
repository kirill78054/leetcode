package hashtable;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class T3ContainsDuplicate217Test {

    @Test
    public void runTest() {
        boolean resOne = containsDuplicate(new int[]{1, 2, 3, 1});
        assertThat(resOne).isTrue();
        boolean resTwo = containsDuplicate(new int[]{1, 2, 3, 4});
        assertThat(resTwo).isFalse();
        boolean resThree = containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        assertThat(resThree).isTrue();
        boolean resFour = containsDuplicate(new int[]{3, 1});
        assertThat(resFour).isFalse();
        boolean resFive = containsDuplicate(new int[]{1, 5, -2, -4, 0});
        assertThat(resFive).isFalse();
    }

    public boolean containsDuplicate(int[] nums) {
        final int length = nums.length;
        if (length == 1) return false;
        if (length == 2) return nums[0] == nums[1];

        for (int i = 1; i < length; i++) {
            final int current = nums[i];
            int j = i - 1, prev = nums[j];
            if (current < prev) {
                while (true) {
                    nums[j + 1] = prev;
                    if (j-- == 0) break;
                    prev = nums[j];
                    if (current >= prev) break;
                }
                nums[j + 1] = current;
            }
            if (current == prev) return true;
        }
        return false;
    }

}
