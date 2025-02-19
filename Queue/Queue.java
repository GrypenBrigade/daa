package Queue;

class Node {
    int d;
    Node n;

    Node(int d) {
        this.d = d;
        this.n = null;
    }
}

public class Queue {
    Node frnt, back;

    Queue() {
        frnt = back = null;
    }

    public boolean empty() { // Method to check of method is empty
        return frnt == null && back == null;
    }

    public void enqueue(int d) { // Method that enqueues data in to a queue
        Node newNode = new Node(d);

        if(back == null) { // If empty, make new node that is bot the front and back
            frnt = back = newNode;
            return;
        }

        back.n = newNode; // Add new node at the back
        back = newNode; // make the back the new front
        
    }

    public void dequeue() { // Method that removes an element of the queue
        if(empty()) { // Check if the queue;
            System.out.println("Queue underflow");
            return;
        }

        Node t = frnt; // Remove front node
        frnt = frnt.n; // Push a new front node

        if(frnt == null) { // If front is null, back is now null
            back = null;
        }
    }

    public int rear() { // Method that checks the back of a queue
        if(empty()) { // Check queue if empty
            System.out.println("Queue empty");
            return -1;
        }

        return back.d; // Return back node
    }

    public int front() { // Method that checks the front of a queue;
        if(empty()) {
            System.out.println("Queue empty");
            return -1;
        }
        return frnt.d; // Return front node
    }

    public void list() { // Method that lists all elements of the queue
        if(empty()) {
            System.out.println("Queue empty");
            return;
        }
        Node temp = frnt; // Temporary node to store front
        while(temp != null) { // Run until null
            System.out.print(temp.d + ", "); // Print nodes
            temp = temp.n; // Move to next node
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("Inserting 10, 100, 1002, 9001 in to queue");
        q.enqueue(10);
        q.enqueue(100);
        q.enqueue(1002);
        q.enqueue(9001);

        System.out.println("Queue: ");
        q.list();
        System.out.println("\nFront of queue: " + q.front());
        System.out.println("Back of queue: " + q.rear());

        System.out.println("\nDeqeuing 10 and 100");
        q.dequeue();
        q.dequeue();
        System.out.println("Queue: ");
        q.list();
        System.out.println("\nFront of queue: " + q.front());
        System.out.println("Back of queue: " + q.rear());

    }


}
