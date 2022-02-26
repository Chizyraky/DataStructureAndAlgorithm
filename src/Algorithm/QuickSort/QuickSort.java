package Algorithm.QuickSort;

public class QuickSort {

    public void sort(int[] myArray){
        sort(myArray, 0 , myArray.length-1);
    }

    public static void sort(int[] myArray, int start, int end){
        if (start < end){
            int pivot = partition(myArray, start, end);
            sort(myArray, start, pivot-1);
            sort(myArray, pivot+1, end);
        }
    }

    public static int partition(int[] myArray, int start, int end){
        int i = start-1, j = start, pivot = myArray[end];

        while(j < myArray.length){
            if (myArray[j] <= pivot){
                i++;
                int temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            }
            j++;
        }
        return i;
    }
}
