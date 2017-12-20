package kyu4.SquareIntoSquaresProtectTrees;

import annotations.MyAnnotations;

@MyAnnotations.OptimalSolution
public class DecomposeOptimal {
    public static String decompose(long n) {
        return decomposeAux(n * n, n);
    }

    private static String decomposeAux(long total, long n) {
        for (long i = n - 1; i > 0; i--) {
            long amountToCompensate = total - i * i;
            if (amountToCompensate == 0) return String.valueOf(i);

            String tempResult = decomposeAux(amountToCompensate, Math.min(i, (long) Math.floor(Math.sqrt(amountToCompensate)) + 1));
            if (!tempResult.isEmpty()) return tempResult + " " + i;
        }

        return "";
    }


    public static void main(String[] args) {
        System.out.println(decompose(8));
    }
}
