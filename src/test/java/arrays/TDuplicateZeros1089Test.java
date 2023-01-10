package arrays;

import org.junit.Test;

/*
Given a fixed-length integer array , duplicate each occurrence of zero, shifting the remaining elements to the right.arr
*/
public class TDuplicateZeros1089Test {

    @Test
    public void solutionTest() {
        int[] nums1 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums1); // 1 0 0 2 3 0 0 4
        printArray(nums1);

        int[] nums2 = {0, 0, 0, 0, 0, 0, 0};
        duplicateZeros(nums2);
        printArray(nums2);

        int[] nums3 = {1, 0, 0, 2, 3, 0, 0, 4};
        duplicateZeros(nums3); // 1 0 0 0 0 2 3 0
        printArray(nums3);

        int[] nums4 = {8, 4, 5, 0, 0, 0, 0, 7};
        duplicateZeros(nums4); // 8 4 5 0 0 0 0 0
        printArray(nums4);
    }

    public void duplicateZeros(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == 0 && x != arr.length - 1) {
                for (int y = arr.length - 2; y >= x; y--) {
                    arr[y + 1] = arr[y];
                }
                arr[x] = arr[x + 1];
                x++;
            }
        }
    }

    void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}