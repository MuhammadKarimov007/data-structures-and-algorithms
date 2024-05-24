package main;
import stacksAndQueues.StackImpl;


public class Main {
    public static void main(String[] args) {
        StackImpl<String> names = new StackImpl<>("Muhammad");
        System.out.println(names.getHeight());
    }
}
