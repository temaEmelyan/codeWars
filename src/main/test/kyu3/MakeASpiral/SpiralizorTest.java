package kyu3.MakeASpiral;

import org.junit.Test;

import static java.util.Arrays.deepEquals;
import static org.junit.Assert.assertTrue;

public class SpiralizorTest {

    @Test
    public void test1() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(1),
                new int[][]{{1}}));
    }

    @Test
    public void test2() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(2),
                new int[][]{
                        {1, 1},
                        {0, 1}
                }));
    }

    @Test
    public void test3() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(3),
                new int[][]{
                        {1, 1, 1},
                        {0, 0, 1},
                        {1, 1, 1}
                }));
    }

    @Test
    public void test5() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(5),
                new int[][]{
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}
                }));
    }

    @Test
    public void test8() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(8),
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1},
                }));
    }

}