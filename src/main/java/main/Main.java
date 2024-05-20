package main;

import singlyLinkedList.SinglyLinkedListImpl;


public class Main {
    public static void main(String[] args) {
        SinglyLinkedListImpl<String> names = new SinglyLinkedListImpl<>();
        names.append("12");
        System.out.println(names + " " + names.size());
        System.out.println(names.remove(0));

        System.out.println(names + " " + names.size());
    }
}
