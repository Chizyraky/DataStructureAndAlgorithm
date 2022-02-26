package Algorithm.QuickSort;

public class App {

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();

        int[] myArray = {12,81,74,43,1098,0,8,92,17,754,912,0,6,4}; //{6,8,7,2,4,3,5}; //{10,7,1,3,5,8,9,6};
        sorter.sort(myArray);

        int count = 0;
        System.out.print("{");
        for (int i: myArray) {
            System.out.print(i);
            if (count < myArray.length-1){
                System.out.print(",");
                count++;
            }
        }
        System.out.print("}");
    }
}
