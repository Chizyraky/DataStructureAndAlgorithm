package DataStructures.BinarySearchTree;

public class BinarySearchTree {

    private Node rootNode;

    public void insert(int key, String value){
        Node newNode = new Node(key, value);     //create the new node that you want to insert.

        if (rootNode == null){                  //check if there is an existing tree already.
            rootNode = newNode;                 //Otherwise, make the new node the first in the tree.
        }else{                                 //However, if there is already an existing tree

            Node currentNode = rootNode;       //make the root(firstNode) the current Node.
            Node parentNode;                   //create a parent node to be the node that will hold the newly created node.

            while(true){                                        //traverse the tree
                parentNode = currentNode;                      //at each traversing, the parent node will be the current node
                if(key < currentNode.key){                     //if the key of the new node is less than the key of the current node
                    currentNode = currentNode.leftChild;      //it means that the new node needs to be on the left side
                    if (currentNode == null){                //until the left side of the current node becomes empty...
                        parentNode.leftChild = newNode;     //it means we have gotten to the end of the tree, then we can insert the new node...
                        return;                            //...and return from this infinite loop.
                    }
                }else{                                       //otherwise, if the key of the new node is greater than the key of the current node...
                    currentNode = currentNode.rightChild;   //then the new node should be on the right side of the current node and traversing will continue on the right side
                    if (currentNode == null){               //until we get to the end of the right side, then this becomes true
                        parentNode.rightChild = newNode;   //this means that the new node can now be inserted on the right side of the parent node which is also the current node
                        return;                            //then return from this infinite loop.
                    }
                }
            }
        }
    }

    public Node findMinimum(){
        Node currentNode = rootNode;
        Node last = null;

        while (currentNode != null){
            last = currentNode;
            currentNode = currentNode.leftChild;
        }
        return last;
    }

    public Node findMax(){
        Node currentNode = rootNode;
        Node lastNode = null;

        while(currentNode != null){
            lastNode = currentNode;
            currentNode = currentNode.rightChild;
        }
        return lastNode;
    }

    public boolean delete(int key){
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = false;

        //traversing the tree to find the node with the key that is to be deleted
        while(currentNode.key != key){                    //as long as the node with the key to be deleted is not yet found, the looping won't
            parentNode = currentNode;                    //at each traverse, the parent node gets assigned to the current node
            if(key < currentNode.key){                  //if the key being searched for is less than the current node...
                isLeftChild = true;                    //...it means that the node being searched for should be on the left side aka left child
                currentNode = currentNode.leftChild;  //this means that current node should be on the left side(left child) of the tree.
            }else{                                   //otherwise, if key is greater than the current node's key
                currentNode = currentNode.rightChild; //the traversing should continue on the right because the node being searched should be located on the right.
                isLeftChild = false;                  //...this also reverts the isLeftChild method to false
            }

            if (currentNode == null){              //if this condition runs, then a node with key being searched for does not exist
                return false;                      //the method then returns false
            }
        }


        Node nodeToDelete = currentNode;         //the node to be deleted

        /*if the node is a leaf node; this means that the node has no left or right child
        to determine this, a check needs to be done and if true, then another check also needs to be
        done in case the Node to be deleted is the first node on the tree. If it is the first node
        then the first node (root) needs to be set to null. If the node is a left child, then the right side of
        the parent needs to be set to null thereby deleting the node to be deleted. If it is not the left child
        then it means that the node to be deleted is on the right side and the right side needs to be set to null,
        thereby deleting the node that is to be deleted.*/
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if (nodeToDelete == rootNode){
                rootNode = null;
            }else if (isLeftChild){
                parentNode.leftChild = null;
            }else{
                parentNode.rightChild = null;
            }
        }else if (nodeToDelete.rightChild == null){     //if the node to be deleted has a child that is on the left
            if (nodeToDelete == rootNode){              //this checks if the node to be deleted is the first (root) node
                rootNode = nodeToDelete.leftChild;     //then left child of the node to be deleted gets assigned as the first(root) node
            }else if (isLeftChild){                    //else if the node to be the left child of another node but also has a left child
                parentNode.leftChild = nodeToDelete.leftChild;
            }else{
                parentNode.rightChild = nodeToDelete.leftChild;
            }
        }//if node has one child that is on the right
        else if (nodeToDelete.leftChild == null){
            if (nodeToDelete == rootNode){
                rootNode = nodeToDelete.rightChild;
            }else if (isLeftChild){
                parentNode.leftChild = nodeToDelete.rightChild;
            }else{
                parentNode.rightChild = nodeToDelete.rightChild;
            }
        }
        //if the node has 2 children
        else{
            Node replacement = getReplacement(nodeToDelete);

            //connect parent of the nodeToDelete to the replacement
            if (nodeToDelete == rootNode){
                rootNode = replacement;
            }else if (isLeftChild){
                parentNode.leftChild = replacement;
            }else{
                parentNode.rightChild = replacement;
            }
            replacement.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    private Node getReplacement(Node nodeToDelete){
        Node replacementParent = nodeToDelete;
        Node replacement = nodeToDelete;

        Node current = nodeToDelete.rightChild; //go to th right child

        while(current != null){ //traverse the left tree until node has no left child
            replacementParent = replacement;
            replacement = current;
            current = current.leftChild;
        }

        //if the replacement is not the right child
        if (replacement != nodeToDelete.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = nodeToDelete.rightChild;
        }

        return replacement;
    }
}
