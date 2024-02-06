package hashtable;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class T6HappyNumber202Test {

    @Test
    public void runTest() {
        assertThat(isHappy(8)).isFalse();
        assertThat(isHappy(7)).isTrue();
        assertThat(isHappy(19)).isTrue();
        assertThat(isHappy(1111111)).isTrue();
        assertThat(isHappy(18)).isFalse();
        assertThat(isHappy(17)).isFalse();
        assertThat(isHappy(2)).isFalse();
    }

    public boolean isHappy(int n) {
        if (isHappyNum(n)) return true;
        while (n > 9) {
            n = sum(n);
            if (isHappyNum(n)) return true;
        }
        return false;
    }

    private boolean isHappyNum(int n) {
        return n == 1 || n == 7;
    }

    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            int tmp = num % 10;
            sum += tmp * tmp;
            num /= 10;
        }
        return sum;
    }

}
