package Heap;

public class Min {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static int frnt = 1;

    Min(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int p) { return p / 2; }
    private int left(int p) { return p * 2; }
    private int right(int p) { return (p * 2) + 1; }

    private boolean leaf(int p) {
        return p > size / 2 && p <= size;
    }

    private void swap(int fp, int sp) {
        int tmp = Heap[fp];
        Heap[fp] = Heap[sp];
        Heap[sp] = tmp;
    }

    private void minH(int p) {
        if (!leaf(p)) {
            int swapP = p;

            if (right(p) <= size) { 
                swapP = Heap[left(p)] < Heap[right(p)] ? left(p) : right(p);
            } else {
                swapP = left(p);
            }

            if (Heap[p] > Heap[swapP]) {
                swap(p, swapP);
                minH(swapP);
            }
        }
    }

    public void insert(int e) {
        if (size >= maxsize) {
            System.out.println("Heap is full!");
            return;
        }

        Heap[++size] = e;
        int c = size;

        while (c > 1 && Heap[c] < Heap[parent(c)]) {
            swap(c, parent(c));
            c = parent(c);
        }
    }

    public int remove() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int pop = Heap[frnt];
        Heap[frnt] = Heap[size--];
        minH(frnt);

        return pop;
    }

    public void list() {
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
        Min min = new Min(10);
        System.out.println("Min heap of 10, 1, 2, 3, 11, 22, 55, 5, 4, 6");
        
        min.insert(10);
        min.insert(1);
        min.insert(2);
        min.insert(3);
        min.insert(11);
        min.insert(22);
        min.insert(55);
        min.insert(5);
        min.insert(4);
        min.insert(6);

        min.list();

        System.out.println("Removing min element: " + min.remove());
        min.list();
    }
}
