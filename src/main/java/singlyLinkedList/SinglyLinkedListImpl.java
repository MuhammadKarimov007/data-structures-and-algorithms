package singlyLinkedList;

public class SinglyLinkedListImpl<T>{
    private class Node {
        private Node next;
        private T value;

        private Node(T value) throws IllegalArgumentException{
            if (value == null) {
                throw new IllegalArgumentException("No null elements are allowed");
            }
            this.value = value;
        }
        private Node() {}
    }
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedListImpl() {}
    public SinglyLinkedListImpl(T value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size++;
    }

    public boolean append(T value) {
        final Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    public boolean prepend(T value) {
        final Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node temp = head;
        while (temp != null) {
            result.append(temp.value);
            if (temp.next != null) {
                result.append(", ");
            }
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }
}
