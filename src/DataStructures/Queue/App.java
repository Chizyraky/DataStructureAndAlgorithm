package DataStructures.Queue;

public class App {

    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        myQueue.insert(10);
        myQueue.insert(100);
        myQueue.insert(1000);
        myQueue.insert(10000);
        myQueue.insert(100000);
        myQueue.insert(1);
        myQueue.view();
    }
}
