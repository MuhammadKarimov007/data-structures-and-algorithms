package stacksAndQueues;

public class QueueImpl<T>
{
    private class Node
    {
        Node next;
        T value;

        public Node(T value)
        {
            if (value == null) throw new IllegalArgumentException();
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public QueueImpl(T value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public boolean enqueue(T value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
        return true;
    }

    public T dequeue() {
        if (length == 0) return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp.value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        Node temp = first;
        for (int i = 0; i < length; i++) {
            if (temp.next == null) {
                string.append(temp.value);
            } else {
                string.append(temp.value).append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }
}
