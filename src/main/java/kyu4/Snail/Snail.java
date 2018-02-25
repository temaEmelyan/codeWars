package kyu4.Snail;

import java.util.ArrayList;

public class Snail {

    public static int[] snail(int[][] array) {
        ArrayList<Integer> snailArrayList = new ArrayList<>();

        if (array == null || array.length == 0) {
            return new int[0];
        }

        if (array.length == 1){
            return array[0];
        }

        int direction = 3;
        int x = 0;
        int y = 0;

        while (snailArrayList.size() < array.length * array.length) {
            if (direction == 3) {
                while (y <= array.length - 1 && array[x][y] != -1) {
                    snailArrayList.add(array[x][y]);
                    array[x][y] = -1;
                    y++;
                }
                y--;
                x++;
                direction = 6;
            } else if (direction == 6) {
                while (x <= array.length - 1 && array[x][y] != -1) {
                    snailArrayList.add(array[x][y]);
                    array[x][y] = -1;
                    x++;
                }
                x--;
                y--;
                direction = 9;
            } else if (direction == 9) {
                while (y >= 0 && array[x][y] != -1) {
                    snailArrayList.add(array[x][y]);
                    array[x][y] = -1;
                    y--;
                }
                y++;
                x--;
                direction = 12;
            } else if (direction == 12) {
                while (x > 0 && array[x][y] != -1) {
                    snailArrayList.add(array[x][y]);
                    array[x][y] = -1;
                    x--;
                }
                x++;
                y++;
                direction = 3;
            }
        }
        int[] snailArray = new int[snailArrayList.size()];
        if (snailArray.length != 0) {
            for (int i = 0; i < snailArrayList.size(); i++) {
                snailArray[i] = snailArrayList.get(i);
            }
        }
        return snailArray;
    }
}