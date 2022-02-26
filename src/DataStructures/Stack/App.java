package DataStructures.Stack;

public class App {
    public static void main(String[] args) {
//        Stack theStack = new Stack(5);
//        theStack.push(10);
//        theStack.push(20);
//        theStack.push(30);
//        theStack.push(40);
//        theStack.push(50);
//        theStack.push(60);
//
//        while (!theStack.isEmpty()){
//            System.out.println(theStack.pop());
//        }
        System.out.println(reverseString("Hello"));

    }

    public static String reverseString(String str){
        StringBuilder rev = new StringBuilder();
        char[] strToChar = str.toCharArray();
        int size =  strToChar.length;

        Stack theStack = new Stack(size);

        for (int i = 0; i < strToChar.length; i++){
            theStack.push(strToChar[i]);
        }

        while(!theStack.isEmpty()){
            rev.append(theStack.pop());
        }
        return rev.toString();
    }
}
