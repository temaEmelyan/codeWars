package kyu4.MiddlePermutation;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MiddlePermutation {
    public static String findMidPerm(String strng) {

        char[] chars = strng.toCharArray();
        Arrays.sort(chars);
        strng = new String(chars);

        if (strng.length() < 3) {
            return strng;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (strng.length() % 2 == 0) {
            stringBuilder.append(strng.charAt(strng.length() / 2 - 1));
            for (int i = strng.length() - 1; i >= 0; i--) {
                if (i != strng.length() / 2 - 1) {
                    stringBuilder.append(strng.charAt(i));
                }
            }
        } else {
            stringBuilder.append(strng.charAt(strng.length() / 2));
            stringBuilder.append(strng.charAt(strng.length() / 2 - 1));
            for (int i = strng.length() - 1; i >= 0; i--) {
                if (i != strng.length() / 2 - 1 && i != strng.length() / 2) {
                    stringBuilder.append(strng.charAt(i));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "zxcvasd";

        char[] a = str.toCharArray();

        Arrays.sort(a);

        String s = new String(a);


        int n = 2;

        for (int i = n; i < str.length(); i += 2) {

            String croppedStr = s.substring(0, i);
            System.out.println(croppedStr + " " + BadSolution.findMidPermTooBad(croppedStr));
        }

        for (int i = n; i < str.length(); i += 2) {

            String croppedStr = s.substring(0, i);
            System.out.println(croppedStr + " " + findMidPerm(croppedStr));
        }
    }
}

@SuppressWarnings("Duplicates")
class BadSolution {
    private static Set<String> stringss;

    public static String findMidPermTooBad(String strng) {
        stringss = new TreeSet<>();

        permute(strng, 0, strng.length() - 1);
        String[] strings = stringss.toArray(new String[]{});
        if (strings.length % 2 == 0) {
            return strings[strings.length / 2 - 1];
        }

        return strings[strings.length / 2];
    }

    private static void permute(String str, int l, int r) {
        if (l == r) {
            stringss.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}
