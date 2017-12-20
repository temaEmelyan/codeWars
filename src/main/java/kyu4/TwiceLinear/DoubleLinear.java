package kyu4.TwiceLinear;

import java.util.TreeSet;

public class DoubleLinear {
    public static int dblLinear(int n) {
        TreeSet<Integer> integers = new TreeSet<>();
        TreeSet<Integer> indexes = new TreeSet<>();


        indexes.add(1);
        integers.add(1);

        int counter = 1;

        while (counter < n - 1) {
            for (int i = 1; i <= n; i++) {
                int numb = indexes.pollFirst();
                if (indexes.add(2 * numb + 1)) {
                    counter++;
                }
                if (indexes.add(3 * numb + 1)) {
                    counter++;
                }
            }
        }
        return indexes.pollFirst();
    }

    public static void main(String[] args) {
        dblLinear(2000);
    }
}
