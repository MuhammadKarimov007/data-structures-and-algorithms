package binarySearchTree;

public class BinarySearchTreeImpl<T> {
    private class Node {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;
    public BinarySearchTreeImpl() {}
    public BinarySearchTreeImpl(T value) {
        root = new Node(value);
    }
}
