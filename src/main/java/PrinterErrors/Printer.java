package PrinterErrors;

public class Printer {
    public static String printerError(String s) {
        // your code

        int length = s.length();
        long errors = length - s.chars().filter(value -> value <= 'm').count();
        return errors + "/" + length;
    }
}
