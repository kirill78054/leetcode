package arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
*/
public class T412Test {

    @Test
    public void solutionTest(){
        System.out.println(fizzBuzz(3));

    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int x = 1; x <= n; x++) {
            boolean three = x % 3 == 0;
            boolean five = x % 5 == 0;
            if(three && five ) {
                result.add("FizzBuzz");
            } else if(three) {
                result.add("Fizz");
            }else if(five) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(x));
            }
        }
        return result;
    }

}