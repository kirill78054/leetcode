package hashtable;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
public class T11IntersectionTwoArraysII350Test {

    @Test
    public void runTest() {
        assertThat(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).isEqualTo(new int[]{2, 2});
        assertThat(intersect(new int[]{1, 1, 1, 1}, new int[]{2, 3, 4, 1})).isEqualTo(new int[]{1});
        assertThat(intersect(new int[]{1, 1, 1, 1}, new int[]{2, 3, 1, 1})).isEqualTo(new int[]{1, 1});
        assertThat(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).isEqualTo(new int[]{9, 4});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] tmp = new int[10001];
        for (int i : nums1) {
            tmp[i] = tmp[i] + 1;
        }

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i : nums2) {
            if (tmp[i] != 0) {
                tmp[i] = tmp[i] - 1;
                result[index++] = i;
            }
        }

        return Arrays.copyOf(result, index);
    }

}
