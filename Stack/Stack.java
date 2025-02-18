package Stack;

class Node { // Class that makes a linked list
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Stack {
    private Node head;

    public Stack() { // This Initializes the Stack
        this.head = null;
    }

    public boolean empty() { // This checks if the Stack is empty
        return head == null; // If the head has nothing, return null
    }

    public void push(int val) { // This method pushes a new entry in to the Stack
        Node newStack = new Node(val); // Creates a new node with given data
        newStack.next = head; // Links the the top node with new node
        head = newStack; // Makes the new node to be the head
    }

    public void pop() { // Method that deletes the top
        if(empty()){ // Check if the stack is empty
            System.out.println("Stack underflow");
        }
        else { // Delete the top node
            Node tempNode = head; // Temporary node to store the head
            head = head.next; // Make the next node to be the head
            tempNode = null; // Delete the temporary head
        }
    }

    public int peek() { // Method that peeks the top
        if (!empty()) { // Return the value of the top if the Stack is not empty
            return head.val; 
        }
        else { // If the Stack is empty, return this message
            System.out.println("Stack is empty");
            return 0;
        }
    }

    public void display() { // Method that displays the Stack as a whole
        Node tempNode = head; // Temporary node for display
        System.out.print("Stack: ");
        while (tempNode != null){ // Runs until it reaches the end
            System.out.print(tempNode.val + ", ");
            tempNode = tempNode.next; // Move to the next node
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Pushing 10, 11, 12 in to the stack");
        
        stack.push(10);
        stack.push(11);
        stack.push(12);

        stack.display();

        System.out.println(" ");
        System.out.println("Top: " + stack.peek());

        System.out.println("Popping the stack (Top will be 10)");
        stack.pop();
        stack.pop();
        System.out.println("Top: " + stack.peek());

        System.out.println(" ");
        System.out.println("Emptying the stack");
        stack.pop();
        System.out.println("Top: " + stack.peek());

        System.out.println(" ");
        System.out.println("Pushing 100, 200, 300, 400 in the empty Stack");
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.display();
        System.out.println(" ");
        System.out.println("Top: " + stack.peek());

    }
}
