package kyu3.TheMillionthFibonacciKata;

import java.math.BigInteger;

public class FibonacciRecursive {

    public static BigInteger fib(BigInteger n) {
        int i = n.intValue();
        if (i < 0) {
            return i % 2 == 0 ? BigInteger.valueOf(-fibPos(-i)) : BigInteger.valueOf(fibPos(-i));
        } else {
            return BigInteger.valueOf(fibPos(i));
        }
    }

    private static long fibPos(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibPos(n - 1) + fibPos(n - 2);
    }


    public static void main(String[] args) {
        for (int i = -10; i < 11; i++) {
            System.out.println(fib(BigInteger.valueOf(i)).toString());
        }

        System.out.println(fib(BigInteger.valueOf(1_500_000L)).toString());

    }
}