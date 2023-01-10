package arrays;

import org.junit.Test;

/*
При заданном массиве целых чисел верните, сколько из них содержит четное число цифр
*/
public class TFindNumbers1295Test {

    @Test
    public void solutionTest() {
        int[] mas = {12,345,2,6,7896, 100000000};
        System.out.println(findNumbers(mas));
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for(int number : nums){
            int length;
            if (number < 100_000) {
                if (number < 100) {
                    if (number < 10) {
                        length = 1;
                    } else {
                        length = 2;
                    }
                } else {
                    if (number < 1000) {
                        length = 3;
                    } else {
                        if (number < 10_000) {
                            length = 4;
                        } else {
                            length = 5;
                        }
                    }
                }
            } else {
                if (number < 10_000_000) {
                    if (number < 1000_000) {
                        return 6;
                    } else {
                        return 7;
                    }
                } else {
                    if (number < 100_000_000) {
                        length = 8;
                    } else {
                        if (number < 1000_000_000) {
                            length = 9;
                        } else {
                            length = 10;
                        }
                    }
                }
            }
            if(length % 2 == 0) {
                result++;
            }
        }

        return result;
    }

}