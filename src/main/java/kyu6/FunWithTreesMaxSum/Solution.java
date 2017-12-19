package kyu6.FunWithTreesMaxSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static List<Integer> sums;

    static int maxSum(TreeNode root) {
        sums = new ArrayList<>();
        traverse(root, 0);

        return Collections.max(sums);
    }

    private static void traverse(TreeNode root, int sum) {
        if (root == null) {
            sums.add(sum);
            return;
        }
        sum += root.value;
        if (root.left == null && root.right == null) {
            sums.add(sum);
            return;
        }
        if (root.left != null) {
            traverse(root.left, sum);
        }
        if (root.right != null) {
            traverse(root.right, sum);
        }
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
}

class MyTreeNode {
    TreeNode left;
    TreeNode right;
    int value;
}