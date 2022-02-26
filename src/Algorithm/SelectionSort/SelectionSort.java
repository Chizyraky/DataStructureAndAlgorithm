package Algorithm.SelectionSort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] myArray = {9,8,3,13,87,12,99};
        selectionSort(myArray);
        for (int j : myArray) {
            System.out.println(j);
        }
    }

    public static void selectionSort(int [] myArray){
        for (int i = 0; i < myArray.length-1; i++){
            int min = i;
            for (int j = i+1; j < myArray.length; j++){
                if(myArray[j] < myArray[i]){
                    min = j;
                }
            }
            int temp = myArray[i];
            myArray[i] = myArray[min];
            myArray[min] = temp;
        }
    }
}
