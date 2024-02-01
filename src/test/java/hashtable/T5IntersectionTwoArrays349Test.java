package hashtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
public class T5IntersectionTwoArrays349Test {

    @Test
    public void runTest() {
        int[] resOne = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        assertThat(resOne).isEqualTo(new int[]{2});

        int[] resTwo = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        assertThat(resTwo).isEqualTo(new int[]{9, 4});
    }

    public int[] intersectionOne(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (final int current : nums1) {
            for (int i : nums2) {
                if (current == i) {
                    set.add(current);
                }
            }
        }

        int[] res = new int[set.size()];

        int index = 0;
        for (int i : set) {
            res[index] = i;
            index++;
        }

        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] tmp = new int[10001];

        ArrayList<Integer> resList = new ArrayList<>();

        for (int i : nums1) {
            tmp[i] = 1;
        }

        for (int i : nums2) {
            if (tmp[i] == 1) {
                resList.add(i);
                tmp[i]++;
            }
        }

        int[] res = new int[resList.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }

        return res;
    }


}
