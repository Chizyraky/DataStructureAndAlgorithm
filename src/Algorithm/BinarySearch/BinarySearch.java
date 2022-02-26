package Algorithm.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] myArray = new int[10];
        myArray[0] = 5;
        myArray[1] = 10;
        myArray[2] = 15;
        myArray[3] = 20;
        myArray[4] = 25;
        myArray[5] = 30;
        myArray[6] = 35;
        myArray[7] = 40;
        myArray[8] = 45;
        myArray[9] = 50;

        System.out.println(searchValue(myArray, 20));

    }

    //{5, 10, 15, 20, 25, 30, 35, 40 ,45}
    public static int searchValue(int[] myArray, int value){
        int p = 0;
        int r = myArray.length - 1;

        while(p <= r){
            int q = (p+r)/2;
            if (myArray[q] == value) return q;
            if (myArray[q] > value) r = q - 1;
            else p = q +1;
        }
        return -1;
    }

    // p              q                r
    //{5, 10, 15, 20, 25, 30, 35, 40 ,45}
    // Value = 40;
   /* public static int searchValue(int[] myArray, int value){
        int p = 0;
        int r = myArray.length - 1;

        while(p <= r){
            int q = (p+r)/2;
            if(myArray[q] > value) r = q - 1;
            else if (myArray[q] < value) p = q +1;
            else return q;
        }
        return -1;
    }*/

}
