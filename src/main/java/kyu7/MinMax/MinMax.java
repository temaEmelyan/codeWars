package kyu7.MinMax;

import java.util.Arrays;


public class MinMax {
    public static int[] minMax(int[] ints) {
        int max = Arrays.stream(ints).max().getAsInt();
        int min = Arrays.stream(ints).min().getAsInt();

        return new int[]{min, max};
    }
}
