package hashtables;

import java.util.ArrayList;

public class HashTables {
    private class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int size = 7;
    private Node[] dataMap;

    public HashTables() {
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public boolean set(String key, int value) {
        Node newNode = new Node(key, value);
        int address = hash(key);
        if (dataMap[address] == null) {
            dataMap[address] = newNode;
        } else {
            Node temp = dataMap[address];
            while (temp.next != null) {
                temp = temp.next;
            }
            if (temp.key.equals(key)) {
                temp.value = value;
            } else {
                temp.next = newNode;
            }
        }
        return true;
    }

    public int get(String key) {
        int address = hash(key);
        Node temp = dataMap[address];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            } else {
                temp = temp.next;
            }
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (Node node : dataMap) {
            Node temp = node;
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("    {" + temp.key + ": " + temp.value + "}");
                temp = temp.next;
            }
        }
    }
}
