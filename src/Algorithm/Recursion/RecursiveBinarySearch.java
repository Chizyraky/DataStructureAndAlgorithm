package Algorithm.Recursion;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println(recursiveBinarySearch(myArray, 0, myArray.length-1, 60));
    }

    public static int recursiveBinarySearch(int[] myArray, int startPoint, int endPoint, int value){
        if (startPoint > endPoint){
            return -1;
        }else{
            int midPoint = (startPoint + endPoint)/2;
            if (myArray[midPoint] == value){
                return midPoint;
            }else if (myArray[midPoint] > value){
                return recursiveBinarySearch(myArray, startPoint, midPoint - 1, value);
            }else{
                return recursiveBinarySearch(myArray, midPoint + 1, endPoint, value);
            }
        }
    }
}
