package arrays;

import org.junit.Test;

//Заданный двоичный массив , верните максимальное число последовательных 's в массиве.nums1
public class T485Test {

    @Test
    public void findMaxConsecutiveOnesTest() {
        int[] requestOne = {1, 0, 1, 1, 0, 1};
        int[] requestTwo = {1, 1, 0, 1, 1, 1};
        System.out.println("result 1 = " + findMaxConsecutiveOnes(requestOne)); //2
        System.out.println("result 2 = " + findMaxConsecutiveOnes(requestTwo)); //3
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                result = Math.max(result, ++count);
            } else {
                count = 0;
            }
        }
        return result;
    }

}
