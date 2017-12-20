package kyu4.SquareIntoSquaresProtectTrees;

import java.util.ArrayList;
import java.util.List;

public class Decompose {
    public static void main(String[] args) {
        System.out.println(new Decompose().decompose(625));
    }

    public String decompose(long n) {
        Node node = new Node(n);
        node.root = node;

        Node tempNode = node;

        while (tempNode.amountToCompensate != 0) {
            if (node.child != null && node.child.sqValue < node.child.amountToCompensate) {
                return "Nothing";
            }
            tempNode = tempNode.generateAChild();
            if (tempNode.value == 1 && tempNode.amountToCompensate != 0 || tempNode.amountToCompensate > tempNode.sqValue || tempNode.value >= tempNode.parent.value) {
                while (!tempNode.canGenerateAnotherChild()) {
                    tempNode = tempNode.parent;
                    if (tempNode == null) {
                        return "Nothing";
                    }
                    tempNode.child = null;
                }
                tempNode.currentlyConsideredChildValue--;
            }
        }


        List<Long> numbers = new ArrayList<>();

        tempNode = node;

        while (tempNode != null) {
            numbers.add(tempNode.value);
            tempNode = tempNode.child;
        }


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = numbers.size() - 1; i >= 1; i--) {
            stringBuilder.append(numbers.get(i));
            stringBuilder.append(" ");
        }

        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();

    }
}


class Node {
    long currentlyConsideredChildValue;

    long value;
    long sqValue;

    long amountToCompensate;

    Node root;

    Node parent;

    Node child;

    public Node(long value) {
        this.value = value;
        this.sqValue = value * value;
        amountToCompensate = value * value;
        currentlyConsideredChildValue = value - 1;
    }

    boolean canGenerateAnotherChild() {
        return this.currentlyConsideredChildValue > 2;
    }

    Node generateAChild() {
        Node node = new Node(currentlyConsideredChildValue);
        node.amountToCompensate = this.amountToCompensate - node.sqValue;
        node.currentlyConsideredChildValue = (long) Math.pow(node.amountToCompensate, 0.5);

        this.child = node;
        node.root = this.root;
        node.parent = this;


        return node;
    }
}