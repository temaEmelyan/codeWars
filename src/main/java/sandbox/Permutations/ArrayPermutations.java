package sandbox.Permutations;

import java.util.Arrays;

public class ArrayPermutations {
    public static void main(String[] args) {
        int[] str = {1, 2, 3, 4, 5, 6};
        permute(str, 0, str.length - 1);
    }

    private static void permute(int[] str, int l, int r) {
        if (l == r)
            System.out.println(Arrays.toString(str));
        else {
            for (int i = l; i <= r; i++) {
                swap(str, l, i);
                permute(str, l + 1, r);
                swap(str, l, i);
            }
        }
    }

    private static void swap(int[] ints, int i, int j) {
        int temp;
        temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

}
