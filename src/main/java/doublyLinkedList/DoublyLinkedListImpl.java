package doublyLinkedList;

public class DoublyLinkedListImpl<T> {
    private class Node {
        T value;
        Node prev;
        Node next;

        Node(T value) {
            if (value == null) throw new IllegalArgumentException("No null elements are allowed");
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size;

    public DoublyLinkedListImpl() {}

    public DoublyLinkedListImpl(T value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public DoublyLinkedListImpl(T[] values) {
        for (T value : values) {
            append(value);
        }
    }

    public boolean append(T value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    public boolean prepend(T value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
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
            head.prev = null;
            temp.next = null;
        }
        size--;
        return temp.value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int middle = size / 2;
        Node temp;
        if (index < middle) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = 0; i < size - index; i++) {
                temp = temp.prev;
            }
        }
        return temp.value;
    }

    public boolean set(int index, T value) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        if (value == null) throw new IllegalArgumentException();
        int middle = size / 2;
        Node temp;
        if (index < middle) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, T value) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        if (index == 0) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node newNode = new Node(value);
            var middle = size / 2;
            Node current;
            if (index < middle) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }

            Node prev = current.prev;
            prev.next = newNode;
            newNode.prev = prev;
            current.prev = newNode;
            newNode.next = current;
            size++;
        }
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        int middle = size / 2;
        Node temp;
        if (index < middle) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        Node prev = temp.prev;
        Node after = temp.next;
        prev.next = after;
        after.prev = prev;
        temp.next = null;
        temp.prev = null;
        return temp.value;
    }

    public T removeLast() {
        if (size == 0) return null;
        Node temp = tail;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        return temp.value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.next == null) {
                string.append(temp.value);
            } else {
                string.append(temp.value).append(", ");
            }
            temp = temp.next;
        }
        string.append("]");
        return string.toString();
    }
}
