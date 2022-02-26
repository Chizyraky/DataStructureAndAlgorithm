package DataStructures.Stack;

public class Stack {

    private int maxSize;
    private char[] stackArray;
    private int currIndex;

    public Stack (int size){
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.currIndex = -1;
    }

    public void push(char element){
        if (isFull()){
            System.out.println("The array is full, we cannot add more elements.");
        }else{
            currIndex++;
            stackArray[currIndex] = element;
        }
    }

    public char pop(){
        if (isEmpty()){
            System.out.println("There are no more elements in the array.");
            return ' ';
        }else{
            char currIndexElement = stackArray[currIndex];
            currIndex--;
            return currIndexElement;
        }
    }

    public char peek(){
        return stackArray[currIndex];
    }

    public boolean isEmpty(){
        return (currIndex == -1);
    }

    public boolean isFull(){
        return (maxSize - 1 == currIndex);
    }

}
