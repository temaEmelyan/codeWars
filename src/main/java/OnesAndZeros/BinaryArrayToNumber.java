package OnesAndZeros;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> 2 * x + y).get();
    }
}
