package kyu3.CanYouGetTheLoop;

public class LoopInspector {

    public int loopSize(Node node) {
        Node slow = node;
        Node fast = node;

        do {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        } while (slow != fast);
        int i = 0;
        do {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            i++;
        } while (slow != fast);
        return i;
    }
}

class Node {
    public Node getNext() {
        return new Node();
    }
}