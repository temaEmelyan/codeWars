package kyu7.PrinterErrors;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrinterErrorsTest {
    @Test
    public void printerError() throws Exception {
        System.out.println("printerError Fixed Tests");
        String s="aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", Printer.printerError(s));
    }

}