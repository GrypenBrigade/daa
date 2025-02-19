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


    Node insertEmpty(Node head, int val) { // Method that inserts a node on an empty list
        Node newNode = new Node(val); // Initializes the node with the given value
        newNode.next = newNode; // Point itself back
        return newNode; // Return the new node
    }

    Node insertStart(Node head, int val) { // Method that inserts a node on the start of the list
        Node newNode = new Node(val); // Intitializes the node with the given value
        newNode.next = head.next; // Points the new node pointer to the previous start node
        head.next = newNode; // Points the start node to the new node
        return head; // Returns the new head node
    }

    Node insertEnd(Node head, int val) { // Method that inserts a node on the end of the list
        Node newNode = new Node(val); // Initliazes the node with the given value
        if (head == null) { // Checks if the head is null
            newNode.next = newNode; // Point the new node back to itself
            return newNode; // Return the new node as the new end
        }
        newNode.next = head.next; // Point the new node to the head
        head.next = newNode; // Point the node next to the head to the new node
        return newNode; // Return the new node as the new end
    }

    Node insertPos(Node head, int val, int pos) { // Method that inserts a node in a given position
        Node newNode = new Node(val); 
        Node currentNode = head.next; // Node that is next to the head
        for (int i = 1; i < pos - 1 && currentNode != head; i++) { // Run until in the given position
            currentNode = currentNode.next;
        }
        newNode.next = currentNode.next; // Make the new node next pointer point to the current node next pointer 
        currentNode.next = newNode; // Make the current node next pointer point to the new node
        return head;
    }

    boolean search(Node head, int val) { // Method that searches a specific value
        Node currentNode = head.next; 
        do { // Run until value is found
            if (currentNode.val == val) return true;
            currentNode = currentNode.next;
        } while (currentNode != head.next);
        return false; // Return false if value is not found
    }

    Node delStart(Node head) { // Method that deletes the starting node of the list
        if (head.next == head) return null; // If the head points to itself, delete the node
        head.next = head.next.next; // The next pointer is set to point to another node other than
        return head; // Return the new head
    }

    Node delEnd(Node head) { // Method that deletes the end node of the list
        if (head.next == head) return null; 
        Node currentNode = head.next; 
        while (currentNode.next != head) { // Run until the end node is reached
            currentNode = currentNode.next;
        }
        currentNode.next = head.next; // End node is deleted 
        return currentNode; // Return the new end
    }

    Node delValue(Node head, int val) { // Method that deletes a node with a given value
        Node currentNode = head.next;
        Node prevNode = head;
        do { // Run until the given node with the specifci value is reached
            if (currentNode.val == val) { // Delete the given node
                prevNode.next = currentNode.next;
                return head;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != head.next);
        return head; // Return the new list
    }

    void printList(Node head) { // Method that prints the list
        Node temp = head.next;
        do { // Run until every node is printed
            System.out.print(temp.val + ", ");
            temp = temp.next;
        } while (temp != head.next);
        System.out.println();
    }

    public static void main(String[] args) {
        Circular circular = new Circular();
        Node head = null;

        head = circular.insertEmpty(head, 1000);
        head = circular.insertEnd(head, 2000);
        head = circular.insertEnd(head, 3000);
        System.out.println("Inserting 1000, 2000, 3000 into the list");
        System.out.print("List: ");
        circular.printList(head);
        
        head = circular.insertStart(head, 1);
        System.out.println("\nAdding 1 at the start of the list");
        System.out.print("List: ");
        circular.printList(head);
        
        head = circular.insertEnd(head, 5000);
        System.out.println("\nAdding 5000 at the end of the list");
        System.out.print("List: ");
        circular.printList(head);
        
        head = circular.insertPos(head, 4000, 4);
        System.out.println("\nAdding 4000 at position 4");
        System.out.print("List: ");
        circular.printList(head);
        
        System.out.println("\nSearch 3000 in the list");
        System.out.println("Value 3000: " + circular.search(head, 3000));
        
        System.out.println("Search 10000 in the list");
        System.out.println("Value 10000: " + circular.search(head, 10000));
        
        head = circular.delStart(head);
        System.out.println("\nDeleting the start of the list");
        System.out.print("List: ");
        circular.printList(head);
        
        head = circular.delEnd(head);
        System.out.println("\nDeleting the end of the list");
        System.out.print("List: ");
        circular.printList(head);
        
        head = circular.delValue(head, 3000);
        System.out.println("\nDeleting 3000 out of the list");
        System.out.print("List: ");
        circular.printList(head);
    }
}
