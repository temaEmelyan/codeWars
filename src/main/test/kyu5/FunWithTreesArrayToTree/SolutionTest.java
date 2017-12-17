package kyu5.FunWithTreesArrayToTree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void emptyArray() {
        TreeNode expected = null;
        assertThat(Solution.arrayToTree(arrayFrom()), is(expected));
    }

    @Test
    public void arrayWithMultipleElements() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3), new TreeNode(15)), new TreeNode(-4));
        assertThat(Solution.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }
}