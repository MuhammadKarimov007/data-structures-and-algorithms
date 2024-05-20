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

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public boolean set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        pointer.value = value;
        return true;
    }

    public boolean insert(int index, T value) {
        if (index <= -1 || index >= size + 1) throw new IndexOutOfBoundsException();
        Node newNode = new Node(value);
        if (index == 0) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            Node after = pre.next;
            pre.next = newNode;
            newNode.next = after;
            size++;
        }
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        Node current = pre.next;
        pre.next = current.next;
        current.next = null;
        size--;
        return current.value;
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

    public T removeFirst() {
        if (size == 0) return null;
        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
        }
        size--;
        return temp.value;
    }

    public T removeLast() {
        if (size == 0) return null;
        Node temp  = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            tail = temp;
            temp = temp.next;
            tail.next = null;
        }
        size--;
        return temp.value;
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
