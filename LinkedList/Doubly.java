package LinkedList;

class Node { //Node class
    int val; // Node data
    Node prev; // Node back pointer
    Node next; // Node front pointer

    Node(int val) { // Node constructor
        this.val = val;
        this.prev = null;
        this.next = null;

    }
    
}

public class Doubly {
    private Node head;

    public void forwTraversal(Node head){ // Method that traverses the list forward
        Node currentNode = head; // Start at the head

        while(currentNode != null) { // Run until null pointer is encountered
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next; // Move to the next node
        }
    }

    public void backTraversal(Node tail) { // Method that traverses the list backward
        Node currentNode = tail; // Start at the tail

        while(currentNode != null) { // Run until null pointer is encountered
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.prev; // Move to the next node
        }
    }

    public int length(Node head) { // Method that measures the list
        int count = 0; // Start at zero
        for(Node currentNode = head; currentNode != null; currentNode = currentNode.next) { // Run until null pointer is encountered
            count++; // Increment 1 to the count
        }
        return count; // Returns updated count
    }

    public Node insertStart(Node head, int val) { // Method that inserts a node at the start
        Node newNode = new Node(val); // Initialize new node with given value
        newNode.next = head; // Make new node be the head
        if(head != null){  // Make the prev pointer of the head to point to the new node
            head.prev = newNode;
        }
        return newNode; // Return new node to be the new head
    }

    public Node insertEnd(Node head, int val) { // Method that inserts a node at the end 
        Node newNode = new Node(val); // Initialize new node with given value
        if(head == null) { // If linked list is empty, return the new node
            return newNode;
        }
        Node currentNode = head; 
        while(currentNode.next != null) { // Run until it encounters a null pointer
            currentNode = currentNode.next; 
        }
        currentNode.next = newNode; // Make the next pointer of the current node point to the new node
        newNode.prev = currentNode; // Make the prev pointer of the new node point to the current node
        
        return newNode; // Return the new node to become the new tail
    }
    
    public Node insertPos(Node head, int pos, int val) { // Method that inserts a node in a given position
        Node newNode = new Node(val); // Initialize new node with given value
        if(pos == 1) { // If position is 1, make new node the head of the list
            newNode.next = head;

            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return head;
        }

        Node currentNode = head;

        for(int i = 0; i < pos && currentNode != null; i++){ // Run until given position
            currentNode = currentNode.next;
        }

        if(currentNode == null) { // Gives out an error when the position given is out of bounds
            System.out.println("Position out of bounds");
            return head;
        }

        newNode.prev = currentNode; // Point the prev pointer of the new node to point at the current node
        newNode.next = currentNode.next; // Make the next pointer of the new node point past next of the current node
        currentNode.next = newNode; // Make the next pointer of the current node point to the new node

        if(newNode.next != null) { // If the new node is not the last node, update prev node of the next node 
            newNode.next.prev = newNode;
        }

        return head; // Return the new node to become the new node in a given position
        
    }

    public Node deleteStart(Node head) { // Method that deletes the starting node of the list
        if(head == null){ // Returns null when there is nothing to delete
            return null;
        }
        Node tempNode = head; // Temporary node to hold the head

        head = head.next; // Make the node next of the head become the head
        if(head != null){ // Set the prev of the head
            head.prev = null;
        }
        tempNode = null; // Nullify the temporary node
        return head; // Return the new head
    }

    public Node deleteEnd(Node head) { // Method that deletes the end node of the list
        if(head == null || head.next == null) { // If empty return null
            return null;
        }

        Node currentNode = head; 
        while(currentNode.next != null) { // Run until the end node is reached
            currentNode = currentNode.next;
        }

        if(currentNode.prev != null) { // Update the prev pointer
            currentNode.prev.next = null;
        }
        
        return head; // Return the new end
    }

    public Node deletePos(Node head, int pos) { // Method that that deletes a specific node given a specific position
        if (head == null){ // Return null if list is empty
            return null;
        }

        Node currentNode = head;

        for (int i = 0; i < pos && currentNode != null; i++) { // Run until specific position is met 
            currentNode = currentNode.next;
        }

        if (currentNode == null) { // Gives out an error when position is out of range
            System.out.println("Out of bounds");
            return head;
        }
        
        if (currentNode.prev != null) { // Update the previous node next pointer
            currentNode.prev.next = currentNode.next;
        }
        
        if (currentNode.next != null) { // update the next node prev pointer
            currentNode.next.prev = currentNode.prev;
        }
        return head; // Return the list with deleted node based on specified position
    }

    public static void main(String[] args) {
        Doubly doubly = new Doubly();

        System.out.println("Using 1000, 2000, and 3000 to make a doubly linked list");

        Node head = new Node(1000);
        Node second = new Node(2000);
        Node tail = new Node(3000);

        head.next = second;
        second.next = tail;

        second.prev = head;
        tail.prev = second;

        System.out.println("\nFoward Traversal: ");
        doubly.forwTraversal(head);
        System.out.println("\nBackward Traversal: ");
        doubly.backTraversal(tail);
        System.out.println(" ");

        System.out.println("\nInserting 1 in the start of the list");
        head = doubly.insertStart(head, 1);
        System.out.println("\nFoward Traversal: ");
        doubly.forwTraversal(head);
        System.out.println(" ");

        System.out.println("\nInserting 5000 at the end of the list");
        tail = doubly.insertEnd(head, 5000);
        System.out.println("\nFoward Traversal: ");
        doubly.forwTraversal(head);
        System.out.println(" ");

        System.out.println("\nInserting 4000 at position 3 of the list");
        head = doubly.insertPos(head, 3, 4000);
        System.out.println("\nNew List: ");
        doubly.forwTraversal(head);
        System.out.println(" ");

        System.out.println("\nMeasuring the length of the list");
        System.out.println("Length: " + doubly.length(head));

        System.out.println("\nDeleting the start of the list");
        head = doubly.deleteStart(head);
        System.out.println("\nNew List: ");
        doubly.forwTraversal(head);
        System.out.println(" ");

        System.out.println("\nDeleting the end of the list");
        head = doubly.deleteEnd(head);
        System.out.println("\nNew List: ");
        doubly.forwTraversal(head);
        System.out.println(" ");

        System.out.println("\nDeleting the third position");
        head = doubly.deletePos(head, 2);
        System.out.println("\nNew List: ");
        doubly.forwTraversal(head);
        System.out.println(" ");

        System.out.println("\nMeasuring the length of the list");
        System.out.println("Length: " + doubly.length(head));

        
        
    }
}