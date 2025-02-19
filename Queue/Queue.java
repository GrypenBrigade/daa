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

    public boolean empty() {
        return frnt == null && back == null;
    }

    public void enqueue(int d) {
        Node newNode = new Node(d);

        if(back == null) {
            frnt = back = newNode;
            return;
        }

        back.n = newNode;
        back = newNode;
        
    }

    public void dequeue() {
        if(empty()) {
            System.out.println("Queue underflow");
            return;
        }

        Node t = frnt;
        frnt = frnt.n;

        if(frnt == null) {
            back = null;
        }
    }

    public int rear() {
        if(empty()) {
            System.out.println("Queue empty");
            return -1;
        }

        return back.d;
    }

    public int front() {
        if(empty()) {
            System.out.println("Queue empty");
            return -1;
        }
        return frnt.d;
    }

    public void list() {
        if(empty()) {
            System.out.println("Queue empty");
            return;
        }
        Node temp = frnt;
        while(temp != null) {
            System.out.print(temp.d + ", ");
            temp = temp.n;
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
