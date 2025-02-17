package Stack;

class Node {
    int val;
    Node top;

    Node(int val) {
        this.val = val;
        this.top = null;
    }
}

public class Stack {
    private Node head;

    Stack() {
        this.head = null;
    }

    boolean empty() {
        return head == null;
    }

    void push(int val) {
        Node newStack = new Node(val);
        newStack.top = head;
        head = newStack;
    }
}
