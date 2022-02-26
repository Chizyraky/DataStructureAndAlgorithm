package DataStructures.LinkedList.Demo;

public class App {

    public static void main(String[] args) {
        Node nodeA = new Node();
        nodeA.head = 4;

        Node nodeB = new Node();
        nodeB.head = 3;
        nodeA.next = nodeB;

        Node nodeC = new Node();
        nodeC.head = 7;
        nodeB.next = nodeC;

        Node nodeD = new Node();
        nodeD.head = 8;
        nodeC.next = nodeD;

        System.out.println(listLength(nodeA));
        System.out.println(listLength(nodeB));
    }

    public static int listLength(Node aNode){
        int count = 0;
        Node currNode = aNode;

        while(currNode != null){
            count ++;
            currNode = currNode.next;
        }
        return count;
    }
}
