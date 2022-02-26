package DataStructures.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int data){
        Node newNode = new Node(); //Create the new Node that will be inserted in the front
        newNode.data = data; //assign a data to the new Node

        if (isEmpty()){ //check if the List is empty
            last = newNode; //if it is then the last Node should be the newNode created
        }else{    // if it is not empty, meaning that it already contains other Nodes
            first.previous = newNode;   //make the previous field of the current first Node point to the newNode
        }

        newNode.next = first;   //make the next field of the newNode point to the current first Node on the List
        first = newNode;        // Since the current first has been unlinked as the first Node, then make the newNode the current Node.
    }

    public void insertLast(int data){
        Node newNode = new Node(); //created a newNode
        newNode.data = data;   //passed data into the Node

        if (isEmpty()){           //this checks if there has been existing Nodes on the list
            first = newNode;      //the created Node gets assigned as the first on the list if there has not been any existing Node.
        }else{                    //Otherwise
            last.next = newNode;  //make the last existing Node on the list point to the newly created Node
            newNode.previous = last;   //makes the newly created to point to the last Node on the list
        }
        last = newNode;     //makes the newNode the last on the list.
    }

    //assume that this list is a non-empty list
    public Node deleteFirst(){
        Node temp = first;

        if (first.next == null){ //assuming that the Node being removed is the only Node on the list
            last = null;        // this means that there is no last Node so the variable should be set to null
        }else{                 //otherwise, if there is another Node on the list
            first.next.previous = null;  //the next Node's previous should be disconnected from the Node being deleted thereby setting it to null.
        }
        first = first.next;  //then make the next Node the first on the list

        return temp;  //Return the first Node that is being deleted from the list
    }

    public Node deleteLast(){
        Node temp = last;  //stores the last Node that is about to be deleted

        if (first.next == null){
            first = null;
        }else{
            last.previous.next = null;
        }
        last = last.previous;

        return temp;
    }

    //assume a non-empty list
    public boolean insertAfter(int key, int data){
        Node currentNode = first;           //to iterate through the list, a current node is needed and should be the first on the list
        while(currentNode.data != key){     // as long as the data in the current Node does not match the key being searched for then iterate through the list
            currentNode = currentNode.next; //since the current Node's data is not equal to the key, move onto the next Node
            if (currentNode == null){       //however, if the current Node is null or the next is null, then key doesn't exist on the list
                return false;  //break and return false.
            }
        }

        Node newNode = new Node();  //coming to this line means the key was found so the newNode should be created
        newNode.data = data;        // assigns data to the newNode

        if (currentNode == last){    // if the current Node is the last Node on the list, then the new Node should be inserted after it
            currentNode.next = null; //this will be changed later on.
            last = newNode;    //the newNode then becomes the last Node on the list
        }else{          //otherwise, the newNode will be placed in between 2 Nodes
            newNode.next = currentNode.next; //the newNode should then point to the next Node after the current Node
            currentNode.next.previous = newNode;  //the previous field  of the Node after the current unlinks from the current Node and should point to the newNode.
        }

        newNode.previous = currentNode;   //the newNode should now point to the previous Node which is the current Node
        currentNode.next = newNode;       //And the previous node which is the current Node should point to the new Node

        return true;
    }

    //assume the list is not empty
    public Node deleteKey(int key){
        Node currentNode = first;

        while(currentNode.data != key){
            currentNode = currentNode.next;
            if (currentNode == null){
                return null;
            }
        }

        Node temp = currentNode;
        if (currentNode == first){
            first = currentNode.next;
            first.previous = null;
        }else if (currentNode == last){
            last = currentNode.previous;
            last.next = null;
        }else{
            currentNode.next.previous = currentNode.previous;
            currentNode.previous.next = currentNode.next;
        }
        return temp;
    }

    public void displayForward(){
        Node current = first;
        System.out.print("[");
        while(current != null){
            System.out.print(current.data);
            current = current.next;
            if (current == null){
                break;
            }else{
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();

    }

    public void displayBackward(){
        Node current = last;
        System.out.print("[");
        while(current != null){
            System.out.print(current.data);
            current = current.previous;
            if (current == null){
                break;
            }else{
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
