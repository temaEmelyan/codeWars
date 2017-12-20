package kyu4.HammingNumbers;

public class Hamming {

    public static long hamming(int n) {
        // TODO: Program me

        return 0L;

    }

    public static void main(String[] args) {

        int count = 0;

        for (long i = 1; i < Long.MAX_VALUE / 100000; i++) {


            String breakdown = breakdown(i);

            if (breakdown.length() < 4) {
                count++;
                System.out.println(breakdown + " for " + i);
            }
        }


        System.out.println(count);
    }

    private static String breakdown(long n) {
        int[] hams = new int[]{0, 0, 0};

        while (n % 2 == 0) {
            n = n / 2;
            hams[0]++;
        }
        while (n % 3 == 0) {
            n = n / 3;
            hams[1]++;
        }
        while (n % 5 == 0) {
            n = n / 5;
            hams[2]++;
        }

        if (n == 1) {
            return Integer.toString(hams[0]) + Integer.toString(hams[1]) + Integer.toString(hams[2]);
        } else {
            return "not a ham";
        }
    }
}
