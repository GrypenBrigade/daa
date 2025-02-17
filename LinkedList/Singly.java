package LinkedList;


class Node { // Node class 
    int val; // Node Data
    Node next; // Node pointer

    public Node (int val) { //This makes a node
        this.val = val;
        this.next = null;
    }


}


public class Singly {
    private Node head;

    public static void traversal(Node head) { // Method that traverses the list
        //Start from the head
        Node current = head;

        while(current != null) { // Keep running until node pointer is null
            System.out.print(current.val + ", "); // Print the node data
            current = current.next; // Move to the next node
        }
    }

    public static boolean search(Node head, int search) { // Method that searches if a specific value exist
        while(head != null) { // Keep running until null
            if (head.val == search) { // Check if the value is the same as we are searching
                return true; // Return true if the value is the same as we are searching
            }

            head = head.next; // Move to the next one if we still cannot find it
        }

        return false; // Return false if the specific value does not 
    }

    public static void length() { // Method that 

    }

    public static void insertAtStart() {

    }

    public static void insertAtEnd() {

    }

    public static void insertAtPos() {

    }

    public static void deleteStart() {

    }

    public static void deleteEnd() {

    }

    public static void deletePos() {

    }



}