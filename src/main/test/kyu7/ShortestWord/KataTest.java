package kyu7.ShortestWord;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataTest {

    @Test
    public void findShort() throws Exception {
        assertEquals(3, Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Kata.findShort("turns out random test cases are easier than writing out basic ones"));
    }

}