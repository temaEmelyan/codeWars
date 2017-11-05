package kyu6.Scramblies;

import java.util.LinkedList;
import java.util.List;

import static annotations.MyAnnotations.MyCode;
import static annotations.MyAnnotations.OptimalSolution;

public class Scramblies {

    @MyCode
    static boolean scramble(String str1, String str2) {
        List<Character> characters1 = new LinkedList<>();

        for (char c : str1.toCharArray()) {
            characters1.add(c);
        }

        for (char c : str2.toCharArray()) {
            int i = characters1.indexOf(c);
            if (i > -1) {
                characters1.remove(i);
            } else {
                return false;
            }
        }

        return true;
    }

    @OptimalSolution
    public static boolean scramble1(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        for (String s : str2.split("")) {
            if (!str1.contains(s)) return false;
            str1 = str1.replaceFirst(s, "");
        }

        return true;
    }
}
