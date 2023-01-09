package arrays;

import org.junit.Test;

/*

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation:
1st customer has wealth = 6
2nd customer has wealth = 10
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
*/
public class T1672Test {

    @Test
    public void maximumWealthTest() {
        int[][] request = {{1, 5}, {7, 3}, {3, 5}};
        System.out.print("result = " + maximumWealth(request));
    }

    public int maximumWealth(int[][] request) {
        int result = 0;
        for (int[] ints : request) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (result < sum) result = sum;
        }
        return result;
    }

}