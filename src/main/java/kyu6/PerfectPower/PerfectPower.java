package kyu6.PerfectPower;

import static annotations.MyAnnotations.MyCode;
import static annotations.MyAnnotations.OptimalSolution;

@MyCode
class PerfectPower1 {
    public static int[] isPerfectPower(int n) {

        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            float f = n;

            int pow = 0;

            while (f - ((int) f) == 0f) {
                f = f * 1.0f / i;
                pow++;
                if (f == 1f && pow > 1) {
                    return new int[]{i, pow};
                }
            }
        }
        return null;
    }
}

@OptimalSolution
class PerfectPower {
    static int[] isPerfectPower(int n) {
        for (int i = 2; ; i++) {
            int root = (int) Math.round(Math.pow(n, 1.0 / i));
            if (root < 2) return null;
            if (Math.pow(root, i) == n) return new int[]{root, i};
        }
    }
}