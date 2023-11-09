package sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void callTest() {
        int[] mas = {1, 3, 2, -1, 7, -9};
        int[] mas2 = {1, 54, -8, 0, 71, 12, 7, 6, 12, -3, 72};

        quickSort(mas2, 0, mas2.length - 1);

        Arrays.stream(mas2).forEach(System.out::println);
    }

    private void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (array.length == 0 || leftIndex >= rightIndex) return;

        int pivot = array[(leftIndex + rightIndex) / 2];
        int leftCurrent = leftIndex, rightCurrent = rightIndex;

        while (leftCurrent <= rightCurrent) {
            while (array[leftCurrent] < pivot) leftCurrent++;
            while (array[rightCurrent] > pivot) rightCurrent--;

            if (leftCurrent <= rightCurrent) {
                int swap = array[leftCurrent];
                array[leftCurrent] = array[rightCurrent];
                array[rightCurrent] = swap;

                leftCurrent++;
                rightCurrent--;
            }
        }
        if (leftIndex < rightCurrent) quickSort(array, leftIndex, rightCurrent);
        if (rightIndex > leftCurrent) quickSort(array, leftCurrent, rightIndex);
    }

}
