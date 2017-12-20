package kyu4.NextBiggerNumber;

import static annotations.MyAnnotations.MyCode;

@MyCode
class Kata {
    public static long nextBiggerNumber(long n) {
        int[] breakdown = breakdown(n);

        if (breakdown.length == 1) {
            return n;
        }

        int indx = isPossible(breakdown);
        if (indx == -1) {
            return -1;
        }

        int temp = breakdown[indx];
        breakdown[indx] = breakdown[indx + 1];
        breakdown[indx + 1] = temp;

        return combine(breakdown);
    }

    private static int isPossible(int[] ints) {

        int no = -1;

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] - ints[i + 1] < 0) {
                no = i;
            }
        }

        return no;
    }

    private static int[] breakdown(long n) {
        char[] chars = Long.toString(n).toCharArray();

        int[] ints = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }
        return ints;
    }


    private static long combine(int[] ints) {
        StringBuilder s = new StringBuilder();

        for (int anInt : ints) {
            s.append(anInt);
        }

        return Long.parseLong(s.toString());
    }

    public static void main(String[] args) {
        for (int i : breakdown(12)) {
            System.out.println(i);
        }

        System.out.println(combine(new int[]{1, 2, 3, 4}));

        System.out.println(isPossible(new int[]{2, 0, 1, 7}));
    }
}
