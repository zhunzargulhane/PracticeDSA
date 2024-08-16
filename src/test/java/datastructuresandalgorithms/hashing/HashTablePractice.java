package datastructuresandalgorithms.hashing;

public class HashTablePractice {
    private HashNode[] buckets;
    private int noOfBuckets;
    private int size;

    HashTablePractice(int capacity) {
        buckets = new HashNode[capacity];
        noOfBuckets = capacity;
    }

    private class HashNode {
        private int key;
        private String value;
        private HashNode next;

        HashNode(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(int key, String value) {
        int index = key % noOfBuckets;
        if (buckets[index] == null) {
            buckets[index] = new HashNode(key, value);
            size++;
        } else {
            HashNode head = buckets[index];
            if (head.key == key)
                head.value = value;
            else {
                HashNode temp = head;
                while (temp.next != null) {
                    if (temp.next.key == key) {
                        temp.next.value = value;
                        return;
                    }
                    temp = temp.next;
                }
                temp.next = new HashNode(key, value);
                size++;
            }
        }
    }

    public String get(int key) {
        int index = key % noOfBuckets;
        HashNode head = buckets[index];
        HashNode temp = head;
        while (temp != null) {
            if (temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return null;
    }

    public String remove(int key) {
        int index = key % noOfBuckets;
        if (buckets[index] == null) {
            return null;
        } else {
            HashNode head = buckets[index];
            HashNode temp = head;
            if (head.key == key) {
                buckets[index] = head.next;
                size--;
                return temp.value;
            } else {
                temp = head.next;
                HashNode prev = head;
                while (temp != null) {
                    if (temp.key == key) {
                        prev.next = temp.next;
                        size--;
                        return temp.value;
                    } else prev = temp;
                    temp = temp.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashTablePractice hashTablePractice = new HashTablePractice(10);
        hashTablePractice.put(10, "zhunzar");
        hashTablePractice.put(100, "kamlesh");
        hashTablePractice.put(100, "z");
        System.out.println(hashTablePractice.size);
    }

}
