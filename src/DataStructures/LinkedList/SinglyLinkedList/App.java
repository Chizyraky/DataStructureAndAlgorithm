package DataStructures.LinkedList.SinglyLinkedList;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();

        myList.insertFirst(500);
        myList.insertFirst(600);
        myList.insertFirst(700);
        myList.insertFirst(800);
        myList.insertLast(5);

        myList.displayList();
    }
}
