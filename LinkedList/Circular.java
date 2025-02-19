package LinkedList;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Circular {

    public Node insertEmpty(Node head, int val) {
        if(head != null) {
            return head;
        }

        Node newNode = new Node(val);
        newNode.next = newNode;
        head = newNode;

        return head;
    }

    public Node insertStart(Node head, int val) {
        Node newNode = new Node(val);

        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }

        newNode.next = head.next;
        head.next = newNode;

        return head;
    }

    public Node insertEnd(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            newNode.next = newNode;
        }
        newNode.next = head.next;
        head.next = newNode;
        head = newNode;

        return head;
    }

    public Node insertPos(Node head, int pos, int val) {
        if(head == null) {
            if(pos != 1) {
                System.out.println("Invalid position");
                return head;
            }
            Node newNode = new Node(val);
            head = newNode;
            head.next = head;
            return head;
        }

        Node newNode = new Node(val);
        Node currentNode = head.next;
        
        if(pos == 1) {
            newNode.next = currentNode;
            head.next = newNode;
            return head;
        }

        for(int i = 0; i < pos; i++) {
            currentNode = currentNode.next;

            if(currentNode == head.next) {
                System.out.println("Invalid position");
                return head;
            }
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if(currentNode == head) {
            head = newNode;
        }

        return head;
    }

    public Node delStart(Node head) {
        if(head == null) {
            System.out.println("List is empty");
            return null;
        }
        Node start = head.next;
        if(start == head.next) {
            head = null;
        }
        else {
            head.next = start.next;
        }

        return head;
        
    }

    public Node delEnd(Node head) {
        if(head == null) {
            System.out.println("List is empty");
            return null;
        }
        Node end = head.next;
        
        if(end == head) {
            head = null;
            return head;
        }

        Node currentNode = end;
        while(currentNode.next != head) {
            currentNode = currentNode.next;
        }
        currentNode.next = end;
        head = currentNode;
        return head;
    }

    public Node deleteVal(Node head, int val) {
        if(head == null) {
            System.out.println("List is empty");
            return null;
        }
        Node currentNode = head.next;
        Node prevNode = head;

        if(currentNode == head && currentNode.val == val) {
            head = null;
            return head;
        }
        if(currentNode.val == val) {
            head.next = currentNode.next;
            return head;
        }
        while(currentNode != head && currentNode.val != val) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode.val == val) {
            prevNode.next = currentNode.next;
            if(currentNode == head) {
                head = prevNode;
            }
        } else {
            System.out.println("Value not found");
        }
        return head;
    }
    
    public boolean search(Node head, int val) {
        if(head == null) {
            return false;
        }
        Node search = head.next;
        Node currentNode = search;
        while(currentNode != head) {
            if(currentNode.val == val) {
                return true;
            }
            currentNode = currentNode.next;
        }
        if(head.val == val) {
            return true;
        }
        return false;
    }

    public void printList(Node head) {

    }
}
