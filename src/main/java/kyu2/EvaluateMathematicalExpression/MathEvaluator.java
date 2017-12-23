package kyu2.EvaluateMathematicalExpression;

public class MathEvaluator {
    public double calculate(String expression) {
        return calcRec(expression
                .replace(" ", "")
                .replace("--", "+")
                .replace("+-", "-")
                .replace("/-", "d")
                .replace("*-", "m")
                .replace("-", "(-1)*")
        );
    }

    private double calcRec(String expression) {
        try {
            return Double.parseDouble(expression);
        } catch (NumberFormatException ignored) {
        }

        if (expression.contains("(")) {
            int posOfOpenPar = expression.indexOf('(');
            int posOfClosingPar = getTheClosingParenthesisPosition(expression, posOfOpenPar);

            String substring1 = expression.substring(0, posOfOpenPar);
            String substring2 = Double.toString(calcRec(expression.substring(posOfOpenPar + 1, posOfClosingPar)));
            String substring3 = expression.substring(posOfClosingPar + 1);

            return calcRec((substring1 + substring2 + substring3)
                    .replace("*-", "m")
                    .replace("/-", "d")
                    .replace("d-", "/")
                    .replace("m-", "*"));

        } else {
            int pos;
            if (expression.contains("+")) {
                pos = expression.indexOf('+');
                return calcRec(expression.substring(0, pos)) + calcRec(expression.substring(pos + 1, expression.length()));
            } else if (expression.contains("-")) {
                if (expression.charAt(0) == '-') {
                    expression = "0" + expression;
                }
                pos = expression.lastIndexOf('-');
                return calcRec(expression.substring(0, pos)) - calcRec(expression.substring(pos + 1, expression.length()));
            } else if (expression.contains("m")) {
                pos = expression.indexOf('m');
                return calcRec(expression.substring(0, pos)) * -1 * calcRec(expression.substring(pos + 1, expression.length()));
            } else if (expression.contains("d")) {
                pos = expression.indexOf('d');
                return calcRec(expression.substring(0, pos)) / (-1 * calcRec(expression.substring(pos + 1, expression.length())));
            } else if (expression.contains("*")) {
                pos = expression.indexOf('*');
                return calcRec(expression.substring(0, pos)) * calcRec(expression.substring(pos + 1, expression.length()));
            } else if (expression.contains("/")) {
                pos = expression.indexOf('/');
                return calcRec(expression.substring(0, pos)) / calcRec(expression.substring(pos + 1, expression.length()));
            }
        }
        throw new RuntimeException();
    }

    private int getTheClosingParenthesisPosition(String str, int openingPos) {
        int amountOfOpens = 0;
        for (int i = openingPos + 1; i < str.toCharArray().length; i++) {
            if (str.toCharArray()[i] == '(') {
                amountOfOpens++;
            } else if (str.toCharArray()[i] == ')') {
                if (amountOfOpens == 0) {
                    return i;
                }
                amountOfOpens--;
            }
        }
        throw new RuntimeException();
    }
}