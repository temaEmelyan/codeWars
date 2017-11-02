package kyu7.BackWardsPrime;

import java.util.ArrayList;
import java.util.Comparator;

public class BackWardsPrime {


    public static String backwardsPrime(long start, long end) {

        ArrayList<Long> longs = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            long flip = flip(i);
            if (flip != i && isPrime(i) && isPrime(flip)) {
                longs.add(i);
            }
        }

        longs.sort(Comparator.naturalOrder());

        StringBuilder stringBuilder = new StringBuilder();
        longs.forEach(aLong -> {
            stringBuilder.append(aLong);
            stringBuilder.append(" ");
        });


        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } else {
            return "";
        }


    }

    private static boolean isPrime(long i) {
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static long flip(long i) {
        return Long.parseLong(new StringBuilder(Long.toString(i)).reverse().toString());
    }
}
