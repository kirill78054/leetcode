package arrays;

import org.junit.Test;

/*
Input: arr = [10,2,5,3]
Output: true
Input: arr = [3,1,7,11]
Output: false
*/
public class TCheckIfExist1346Test {

    @Test
    public void solutionTest() {
        int[] nums = {10, 2, 7, 3};
        System.out.println(checkIfExist(nums));
    }

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] * 2 == arr[j]) return true;
            }
        }
        return false;
    }

}