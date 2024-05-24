package stacksAndQueues;

public class StackImpl<T> {
    private class Node {
        Node next;
        T value;

        Node() {}
        Node(T value) {
            if (value == null) throw new IllegalArgumentException();
            this.value = value;
        }
    }

    private Node top;
    private int height;

    public StackImpl() {}

    public StackImpl(T value) {
        top = new Node(value);
        height = 1;
    }

    public boolean push(T value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
        return true;
    }

    public T pop() {
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp.value;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        Node temp = top;
        for (int i = 0; i < height; i++) {
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
