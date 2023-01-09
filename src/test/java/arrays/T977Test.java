package arrays;

import org.junit.Test;

/*
При наличии целочисленного массива, отсортированного в возрастающем порядке,
возвращает массив квадратов каждого числа, отсортированный в возрастающем порядке nums.
*/
public class T977Test {

    @Test
    public void solutionTest() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums); // [0,1,9,16,100]
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] sortedSquares(int[] ar) {
        int pointStart = 0;
        int pointEnd = ar.length - 1;
        int idx = ar.length - 1;

        int[] result = new int[ar.length];

        while (pointStart <= pointEnd) {
            int i1 = ar[pointStart] * ar[pointStart];
            int i2 = ar[pointEnd] * ar[pointEnd];
            if (i1 < i2) {
                result[idx--] = i2;
                pointEnd--;
            } else {
                result[idx--] = i1;
                pointStart++;
            }
        }

        return result;
    }

}