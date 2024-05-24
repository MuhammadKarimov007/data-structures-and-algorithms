package binarySearchTree;

public class BinarySearchTreeImpl {
    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    public BinarySearchTreeImpl() {}
    public BinarySearchTreeImpl(int value) {
        root = new Node(value);
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public int getRoot() throws NullPointerException{
        return root.value;
    }
}
