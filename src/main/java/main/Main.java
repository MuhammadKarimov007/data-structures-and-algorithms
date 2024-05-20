package main;

import singlyLinkedList.SinglyLinkedListImpl;


public class Main {
    public static void main(String[] args) {
        SinglyLinkedListImpl<String> names = new SinglyLinkedListImpl<>();
        names.append("100");
        System.out.println(names.set(0, "500"));
        System.out.println(names);
        names.insert(0, "1000");
        names.insert(1, "middle");
        names.insert(names.size(), "4012");
        System.out.println(names + " " + names.size());
    }
}
