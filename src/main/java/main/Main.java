package main;

import singlyLinkedList.SinglyLinkedListImpl;


public class Main {
    public static void main(String[] args) {
        SinglyLinkedListImpl<String> names = new SinglyLinkedListImpl<>();
        names.prepend("Ja");
        names.append("Jas");
        names.append("hello");
        names.prepend("asdfasdf");
        System.out.println(names);
    }
}
