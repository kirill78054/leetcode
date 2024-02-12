package hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class T12ContainsDuplicateII219Test {

    @Test
    public void runTest() {
        assertThat(containsNearbyDuplicate1(new int[]{1, 2, 3, 1}, 3)).isTrue();
        assertThat(containsNearbyDuplicate1(new int[]{1, 0, 1, 1}, 1)).isTrue();
        assertThat(containsNearbyDuplicate1(new int[]{1, 0, 3, 4, 4}, 1)).isTrue();
        assertThat(containsNearbyDuplicate1(new int[]{1, 2, 3, 1, 2, 3}, 2)).isFalse();
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                int ind = i - k - 1;
                int num = nums[ind];
                tmp.remove(num);
            }
            if (!tmp.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int abs = Math.abs(map.get(nums[i]) - i);
                if (abs <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

}
