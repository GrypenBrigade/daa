package LinkedList;


class Node {
    int val; // Node Data
    Node next; // Node pointer

    public Node (int val) { //This makes a node
        this.val = val;
        this.next = null; 
    }


}


public class Singly {

    public void traversal(Node head) { // Method that traverses the list
        //Start from the head
        Node current = head;

        while(current != null) { // Keep running until node pointer is null
            System.out.print(current.val + ", "); // Print the node data
            current = current.next; // Move to the next node
        }
    }

    public boolean search(Node head, int search) { // Method that searches if a specific value exist
        while(head != null) { // Keep running until null
            if (head.val == search) { // Check if the value is the same as we are searching
                return true; // Return true if the value is the same as we are searching
            }

            head = head.next; // Move to the next one if we still cannot find it
        }

        return false; // Return false if the specific value does not 
    }

    public int length(Node head) { // Method that measures the length of the list
        int length = 0; // Initialization
        Node current = head; // Start from the start
        while(current != null) { // Keep running until the end of the list
            length++; // Add length value
            current = current.next; // Move to the next one
        }
        return length; // Return final length

    }

    public Node insertAtStart(Node head, int value) { // Method that inserts a node at the start
        Node newNode = new Node(value); // Create new node with given value
        newNode.next = head; // Set new node pointer to current head
        head = newNode; // Make the new node to become the head 
        return head; // Return new node
    }

    public Node insertAtEnd(Node head, int value) {
        Node newNode = new Node(value); // Create new node with given value

        if (head == null) { // If list is empty, make new node the head
            return newNode;
        }

        Node current = head; 
        while (current.next != null){ // Traverse list until the end
            current = current.next;
        }

        current.next = newNode; // Link new node to the last node
        return head; // Return new node
    }

    public static Node insertAtPos(Node head, int pos, int value) { // Method that inserts in to a specific position
        if (pos < 1) { // Check if position is valid
            System.out.println("Not a valid position");
            return head;
        }

        if (pos == 1) { // If positions is the start of the list
            Node newNode = new Node(value);
            newNode.next = head;
            return newNode;
        }

        Node prevNode = head;
        int count = 1;
        while (count < pos - 1 && prevNode != null) { // Traverse the list until specificed position
            prevNode = prevNode.next;
            count++;
        }

        if (prevNode == null) { // If specified position is greater than the number of nodes
            System.out.println("Not a valid position");
            return head;
        }

        // Insert new node from specified position
        Node newNode = new Node(value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;

        return head; // Return new node
    }

    public Node deleteStart(Node head) { // Method that removes the starting node
        if (head == null) { // Return null if list is empty
            return null;
        }

        Node tempNode = head; // Move first node to temporary node
        head = head.next; // Move first node 
        tempNode = null; // Nullfiy temporary node

        return head; // Return new first node
    }

    public Node deleteEnd(Node head) { // Method that removes the ending node
        if (head == null) { // Return null if list is empty
            return null;
        }

        if (head.next == null) { // If list is just node, delete it
            head = null;
            return null;
        }

        
        Node secondLastNode = head; // Find the second to the last node
        while (secondLastNode.next.next != null) {
            secondLastNode = secondLastNode.next;
        }

        
        secondLastNode.next = null; // Remove the last node
        return head; // Return new last node
    }

    public Node deletePos(Node head, int pos) { // Method that deletes the node of a given postion
        if (head == null || pos < 1) { // Check
            System.out.println("Not a valid position");
            return head;
        }

        if (pos == 1) { // If position is 1, delete it
            Node tempNode = head; // Create temporary node
            head = head.next; // Move node to another node
            tempNode = null; // Nullify tempNode
            return head;
        }

        Node currentNode = head; // Traverse the list to before the desired node to deleted
        for (int z = 1; z < pos - 1 && currentNode != null; z++) {
            currentNode = currentNode.next;
        }

        if (currentNode == null || currentNode == null) { // If position is out of range of the list
            System.out.println("Not a valid position");
            return head;
        }

        Node tempNode = currentNode.next; // Temporary node
        currentNode.next = currentNode.next.next; // Update nodes to bypass the deleted node
        tempNode = null; // Delete node
        return head;
    }

    public static void main(String[] args) {
        Singly singlyList = new Singly();

        System.out.println("Singly linked list");
        System.out.println("Making list with elements 100, 210, 312");

        Node head = new Node(100);
        head.next = new Node(210);
        head.next.next = new Node(312);

        System.out.println("Printing the list");
        singlyList.traversal(head);

        System.out.println(" \n");

        System.out.println("Measuring the length of the list: ");
        System.out.print("Length of list is " + singlyList.length(head));

        System.out.println(" \n");

        System.out.println("Inserting 999 at the start of the list");
        head = singlyList.insertAtStart(head, 999);
        singlyList.traversal(head);

        System.out.println(" \n");

        System.out.println("Inserting 1000 at the end of the list");
        head = singlyList.insertAtEnd(head, 1000);
        singlyList.traversal(head);

        System.out.println(" \n");

        System.out.println("Inserting 10000 at position 4");
        head = singlyList.insertAtPos(head, 4, 10000);
        singlyList.traversal(head);

        System.out.println(" \n");

        System.out.println("Deleting the first node");
        head = singlyList.deleteStart(head);
        singlyList.traversal(head);

        System.out.println(" \n");

        System.out.println("Deleting the last node");
        head = singlyList.deleteEnd(head);
        singlyList.traversal(head);

        System.out.println(" \n");

        System.out.println("Deleting position 3");
        head = singlyList.deletePos(head, 3);
        singlyList.traversal(head);










    }



}