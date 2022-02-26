package Algorithm.Recursion;

public class RecursiveLinearSearch {
    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50, 60};
        System.out.println(getIndex(myArray, 0, 10));
    }

    public static int getIndex(int[] myArray, int ind, int value){
        if (ind > myArray.length - 1) return -1;
        else if (myArray[ind] == value) return ind;
        else return getIndex(myArray, ind + 1, value);
    }
}
