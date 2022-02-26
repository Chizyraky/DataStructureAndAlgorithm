package DataStructures.LinkedList.CircularLinkedList;

public class CircularLinkedList {

    private Node head;
    private Node last;

    public CircularLinkedList() {
        head = null;
        last = null;
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;

        if (head == null){
            last = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;

        if (head == null){
            head = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }

    public int deleteFirst(){
        int temp = head.data;

        if (head.next == null){
            last = null;
        }
        head = head.next;
        return temp;
    }

    public void displayList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }



}
