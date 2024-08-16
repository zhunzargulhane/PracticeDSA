package datastructuresandalgorithms.hashing;

import java.util.HashMap;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;


    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        numOfBuckets = capacity;
        buckets = new HashNode[numOfBuckets];
    }

    public int getSize() {
        return size;  //returns the number of key value pair
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Integer key, String value) {
        HashNode hashNode = null;
        int bucketIndex = key % numOfBuckets;
        if (buckets[bucketIndex] == null) {
            hashNode = new HashNode(key, value);
            buckets[bucketIndex] = hashNode;
        } else {
            HashNode head = buckets[bucketIndex];
            HashNode temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            HashNode node = new HashNode(key, value);
            node.next = head;
            buckets[bucketIndex] = node;
        }
        size++;
    }

    public String get(Integer key) {
        int bucketIndex = key % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        HashNode temp = head;
        while (temp != null) {
            if (temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return null;
    }



    public String remove(Integer key) {
        int bucketIndex = key % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        if (head.key == key) {
            buckets[bucketIndex] = head.next;
            size--;
            return head.value;
        }
        HashNode temp = head.next;
        HashNode prev = head;
        while (temp != null) {
            HashNode next = temp.next;
            if (temp.key == key) {
                prev.next = temp.next;
                size--;
                return temp.value;
            }
            temp = next;
        }
        return null;
    }

    private class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        //System.out.println(hashTable.getSize());
        hashTable.put(105, "John");
       // System.out.println(hashTable.getSize());
        hashTable.put(21, "Tom");
      //  System.out.println(hashTable.getSize());
        hashTable.put(31, "Sana");
        hashTable.put(21, "Mary");
        hashTable.put(41, "Ma");
   //     System.out.println(hashTable.getSize());
        /*System.out.println(hashTable.get(31));
        System.out.println(hashTable.get(21));
        System.out.println(hashTable.get(105));
        System.out.println(hashTable.get(41));*/
        System.out.println(hashTable.remove(31));
        hashTable.put(51, "Mother");
    }
}
