package arrays_and_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Given two strings needle and haystack,
 return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class T4StrStr28Test {

    @Test
    public void runTest() {
        assertEquals(0, strStr("sadbutsad", "sad"));
        assertEquals(-1, strStr("leetcode", "leeto"));
        assertEquals(0, strStr("a", "a"));
        assertEquals(2, strStr("abc", "c"));
        assertEquals(0, strStr("aaa", "a"));
    }

    public int strStr(String haystack, String needle) {
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int findStgLength = haystackChar.length - needleChar.length;

        for (int i = 0; i < haystackChar.length; i++) {
            if (i > findStgLength) return -1;
            if (haystackChar[i] == needleChar[0]) {
                if (i == haystackChar.length - 1 || needleChar.length == 1) return i;
                for (int j = 1; j < needleChar.length; j++) {
                    if (haystackChar[i + j] == needleChar[j]) {
                        if (j == needleChar.length - 1) return i;
                        continue;
                    }
                    break;
                }
            }
        }

        return -1;
    }
}
