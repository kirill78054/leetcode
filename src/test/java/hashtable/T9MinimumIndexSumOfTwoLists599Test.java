package hashtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * A common string is a string that appeared in both list1 and list2.
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 * Return all the common strings with the least index sum. Return the answer in any order.
 */
public class T9MinimumIndexSumOfTwoLists599Test {

    @Test
    public void runTest() {
        assertThat(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}))
                .isEqualTo(new String[]{"Shogun"});
        assertThat(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"}))
                .isEqualTo(new String[]{"Shogun"});
        assertThat(findRestaurant(new String[]{"happy", "sad", "good"}, new String[]{"sad", "happy", "good"}))
                .isEqualTo(new String[]{"sad", "happy"});
        assertThat(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"}))
                .isEqualTo(new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"});
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE, currentSum;

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                currentSum = i + map.get(list2[i]);
                if (currentSum < minSum) {
                    list.clear();
                    list.add(list2[i]);
                    minSum = currentSum;
                } else if (currentSum == minSum) {
                    list.add(list2[i]);
                }
            }
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public String[] findRestaurant1(String[] str1, String[] str2) {
        ArrayList<String> list = new ArrayList<>();
        int commonIndex = Integer.MAX_VALUE;

        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i].equals(str2[j])) {
                    if (i + j < commonIndex) {
                        commonIndex = i + j;
                        list.clear();
                        list.add(str1[i]);
                    } else if (i + j == commonIndex) {
                        commonIndex = i + j;
                        list.add(str1[i]);
                    }
                }
            }
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
