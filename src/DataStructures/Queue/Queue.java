package DataStructures.Queue;

public class Queue {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItem;

    public Queue(int size) {
        this.maxSize = size;
        this.queArray = new int[size];
        this.front = 0; // index position of the first slot of the array
        this.rear = -1; // there is no item in the array yet to be considered as the last item.
        this.nItem = 0; // we don't have elements in the array yet
    }

    public void insert(int j){
        if (nItem == maxSize){
            System.out.println("Can't insert further, the queue is full");
        }else {
            rear++;
            queArray[rear] = j;
            nItem++;
        }
    }

    public int remove(){
        int temp = queArray[front];
        front++;
        if (front == maxSize){
            front = 0;
        }
        nItem--;
        return temp;
    }

    public int peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItem == 0);
    }

    public boolean isFull(){
        return (nItem == maxSize);
    }

    public void view(){
        System.out.print("[" );
        for (int i = 0; i < queArray.length; i++){
            System.out.print(queArray[i]);
            if (i == queArray.length-1){
                break;
            }
            System.out.print(",");
        }
        System.out.println("]");
    }
}
