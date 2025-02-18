package LinkedList;

class Node {
    int val;
    Node prev;
    Node next;

    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;

    }
    
}

public class Doubly {
    public void forwTraversal(Node head){
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }

    public void backTraversal(Node tail) {
        Node currentNode = tail;

        while(currentNode != null) {
            System.out.println(currentNode.val + ", ");
            currentNode = currentNode.prev;
        }
    }

    public int length(Node head) {
        int count = 0;
        for(Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
            count++;
        }
        return count;
    }

    public Node insertStart(Node head, int val){
        Node newNode = new Node(0);
        newNode.next = head;
        if(head != null){
            head.prev = newNode;
        }
        return newNode;
    }

    public Node insertEnd(Node head, int val){
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
        }
        else {
            Node currentNode = head;
            while(currentNode != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;
        }
        return head;
    }
    
    public Node insertPos(Node head, int pos, int val) {
        Node newNode = head;
        if(pos == 1) {
            newNode.next = head;

            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return head;
        }

        Node currentNode = head;

        for(int i = 0; i < pos && currentNode != null; i++){
            currentNode = currentNode.next;
        }

        if(currentNode == null) {
            System.out.println("Position out of bounds");
            return head;
        }

        newNode.prev = currentNode;
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if(newNode.next != null) {
            newNode.next.prev = newNode;
        }

        return head;
        
    }

    public Node deleteStart(Node head) {
        if(head == null){
            return null;
        }
        Node tempNode = head;

        head = head.next;
        if(head != null){
            head.prev = null;
        }
        tempNode = null;
        return head;
    }

    public Node deleteEnd(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return null;
        }

        Node currentNode = head;
        while(currentNode != null) {
            currentNode = currentNode.next;
        }

        if(currentNode.prev != null) {
            currentNode.prev.next = null;
        }
        return head;
    }

    public Node deletePos(Node head, int pos) {
        if (head == null){
            return null;
        }

        Node currentNode = head;

        for (int i = 0; i < pos && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return head;
        }
        
        if (currentNode.prev != null) {
            currentNode.next.prev = currentNode.next;
        }
        return head;
    }
}