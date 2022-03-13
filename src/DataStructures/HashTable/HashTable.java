package DataStructures.HashTable;

public class HashTable {

    String [] hashArray;
    int arraySize;
    int size = 0;

    public HashTable(int noOfSlots) {
        if(isPrime(noOfSlots)){
            hashArray = new String[noOfSlots];
            arraySize = noOfSlots;
        }else{
            int primeCount = getNextPrime(noOfSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;

            System.out.println("Hash table size given" + noOfSlots + " is not prime.");
            System.out.println("Hash table size changed to: " + primeCount);
        }
    }

    private boolean isPrime(int number){
        for(int i = 2; i <= number/2; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int number){
        for (int i = number+1 ; true; i++ ){
            if (isPrime(i)){
                return i;
            }
        }
    }

    //Get the ideal index position to insert a value in or check if it is empty
    private int hashFunc1(String word){
        int hashValue = word.hashCode();
        hashValue = hashValue % arraySize;
        if (hashValue < 0){
            hashValue += arraySize;
        }
        return hashValue;
    }

    //This will return the stepSize to use for searching the next available index position that is empty
    private int hashFunc2(String word){
        int hashValue = word.hashCode();
        hashValue = hashValue % arraySize;
        if (hashValue < 0){
            hashValue += arraySize;
        }

        return  3 - hashValue % 3; //A nr that is less than the array size needs to be used in this case.
        //3 in this case is a prime number that is assumable to be lot smaller than the actual array size.
    }

    public void insert(String word){
        int indexValue = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while(hashArray[indexValue] != null){ //this keeps running so long as the index position is occupied.
            indexValue += stepSize;
            indexValue %= arraySize;
        }

        hashArray[indexValue] = word; //this runs the moment the above while loop returns false, the word gets inserted at the index position.
        size++;
    }

    public String findWord(String word){
        int indexValue = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while(hashArray[indexValue] != null){ //this keeps running so long as the index position is occupied.
           if (hashArray[indexValue].equals(word)){
               return hashArray[indexValue];
           }

           indexValue += stepSize;
           indexValue %= arraySize;
        }
        return hashArray[indexValue];
    }

    public void displayTable(){
        for(int i = 0; i < arraySize; i++){
            if (hashArray[i] != null){
                System.out.print(hashArray[i] + " ");
            }else{
                System.out.print("-- ");
            }
            System.out.println();
        }
    }
}
