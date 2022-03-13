package DataStructures.Heap;

public class Main {
    public static void main(String[] args) {
        Heap hp = new Heap(10);

        hp.insert(10);
        hp.insert(12);
        hp.insert(42);
        hp.insert(35);
        hp.insert(16);
        hp.insert(88);
        hp.insert(42);
        hp.insert(7);

        hp.displayHeap();
        hp.remove();
        hp.displayHeap();

    }
}
