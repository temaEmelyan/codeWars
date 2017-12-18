package kyu4.MatrixDeterminant;

import java.util.Arrays;

public class Matrix {

    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        } else if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            return (int) deter(matrix);
        }
    }


    private static long deter(int[][] matrix) {
        long determinant = 0;

        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            determinant += matrix[i][0] * Math.pow(-1, i) * deter(getPartialMatrix(i, matrix));
        }

        return determinant;
    }


    private static int[][] getPartialMatrix(int y, int[][] matrix) {
        int[][] out = new int[matrix.length - 1][matrix.length - 1];
        int y1 = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i != y) {
                out[y1++] = Arrays.copyOfRange(matrix[i], 1, matrix.length);
            }
        }
        return out;
    }
}