package main;

import doublyLinkedList.DoublyLinkedListImpl;
import singlyLinkedList.SinglyLinkedListImpl;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedListImpl<String> names = new DoublyLinkedListImpl<>("a");
        System.out.println(names);
    }
}
