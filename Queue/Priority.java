package Queue;

class Node {
    int d;
    int prio;
    Node n;

    Node(int d, int prio) {
        this.d = d;
        this.prio = prio;
        this.n = null;
    }
}


public class Priority {
    Node head;

    public int peek(Node head) {
        return head.d;
    }

    public Node pop(Node head) {
        head = head.n;
        return head;
    }

    public Node push(Node head, int d, int prio) {


        Node temp = new Node(d, prio);

        if(head == null || head.prio > prio) {
            temp.n = head;
            head = temp;
        } else {
            Node start = head;
            while(start.n != null && start.n.prio <= prio) {
                start = start.n;
            }
            temp.n = start.n;
            start.n = temp;
        }

        return head;
    }

    public void list(Node head) {
        while(head != null) {
            System.out.print(head.d + "("+head.prio+")" + ", ");
            head = head.n;
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

    }

}
