package kyu5.FunWithTreesArrayToTree;

import annotations.MyAnnotations.MyCode;
import annotations.MyAnnotations.OptimalSolution;

import java.util.Objects;

@MyCode
public class Solution {
    static TreeNode arrayToTree(int[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[array.length * 2 + 2];
        for (int i = array.length - 1; i >= 0; i--) {
            treeNodes[i] = new TreeNode(array[i], treeNodes[i * 2 + 1], treeNodes[i * 2 + 2]);
        }
        return treeNodes[0];
    }
}

@OptimalSolution
class Solution1 {
    static TreeNode arrayToTree(int[] array) {
        return arrayToTree(array, 0);
    }

    static TreeNode arrayToTree(int[] array, int index) {
        return index < array.length ?
                new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2)) :
                null;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value) {
        this(value, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right, value);
    }
}