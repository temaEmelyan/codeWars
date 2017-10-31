package NthSeries;

public class NthSeries {
    public static String seriesSum(int n) {
        // Happy Coding ^_^
        if (n == 0) {
            return "0.00";
        }

        float answer = 0.0f;
        for (int i = 0; i < n; i++) {
            answer += 1 * 1.0 / (1 + 3 * i);
        }

        int round = Math.round(answer * 100);
        return String.valueOf(round*1.0/100);
    }
}
