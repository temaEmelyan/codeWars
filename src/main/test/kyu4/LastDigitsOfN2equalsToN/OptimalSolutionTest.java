package kyu4.LastDigitsOfN2equalsToN;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class OptimalSolutionTest {

    @Test
    public void basicTests() {
        assertEquals(new BigInteger("5"), OptimalSolution.get(2));
        assertEquals(new BigInteger("6"), OptimalSolution.get(3));
        assertEquals(new BigInteger("25"), OptimalSolution.get(4));
        assertEquals(new BigInteger("76"), OptimalSolution.get(5));
    }

    @Test
    public void biggerTests() {
        assertEquals(new BigInteger("2890625"), OptimalSolution.get(12));
        assertEquals(new BigInteger("7109376"), OptimalSolution.get(13));
    }

    @Test
    public void advancedTests() {
        assertEquals(new BigInteger("6188999442576576769103890995893380022607743740081787109376"), OptimalSolution.get(100));
        assertEquals(new BigInteger("9580863811000557423423230896109004106619977392256259918212890625"), OptimalSolution.get(110));
    }
}