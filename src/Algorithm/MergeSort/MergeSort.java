package Algorithm.MergeSort;

public class MergeSort {

    public static void sort(int[] myArray){
        int len = myArray.length;
        if (len < 2){return;}

        int midPoint = len/2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[len - midPoint];

        int i = 0, j = midPoint;
        while(i < midPoint){
            leftArray[i] = myArray[i];
            i++;
        }
        while(j < myArray.length){
            rightArray[j - midPoint] = myArray[j];
            j++;
        }
        sort(leftArray);
        sort(rightArray);
        merge(myArray, leftArray, rightArray);
    }

    public static void merge(int[] myArray, int[] leftArray, int[] rightArray){
        int i = 0, j = 0, k = 0;

        while(i < leftArray.length && j < rightArray.length){
            if (leftArray[i] <= rightArray[j]){
                myArray[k] = leftArray[i];
                i++;
            }else{
                myArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length){
            myArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length){
            myArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
