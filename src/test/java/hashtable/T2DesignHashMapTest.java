package hashtable;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
Design a HashMap without using any built-in hash table libraries.
*/

public class T2DesignHashMapTest {

    @Test
    public void runTest() {
        int key = 1, value = 2;
        MyHashMap map = new MyHashMap();
        map.put(key, value);
        int param = map.get(key);
        assertThat(param).isEqualTo(value);

        map.remove(key);
        int paramEmpty = map.get(key);
        assertThat(paramEmpty).isEqualTo(-1);
    }
}

class MyHashMap {

    private final Node[] buckets;
    private final int CAPACITY = 2;

    public MyHashMap() {
        this.buckets = new Node[CAPACITY];
    }

    private int hashCode(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int value) {
        int hashCode = hashCode(key);
        Node bucket = buckets[hashCode];
        if(bucket == null) {
            buckets[hashCode] = new Node(key, value, null);
            return;
        }

        if(bucket.key == key) {
            bucket.value = value;
        } else {
            while (bucket.next != null) {
                bucket = bucket.next;
                if(bucket.key == key) {
                    bucket.value = value;
                    return;
                }
            }
            bucket.next = new Node(key, value, null);
        }
    }

    public int get(int key) {
        int result = -1;
        return result;
    }

    public void remove(int key) {

    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(Integer key, Integer value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public boolean equalTo(Integer key) {
            return value == key;
        }
    }

}
