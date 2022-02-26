package DataStructures.LinkedList.SinglyLinkedList;

public class SinglyLinkedList {

    //the first head contains no data
    private Node head;
    private Node last;

    public SinglyLinkedList() {
    }

    public boolean isEmpty(){
        return (head == null);
    }

    //this inserts a node at the beginning of the list
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (last == null){
            last = head;
        }
    }

    public Node deleteFirst(){
        Node temp = head;
        head = head.next;
        return temp;
    }

    public void displayList(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        last.next = newNode;
        last = newNode;
    }
}
