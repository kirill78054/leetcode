package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
*/

public class T5LongestCommonPrefix14Test {

    @Test
    public void runTest() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"", "b"}));
        assertEquals("", longestCommonPrefix(new String[]{""}));
        assertEquals("", longestCommonPrefix(new String[]{"c", ""}));
        assertEquals("", longestCommonPrefix(new String[]{"cc", ""}));
        assertEquals("a", longestCommonPrefix(new String[]{"a", "ac"}));
    }

    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);

                if (result.isEmpty()) result = "";
            }
        }

        return result;
    }

}
