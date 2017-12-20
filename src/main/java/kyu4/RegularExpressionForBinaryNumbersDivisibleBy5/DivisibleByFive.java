package kyu4.RegularExpressionForBinaryNumbersDivisibleBy5;

import java.util.regex.Pattern;

public class DivisibleByFive {

    public static Pattern pattern() {
        // Partial solution:
        return Pattern.compile("^0|(101(0)*)$");
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(Integer.toBinaryString(i * 5));
            System.out.print(" ");
            System.out.print(Integer.toString(i * 5));
            System.out.println();
        }
    }

}