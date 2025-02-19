package Heap;

public class Max {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int frnt = 1;

    Max(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int p) { return p / 2; } // Returns the parent node postion
    private int left(int p) { return p * 2; } // Returns the left node position
    private int right(int p) { return (p * 2) + 1; } // Returns the right node position

    private boolean leaf(int p) { // Method that checks for leaf nodes
        return p > size / 2 && p <= size;
    }

    private void swap(int fp, int sp) { // Method that swaps the nodes in a heap
        int tmp = Heap[fp];
        Heap[fp] = Heap[sp];
        Heap[sp] = tmp;
    }

    private void maxH(int p) { // Method that makes the heap
        if (!leaf(p)) {
            int swapP = p;

            if (right(p) <= size) { 
                swapP = Heap[left(p)] > Heap[right(p)] ? left(p) : right(p);
            } else {
                swapP = left(p);
            }

            if (Heap[p] < Heap[swapP]) {
                swap(p, swapP);
                maxH(swapP);
            }
        }
    }

    public void insert(int e) { // Method that inserts nodes in a node
        if (size >= maxsize) {
            System.out.println("Heap is full!");
            return;
        }

        Heap[++size] = e;
        int c = size;

        while (c > 1 && Heap[c] > Heap[parent(c)]) {
            swap(c, parent(c));
            c = parent(c);
        }
    }

    public int remove() { // Method that remvoes nodes in a heap
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int pop = Heap[frnt];
        Heap[frnt] = Heap[size--];
        maxH(frnt);

        return pop;
    }

    public void list() { // Method that lists the nodes of the heap
        if (size == 0) {
            System.out.println("Heap is empty!");
            return;
        }

        for (int i = 1; i <= size / 2; i++) {
            System.out.print("Parent: " + Heap[i]);

            if (2 * i <= size)
                System.out.print(" Left Child: " + Heap[2 * i]);

            if (2 * i + 1 <= size)
                System.out.print(" Right Child: " + Heap[2 * i + 1]);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Max max = new Max(10);
        System.out.println("Max heap of 10, 1, 2, 3, 11, 22, 55, 5, 4, 6");
        
        max.insert(10);
        max.insert(1);
        max.insert(2);
        max.insert(3);
        max.insert(11);
        max.insert(22);
        max.insert(55);
        max.insert(5);
        max.insert(4);
        max.insert(6);

        max.list();

        System.out.println("Removing max element: " + max.remove());
        max.list();
    }
}
