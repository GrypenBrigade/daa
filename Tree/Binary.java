package Tree;

class Node {
    int k;
    Node left, right;

    Node(int k) {
        this.k = k;
        left = right = null;
    }
}

public class Binary {
    Node root;

    public Binary() {
        root = null;
    }

    public void insert(int k) { // Method that inserts values in the binary tree
        root = _insert(root, k);
    }

    private Node _insert(Node root, int k) { 
        if(root == null) { // If root is null, make new root
            root = new Node(k);
            return root;
        }
        if(k < root.k) { //  If k is less than root.k, put value on the left
            root.left = _insert(root.left, k);
        } else if (k > root.k){ // If k is greater than root.k, put value on the right
            root.right = _insert(root.right, k);
        }
        return root; // Return the root
    }

    public void inorder() { // Method that traverses the tree inorder
        _inorder(root);
    }

    private void _inorder(Node root) {
        if(root != null) { // Run until root is null
            _inorder(root.left); // Go to the left
            System.out.print(root.k + ", "); // Print the value
            _inorder(root.right); // Go to the right
        }
    }

    public void preorder() { // Method that travers the tree preorder
        _preorder(root);
    }

    private void _preorder(Node root) {
        if(root != null){
            System.out.print(root.k + ", "); // Print the value
            _preorder(root.left); // Move to the left
            _preorder(root.right); // Move to right
        }
    }

    public void postorder() { // Method that traverses the tree postorder
        _postorder(root);
    }

    private void _postorder(Node root) {
        if(root != null) {
            _postorder(root.left); // Move to the left
            _postorder(root.right); // Move to the right
            System.out.print(root.k + ", "); // Print the value
        }
    }

    public boolean search(int k) { // Method that searches a specific value
        return _search(root, k);
    }

    private boolean _search(Node root, int k) {
        if(root == null) { // Return false if no value is found
            return false;
        }

        if(root.k == k) { // Return true if specific value is found
            return true;
        }

        if(k < root.k) { // Move to the left if k is less than root.k
            return _search(root.left, k);
        } else { // Move to the right if k is greater than root.k
            return _search(root.right, k);
        }
    }

    public int min() { // Method that finds the mininum value of the tree
        return _min(root);
    }
    
    private int _min(Node root) {
        if(root == null) throw new IllegalStateException("Tree empty"); // Throw exception if there is no tree

        if(root.left == null) { // if left is null, return mininum value
            return root.k;
        }
        return _min(root.left); // Insert value of left back to the method if no min value found
    }

    public int max() { // Method that find the maximum value of the tree
        return _max(root);
    }

    private int _max(Node root) {
        if(root == null) throw new IllegalStateException("Tree empty"); // Throw exception if there is no tree
        
        if(root.right == null) { // If right is null, return maxinum value
            return root.k;
        }
        return _max(root.right); // Insert value of right back to the method if no max value is found
    }

    public static void main(String[] args) {
        Binary bin = new Binary();

        System.out.println("Inserting 11, 21, 13 , 445 , 51 , 69 in binary tree");
        bin.insert(11);
        bin.insert(22);
        bin.insert(13);
        bin.insert(445);
        bin.insert(51);
        bin.insert(69);

        System.out.println("\nInorder Traversal");
        bin.inorder();
        System.out.println("\nPreorder Traversal");
        bin.preorder();
        System.out.println("\nPostorder Traversal");
        bin.postorder();

        System.out.println("\nSearching for 445:");
        int search_k = 445;
        System.out.println("Value " + search_k + ": " + bin.search(search_k));
        System.out.println("Searching for 10000:");
        int search_k2 = 10000;
        System.out.println("Value " + search_k2 + ": " + bin.search(search_k2));

        System.out.println("\nMininum value in tree: " + bin.min());
        System.out.println("Maxinum value in tree: "+  bin.max());

        
       
    }
}
