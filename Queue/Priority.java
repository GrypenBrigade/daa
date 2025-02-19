package Queue;

class Node {
    int d;
    int prio; // New element to the node class: Priority
    Node n;

    Node(int d, int prio) {
        this.d = d;
        this.prio = prio;
        this.n = null;
    }
}


public class Priority {
    Node head;

    public int peek(Node head) { // Method that shows the front of the prio queue
        return head.d; // Return front of queue
    }

    public Node pop(Node head) { // Method that removes the front of the queue
        head = head.n; // Remove the front and replace with new node from the back of the front
        return head; // Return new front 
    }

    public Node push(Node head, int d, int prio) { // Method that adds new elements to the queue


        Node temp = new Node(d, prio); // Initialize node with given value and priority number

        if(head == null || head.prio > prio) { // Check if prio number is greater than the prio number of the head
            temp.n = head; // Make the higher prio node be above the previous
            head = temp; 
        } else {
            Node start = head; // Place the node depending on the given pos if not higher than the head
            while(start.n != null && start.n.prio <= prio) { // Run until a suitable position is found
                start = start.n; // Traverse  to the next node
            }
            temp.n = start.n; // Place the node in the given position
            start.n = temp;
        }

        return head; // Return with a new prio queue
    }

    public void list(Node head) { // Method that lists every element
        while(head != null) { // Run until until
            System.out.print(head.d + "("+head.prio+")" + ", "); // Print out value and priority
            head = head.n; // Traverse to the next node
        }
    }

    public static void main(String[] args) {
        Priority p = new Priority();
        System.out.println("Queuing 1 (Prio: 6), 90 (3), 2 (4), 999 (2), 10002 (1), 9 (5)");
        Node q = null;
        q = p.push(q, 1, 6);
        q = p.push(q, 90, 3);
        q = p.push(q, 2, 4);
        q = p.push(q, 999, 2);
        q = p.push(q, 10002, 1);
        q = p.push(q, 9, 5);
        System.out.println("Top: " + p.peek(q));
        p.list(q);

        System.out.println("\nRemoving two elements off the queue");
        q = p.pop(q);
        q = p.pop(q);
        System.out.println("Top: " + p.peek(q));
        p.list(q);
    }

}
