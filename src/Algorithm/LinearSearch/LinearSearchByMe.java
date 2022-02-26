package Algorithm.LinearSearch;

import java.security.KeyPair;

public class LinearSearchByMe {

    public static void main(String[] args) {

        int[] myArray = new int[10];
        myArray[0] = 52;
        myArray[1] = 88;
        myArray[2] = 177;
        myArray[3] = 20;
        myArray[4] = 68;
        myArray[5] = 5;
        myArray[6] = 93;
        myArray[7] = 111;
        myArray[8] = 580;
        myArray[9] = 700;

        System.out.println(searchValue(myArray, 88));
    }

    public static int searchValue(int[] myArray, int value){
        for (int i = 0; i < myArray.length; i++){
            if (myArray[i] == value){
                return i;
            }
        }
        return -1;
    }
}
