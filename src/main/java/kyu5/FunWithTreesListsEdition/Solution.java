package kyu5.FunWithTreesListsEdition;

import java.util.Set;
import java.util.TreeSet;

class Solution {

    static ListNode flatten(TreeNode root) {
        TreeSet<Integer> integers = new TreeSet<>();

        recursiveAdd(root, integers);

        ListNode out = null;
        ListNode temp = null;
        while (!integers.isEmpty()) {
            if (temp == null) {
                temp = new ListNode(integers.pollFirst());
            } else {
                temp.next = new ListNode(integers.pollFirst());
                temp = temp.next;
            }
            if (out == null) {
                out = temp;
            }
        }
        return out;
    }

    private static void recursiveAdd(TreeNode root, Set<Integer> set) {
        if (root != null) {
            listAdd(root.value, set);
            recursiveAdd(root.left, set);
            recursiveAdd(root.right, set);
        }
    }

    private static void listAdd(ListNode listNode, Set<Integer> set) {
        if (listNode != null) {
            set.add(listNode.data);
            listAdd(listNode.next, set);
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(17, new ListNode(1));
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(16);
        ListNode l6 = new ListNode(7, new ListNode(3));
        TreeNode root = new TreeNode(l1, new TreeNode(l2, new TreeNode(l4), null), new TreeNode(l3, new TreeNode(l5), new TreeNode(l6)));

        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(7, new ListNode(16, new ListNode(17))))));
        ListNode flatten = flatten(root);
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public ListNode value;

    TreeNode(ListNode value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(ListNode value) {
        this(value, null, null);
    }
}

class ListNode {
    public int data;
    public ListNode next;

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    ListNode(int data) {
        this(data, null);
    }
}