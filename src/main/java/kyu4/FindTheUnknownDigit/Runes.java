package kyu4.FindTheUnknownDigit;

import java.util.Arrays;
import java.util.TreeSet;

public class Runes {
    public static int solveExpression(final String expression) {
        System.out.println(expression);
        TreeSet<Integer> possibleNumbers = new TreeSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        if (expression.matches("\\?\\*..+=\\?\\?")) {
            possibleNumbers.remove(0);
        } else if (expression.contains("-?") || expression.contains("+?") || expression.contains("*?") || expression.contains("=?") || expression.charAt(0) == '?') {
            possibleNumbers.remove(0);
        } else if (expression.contains("*?=?")) {
            possibleNumbers.add(0);
        } else if (expression.charAt(0) == '?' && (expression.charAt(1) == '*' || expression.charAt(1) == '+' || expression.charAt(1) == '-')) {
            possibleNumbers.add(0);
        }

        char[] chars = expression.toCharArray();
        for (char aChar : chars) {
            int possibleNo = aChar - '0';
            if (possibleNo >= 0 && possibleNo < 10) {
                possibleNumbers.remove(possibleNo);
            }
        }

        while (!possibleNumbers.isEmpty()) {
            Integer i = possibleNumbers.pollFirst();
            String newExpression = expression.replace('?', Integer.toString(i).charAt(0));

            if (evaluateExpression(newExpression)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean evaluateExpression(String newExpression) {
        String[] split = newExpression.split("=");
        String[] strings = splitByOperator(split[0]);
        int resultRight = Integer.parseInt(split[1]);
        int a = 0, b = 0, amountParsed = 0;

        for (String string : strings) {
            try {
                int temp = Integer.parseInt(string);
                if (amountParsed == 0) {
                    a = temp;
                } else {
                    b = temp;
                }
                amountParsed++;
            } catch (Exception ignored) {
            }
        }

        if (split[0].charAt(0) == '-') {
            a = a * -1;
        }
        if (split[0].contains("--") || split[0].contains("+-") || split[0].contains("*-")) {
            b = b * -1;
        }

        if (split[0].contains("+")) {
            return a + b == resultRight;
        } else if (split[0].contains("*")) {
            return a * b == resultRight;
        } else {
            return a - b == resultRight;
        }
    }

    private static String[] splitByOperator(String s) {
        return s.split("\\*-|\\+|-|\\*|--|\\+-");
    }
}