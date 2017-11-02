package kyu7.Order;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
    public static String order(String words) {
        String[] split = words.split(" ");
        Arrays.sort(split, Comparator.comparingInt(Order::findNumber));

        StringBuilder stringBuilder = new StringBuilder();

        for (String s : split) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


    private static int findNumber(String o1) {
        String s = o1.toLowerCase().replaceAll("[a-z]", "");
        return Integer.parseInt(s);
    }
}
