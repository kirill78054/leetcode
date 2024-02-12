package hashtable;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
public class T10FirstUniqueCharacterInString387Test {

    @Test
    public void runTest() {
        assertThat(firstUniqChar("leetcode")).isEqualTo(0);
        assertThat(firstUniqChar("loveleetcode")).isEqualTo(2);
        assertThat(firstUniqChar("aabb")).isEqualTo(-1);
        assertThat(firstUniqChar("z")).isEqualTo(0);
    }

    // считается что более сложный вариант по времени, хотя и читабельней
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = s.lastIndexOf(ch);
            if (s.indexOf(ch) != index) continue;

            if (i == index) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int res = 100000;

        for (int i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index == -1) continue;

            if (index == s.lastIndexOf(i)) {
                res = Math.min(index, res);
            }
        }

        return res == 100000 ? -1 : res;
    }

    public int firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.replace(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            int res = map.get(chars[i]);
            if (res == 1) {
                return i;
            }
        }
        return -1;
    }

}
