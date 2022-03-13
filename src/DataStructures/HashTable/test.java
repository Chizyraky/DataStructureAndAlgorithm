package DataStructures.HashTable;

public class test {

    public static void main(String[] args) {
        HashTable ht = new HashTable(24);

        ht.insert("John");
        ht.insert("Smith");
        ht.insert("Romeo");
        ht.insert("Juliet");
        ht.insert("Vivian");
        ht.insert("James");
        ht.insert("Shaun");
        ht.insert("Fabio");
        ht.insert("Michael");
        ht.insert("Raul");
        ht.insert("Jane");
        ht.insert("Jayson");

        System.out.println(ht.findWord("Paul"));

        System.out.println("What is in the table...");
        ht.displayTable();

    }
}
