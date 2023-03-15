package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
Write a function that reverses a string. The input string is given as an array of characters .s
You must do this by modifying the input array in-place with extra memory.O(1)
*/

public class T6ReverseString344Test {

    @Test
    public void runTest() {
        char[] charsOne = {'h', 'e', 'l', 'l', 'o'};
        reverseString(charsOne);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, charsOne);

        char[] charsTwo = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(charsTwo);
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, charsTwo);

        char[] charsThree = {'H'};
        reverseString(charsThree);
        assertArrayEquals(new char[]{'H'}, charsThree);
    }

    public void reverseString(char[] chars) {
        int head = 0, end = chars.length - 1;
        while (head < end) {
            char tmpHeadChar = chars[head];
            chars[head] = chars[end];
            chars[end] = tmpHeadChar;
            head++;
            end--;
        }
    }

}
