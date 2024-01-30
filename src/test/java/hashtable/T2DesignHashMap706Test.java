package hashtable;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
Design a HashMap without using any built-in hash table libraries.
*/

public class T2DesignHashMap706Test {

    @Test
    public void runTest() {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.get(1);
        map.get(3);
        map.put(2, 1);
        map.get(2);
        map.remove(2);
        int res = map.get(2);
        assertThat(res).isEqualTo(-1);
    }
}

class MyHashMap {

    private final Node[] buckets;
    private final int CAPACITY = 10000;

    public MyHashMap() {
        this.buckets = new Node[CAPACITY];
    }

    private int hashCode(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int value) {
        int hashCode = hashCode(key);
        Node bucket = buckets[hashCode];
        if (bucket == null) {
            buckets[hashCode] = new Node(key, value, null);
            return;
        }

        if (bucket.key == key) {
            bucket.value = value;
            return;
        }

        while (bucket.next != null) {
            bucket = bucket.next;
            if (bucket.key == key) {
                bucket.value = value;
                return;
            }
        }
        bucket.next = new Node(key, value, null);
    }

    public int get(int key) {
        int result = -1;
        Node bucket = buckets[hashCode(key)];
        if (bucket == null) return result;
        if (bucket.key == key) return bucket.value;

        while (bucket.next != null) {
            bucket = bucket.next;
            if (bucket.key == key) return bucket.value;
        }
        return result;
    }

    public void remove(int key) {
        int hashCode = hashCode(key);
        Node bucket = buckets[hashCode];
        if (bucket == null) return;
        if (bucket.key == key) {
            buckets[hashCode] = bucket.next;
            return;
        }

        while (bucket.next != null) {
            if (bucket.next.key == key) {
                bucket.next = bucket.next.next;
                return;
            }
            bucket = bucket.next;
        }
    }

    private static class Node {
        private final int key;
        int value;
        Node next;

        public Node(Integer key, Integer value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
