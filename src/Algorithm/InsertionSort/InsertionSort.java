package Algorithm.InsertionSort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArray = {9,8,99,110,8,87,637,8,3,13,87,12,99};
        insertionSort(myArray);
        for (int i : myArray){
            System.out.println(i);
        }
    }

    public static int[] insertionSort(int [] myArray){
        for (int i = 1; i < myArray.length; i++){
            int element = myArray[i]; //element variable contains teh data we intend on bringing over to the sorted area.
            int j = i-1; //j variable points to the index position of the last value in the sorted area

            while(j>=0 && myArray[j] > element){
                myArray[j+1] = myArray[j];
                j--;
            }
            myArray[j+1] = element;
        }
        return myArray;
    }
}
