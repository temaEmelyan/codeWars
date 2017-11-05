package kyu6.NextBiggerNumber;

import java.util.Arrays;

import static annotations.MyAnnotations.MyCode;

/**
 * You have to create a function that takes a positive integer number and returns the next bigger number formed by the same digits:
 * <p>
 * Kata.nextBiggerNumber(12)==21
 * Kata.nextBiggerNumber(513)==531
 * Kata.nextBiggerNumber(2017)==2071
 * <p>
 * If no bigger number can be composed using those digits, return -1:
 * <p>
 * Kata.nextBiggerNumber(9)==-1
 * Kata.nextBiggerNumber(111)==-1
 * Kata.nextBiggerNumber(531)==-1
 */
//TODO make it O(n)
@MyCode
class Kata {
    private static long aLong;
    private static long currentLong;

    static long nextBiggerNumber(long n) {
        char[] chars = Long.toString(n).toCharArray();
        aLong = n;
        currentLong = Long.MAX_VALUE;
        permute(chars, 0, chars.length - 1);
        return currentLong;
    }

    @SuppressWarnings("Duplicates")
    private static void permute(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(str));

            long l1 = Long.parseLong(String.valueOf(str));
            if (l1 > aLong && l1 < currentLong) {
                currentLong = l1;
            }

        } else {
            for (int i = l; i <= r; i++) {
                swap(str, l, i);
                permute(str, l + 1, r);
                swap(str, l, i);
            }
        }
    }

    private static void swap(char[] ints, int i, int j) {
        char temp;
        temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
