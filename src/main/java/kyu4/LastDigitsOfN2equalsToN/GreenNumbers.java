package kyu4.LastDigitsOfN2equalsToN;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreenNumbers {
    public static BigInteger getTooSlow(int n) {
        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return BigInteger.ONE;
        }

        List<BigInteger> allGreenNumbs = new ArrayList<>();

        fillTheList(n, 5, allGreenNumbs);
        fillTheList(n, 6, allGreenNumbs);

        allGreenNumbs.add(new BigInteger("1"));

        Collections.sort(allGreenNumbs);
        return allGreenNumbs.get(n - 1);
    }

    private static void fillTheList(int n, int number, List<BigInteger> allGreenNumbs) {
        allGreenNumbs.add(new BigInteger(Integer.toString(number)));

        int initialSize = allGreenNumbs.size();
        while (allGreenNumbs.size() - initialSize < n / 2 + 5) {
            allGreenNumbs.add(getNextGreenNumber(allGreenNumbs.get(allGreenNumbs.size() - 1)));
        }
    }

    private static BigInteger getNextGreenNumber(BigInteger theBigInt) {
        int numberInFront = 1;
        StringBuilder nulls = new StringBuilder();
        while (true) {
            BigInteger tempBigInt = new BigInteger(Integer.toString(numberInFront) + nulls + theBigInt.toString());
            BigInteger tempBigIntSquared = tempBigInt.pow(2);
            if (tempBigIntSquared.toString().endsWith(tempBigInt.toString())) {
                return tempBigInt;
            } else {
                numberInFront++;
                if (numberInFront == 10) {
                    numberInFront = 1;
                    nulls.append("0");
                }
            }
        }
    }
}