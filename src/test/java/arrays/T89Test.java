package arrays;

import org.junit.Test;

/*

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
*/
public class T89Test {

    @Test
    public void solutionTest() {
        int[] mas1 = {1,0};
        int[] mas2 = {2};

        merge(mas1, 1, mas2, 1);

        for (int num : mas1) {
            System.out.print(num + " ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int resultSIze = m + n;
        int[] result = new int[resultSIze];
        int length = 0;
        int currentMassTwo = 0;
        for (int x = 0; x < resultSIze; x++) {
            if(length == resultSIze) {
                break;
            }
            if(currentMassTwo >= n) {
                result[length] = nums1[x];
                length++;
                continue;
            }
            if(nums1[x] < nums2[currentMassTwo] && x < m) {
                result[length] = nums1[x];
            } else {
                result[length] = nums2[currentMassTwo++];
                x--;
            }
            length++;
        }


        for (int i = 0; i < resultSIze; i++) {
            nums1[i] = result[i];
        }
    }


}