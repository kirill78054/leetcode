package arrays_and_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/

public class T13ReverseWordsInString3557Test {

    @Test
    public void runTest() {
        assertThat(reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc");
        assertThat(reverseWords("Mr Ding")).isEqualTo("rM gniD");
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i);
                i++;
                start = i;
            }
        }
        reverse(chars, start, s.length());
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        int index = (end - start + 1) / 2;
        for (int i = 0; i < index; i++) {
            char tmp = chars[start];
            chars[start] = chars[end - 1 - i];
            chars[end - 1 - i] = tmp;
            start++;
        }
    }

}
