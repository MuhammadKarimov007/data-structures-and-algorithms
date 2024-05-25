package main;
import binarySearchTree.BinarySearchTreeImpl;
import hashtables.HashTables;
import stacksAndQueues.StackImpl;


public class Main {
    public static void main(String[] args) {
        HashTables myHashTable = new HashTables();
        myHashTable.set("iron", 100);
        myHashTable.set("scissors", 500);
        myHashTable.set("laptop", 101);
        myHashTable.set("mouse", 15);
        myHashTable.set("passport", 9);
        myHashTable.set("pen", 3);
        myHashTable.set("pencils", 5);
        myHashTable.set("phone", 20);
        myHashTable.set("lion", 133);
        myHashTable.set("screen", 4);
        myHashTable.set("chair", 51);
        myHashTable.set("ship", 4);
        myHashTable.set("blanket", 245);
        myHashTable.set("blanket", 5);
        myHashTable.set("lion", 100);

        System.out.println(myHashTable.get("lion"));
        System.out.println(myHashTable.keys().size());
        myHashTable.printTable();
    }
}
