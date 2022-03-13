package DataStructures.Heap;

public class Heap {
    private Node[] heapArray;               //Array that will contain the nodes
    private int maxSize;                   //Size of the array
    private int currentSize;              //will maintain the current size or number of nodes in the array.

    public Heap(int size){
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    //gets the current size of the array.
    public int getSize(){
        return currentSize;
    }

    //checks if the array is empty
    public boolean isEmpty(){
        return (currentSize == 0);
    }

    //check sif the array is full.
    public boolean isFull(){
        return (currentSize == maxSize);
    }

    //inserts a new node in the array
    public void insert(int key){
        if (isFull()){      //before insertion, this checks if the array has space for a new node
            return;
        }

        //creates the node to be inserted
        Node newNode = new Node(key);


        if (isEmpty()){    //checks if there is already a root node, if none, then the new node get inserted as the root node.
            heapArray[currentSize] = newNode;
        }else {
            //otherwise, the new node gets added at the next available index
            heapArray[currentSize] = newNode;
            swapWithSmallerParent(currentSize); //checks for the parents with smaller key and moves them down the heap.
        }
        currentSize++;

    }

    public void swapWithSmallerParent(int currentSize){
        int parentIndex = (currentSize - 1)/2;

        //loops through the heap as long as the key of the new node is greater than it's parent's key
        while(currentSize > 0 && heapArray[currentSize].getKey() > heapArray[parentIndex].getKey()){
            Node temp = heapArray[currentSize];
            heapArray[currentSize] = heapArray[parentIndex];
            heapArray[parentIndex] = temp;

            currentSize = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
    }

    /*This method only removes a Node from the top, replaces it with the last node at the bottom,
    trickles down the heap until it is placed at the index where its key is less than all the
    keys of the parent nodes.

    Formulas for finding the left and right Child Indexes:
    leftChildInd = (2*n) + 1;
    rightChildInd = (2*n) + 2

    where n is the index of the parent index
    */
    public Node remove(){
        int parentInd = 0;
        Node removedNode = heapArray[0];         //stores the removed node

        Node lastNode = heapArray[currentSize-1]; //saves the last node at the bottom

        heapArray[parentInd] = lastNode;         //replaces the last node at the spot where the top node was removed from

        int leftChildInd = 1, rightChildInd = 2; //initialises the 1st and 2nd child node indexes
        int maxChildInd;                         //will store the node with max key after the keys of the left and right child nodes are compared.

        while(parentInd < currentSize/2){   //loops through the half of the current array size
            if (leftChildInd > heapArray.length && rightChildInd > heapArray.length){
                break; //to avoid index out of bound exception, this checks if the generated index positions
                      //of the left and right child indexes are greater than the array size.
            }else if (heapArray[leftChildInd].getKey() > heapArray[rightChildInd].getKey()){ //gets the child with the max key
                maxChildInd = leftChildInd;
            }else{
                maxChildInd = rightChildInd;
            }

            //swaps the child with the max key with the last node if the last node's key is less
            if (lastNode.getKey() < heapArray[maxChildInd].getKey()){
                heapArray[parentInd] = heapArray[maxChildInd];
                heapArray[maxChildInd] = lastNode;
            }

            //calls the formula and updates to the next left and right child indexes
            leftChildInd = (2*maxChildInd) + 1;
            rightChildInd = (2*maxChildInd) + 2;
            parentInd = maxChildInd; //updates the parent index that hold the last node.
        }
        currentSize = currentSize -1; //reduces the current size by one since a node was removed. This also makes the last node not visible anymore or replaced when another node is inserted.

        return removedNode;
    }

    //Not written by me, yet to learn
    public void displayHeap() {
        System.out.println("Heap Array: ");
        for(int m = 0; m < currentSize; m++) {
            if(heapArray[m] != null) {
                System.out.print( heapArray[m].getKey() + " ");
            }
            System.out.println();

            int nBlanks = 32;
            int itemsPerRow = 1;
            int column = 0;
            int j = 0; // current item

            String dots = "...............................";
            System.out.println(dots+dots);
            while(currentSize > 0) {
                if(column == 0) {
                    for(int k = 0; k < nBlanks; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[j].getKey());
                j++;
                if(j == currentSize) {
                    break;
                }

                column++;
                // end of row
                if(column == itemsPerRow) {
                    nBlanks = nBlanks/2; // half the blanks
                    itemsPerRow = itemsPerRow * 2;     // twice the items
                    column = 0;
                    System.out.println();
                } else {
                    for(int k=0; k<nBlanks*2; k++) {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println("\n"+dots+dots);
        }
    }
}
