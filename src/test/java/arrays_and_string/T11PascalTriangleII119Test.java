package arrays_and_string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
row = 3
       1
      1 1
     1 2 1
    1 3 3 1 <---
   1 4 6 4 1

*/

public class T11PascalTriangleII119Test {

    @Test
    public void runTest() {
        List<Integer> resultOne = new ArrayList<>();
        resultOne.add(1);
        resultOne.add(3);
        resultOne.add(3);
        resultOne.add(1);
        assertEquals(resultOne, getRow(3));

        List<Integer> resultTwo = new ArrayList<>();
        resultTwo.add(1);
        assertEquals(resultTwo, getRow(0));

        List<Integer> resultThree = new ArrayList<>();
        resultThree.add(1);
        resultThree.add(1);
        assertEquals(resultThree, getRow(1));

        List<Integer> resultFour = new ArrayList<>();
        resultFour.add(1);
        resultFour.add(4);
        resultFour.add(6);
        resultFour.add(4);
        resultFour.add(1);
        assertEquals(resultFour, getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
        }

        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                int res = result.get(j) +   result.get(j - 1);
                result.remove(j);
                result.add(j, res);
            }
        }
        return result;
    }

}
