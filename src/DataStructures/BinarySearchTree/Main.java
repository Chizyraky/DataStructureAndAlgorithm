package DataStructures.BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10, "ten");
        bst.insert(4, "four");
        bst.insert(20, "twenty");
        bst.insert(2, "two");
        bst.insert(5, "five");
        bst.insert(18, "eighteen");
        bst.insert(22, "twenty-two");
        bst.insert(17, "seventeen");
        bst.insert(19, "nineteen");
        bst.insert(21, "twenty-one");
        bst.insert(24, "twenty-four");
        bst.insert(33, "thirty-three");

        System.out.println(bst.findMax().value);
        System.out.println(bst.findMinimum().value);

        System.out.println(bst.delete(559));
        System.out.println(bst.findMax().key);

        bst.displayTree();
    }
}
