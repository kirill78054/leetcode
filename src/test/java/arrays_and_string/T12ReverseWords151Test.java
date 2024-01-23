package arrays_and_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
Given an input string s, reverse the order of the words.
Return a string of the words in reverse order concatenated by a single space.
*/

public class T12ReverseWords151Test {

    @Test
    public void runTest() {
        assertThat(reverseWords("the sky is blue")).isEqualTo("blue is sky the");
        assertThat(reverseWords("  hello world  ")).isEqualTo("world hello");
        assertThat(reverseWords("a good   example")).isEqualTo("example good a");
    }

    public String reverseWords(String s) {
        s = s.trim();

        StringBuilder str = new StringBuilder();
        int endWordPoint = findEndPointWord(s, s.length() - 1);
        int startWordPoint = findStartPointWord(s, endWordPoint);

        while (startWordPoint > 0) {
            str.append(s, startWordPoint, endWordPoint + 1);
            endWordPoint = findEndPointWord(s, startWordPoint);
            startWordPoint = findStartPointWord(s, endWordPoint);
        }

        str.append(" ");
        str.append(s, startWordPoint, endWordPoint + 1);
        return str.toString().trim();
    }

    private int findStartPointWord(String s, int index) {
        while (index > 0 && s.charAt(index) != ' ') {
            index--;
        }
        return index;
    }

    private int findEndPointWord(String s, int index) {
        while (index > 0 && s.charAt(index) == ' ') {
            index--;
        }
        return index;
    }

}
