package LengthOfMissingArray;

import java.util.Arrays;
import java.util.Comparator;

public class GetLengthOfMissingArray {
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }

        for (Object[] arrayOfArray : arrayOfArrays) {
            if (arrayOfArray == null || arrayOfArray.length == 0) {
                return 0;
            }
        }

        Arrays.sort(arrayOfArrays, Comparator.comparingInt(o -> o.length));
        int i = arrayOfArrays[0].length;

        for (int i1 = 0; i1 < arrayOfArrays.length; i1++) {
            if (arrayOfArrays[i1].length != i) {
                return i;
            }
            i++;
        }
        return i;
    }
}
