package kyu5.FunWithTreesIsPerfect;

public class TreeNode {

    TreeNode left;
    TreeNode right;

    public static boolean isPerfect(TreeNode root) {
        return maxDepth(root, 0) == minDepth(root, 0); // TODO: implementation
    }


    public static int maxDepth(TreeNode treeNode, int depth) {
        return treeNode == null ? depth : Math.max(maxDepth(treeNode.left, depth + 1), maxDepth(treeNode.right, depth + 1));
    }

    public static int minDepth(TreeNode treeNode, int depth) {
        return treeNode == null ? depth : Math.min(minDepth(treeNode.left, depth + 1), minDepth(treeNode.right, depth + 1));
    }

    static TreeNode leaf() {
        return new TreeNode();
    }

    static TreeNode join(TreeNode left, TreeNode right) {
        return new TreeNode().withChildren(left, right);
    }

    TreeNode withLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    TreeNode withRight(TreeNode right) {
        this.right = right;
        return this;
    }

    TreeNode withChildren(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        return this;
    }

    TreeNode withLeftLeaf() {
        return withLeft(leaf());
    }

    TreeNode withRightLeaf() {
        return withRight(leaf());
    }

    TreeNode withLeaves() {
        return withChildren(leaf(), leaf());
    }
}