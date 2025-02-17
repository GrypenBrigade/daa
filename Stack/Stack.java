package Stack;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Stack {
    private Node head;

    public Stack() {
        this.head = null;
    }

    public boolean empty() {
        return head == null;
    }

    public void push(int val) {
        Node newStack = new Node(val);
        newStack.next = head;
        head = newStack;
    }

    public void pop() {
        if(empty()){
            System.out.println("Stack underflow");
        }
        else {
            Node tempNode = head;
            head = head.next;
            tempNode = null;
        }
    }

    public int peek() {
        if (!empty()) {
            return head.val;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(11);
        stack.push(12);

        System.out.print(stack.peek());
    }
}
