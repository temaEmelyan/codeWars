package kyu4.LastDigitsOfN2equalsToN;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;


public class GreenNumbersTest {
    @Test
    public void basicTests() {
        assertEquals(new BigInteger("1"), GreenNumbers.getTooSlow(1));
        assertEquals(new BigInteger("5"), GreenNumbers.getTooSlow(2));
        assertEquals(new BigInteger("6"), GreenNumbers.getTooSlow(3));
        assertEquals(new BigInteger("25"), GreenNumbers.getTooSlow(4));
    }

    @Test
    public void biggerTests() {
        assertEquals(new BigInteger("2890625"), GreenNumbers.getTooSlow(12));
        assertEquals(new BigInteger("7109376"), GreenNumbers.getTooSlow(13));
    }

    @Test
    public void advancedTests() {
        assertEquals(new BigInteger("6188999442576576769103890995893380022607743740081787109376"), GreenNumbers.getTooSlow(100));
        assertEquals(new BigInteger("9580863811000557423423230896109004106619977392256259918212890625"), GreenNumbers.getTooSlow(110));

    }
}