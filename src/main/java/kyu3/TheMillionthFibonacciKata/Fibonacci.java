package kyu3.TheMillionthFibonacciKata;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger fib(BigInteger n) {
        int i = n.intValue();
        if (i < 0) {
            return i % 2 == 0 ? fibPos(-i).negate() : fibPos(-i);
        } else {
            return fibPos(i);
        }
    }

    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    private static BigInteger fibPos(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;
            if ((n & bit) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fib(new BigInteger("1500")));
    }
}