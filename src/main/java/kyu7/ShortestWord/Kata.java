package kyu7.ShortestWord;

public class Kata {
    public static int findShort(String s) {
        String[] split = s.split(" ");

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() < shortest) {
                shortest = split[i].length();
            }
        }

        return shortest;
    }
}
