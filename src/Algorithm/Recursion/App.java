package Algorithm.Recursion;

public class App {
    public static void main(String[] args) {
        reduceByOne(10);
    }

    public static void reduceByOne(int n){

        if (n >= 0){
            System.out.println(n);
            reduceByOne(n-1);
        }
    }
}
