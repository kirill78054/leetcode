package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/

public class T3PlusOne66Test {

    @Test
    public void runTest() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void runRecursiveTest() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOneRecursive(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOneRecursive(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, plusOneRecursive(new int[]{9}));
    }

    public int[] plusOneRecursive(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        plusOneRecursive(digits, digits.length - 1);

        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    private int[] plusOneRecursive(int[] digits, int i) {
        if (i < 0) return digits;
        if (digits[i] == 9) {
            digits[i] = 0;
            return plusOneRecursive(digits, i - 1);
        }
        digits[i]++;
        return digits;
    }

}
