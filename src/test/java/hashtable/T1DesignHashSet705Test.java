package hashtable;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
Design a HashSet without using any built-in hash table libraries.
*/

public class T1DesignHashSet705Test {

    @Test
    public void runTest() {
        MyHashSet first = new MyHashSet();
        first.add(1);

        first.remove(1);
        boolean param = first.contains(1);
        assertThat(param).isFalse();

        MyHashSet second = new MyHashSet();
        second.add(1);
        second.add(2);
        second.contains(1);
        second.contains(3);
        second.add(2);
        second.contains(2);
        second.remove(2);
        second.contains(2);
        second.add(1000000);
        boolean contains = second.contains(1000000);
        assertThat(contains).isTrue();
    }
}

class MyHashSet {

    private final Node[] buckets;
    private final int CAPACITY = 1000;

    public MyHashSet() {
        this.buckets = new Node[CAPACITY];
    }

    private int hashCode(int key) {
        return key % CAPACITY;
    }

    public void add(int key) {
        int hashCode = hashCode(key);
        Node bucket = buckets[hashCode];
        if (bucket == null) {
            buckets[hashCode] = new Node(key, null);
            return;
        }
        if (bucket.equalsTo(key)) return;

        while (bucket.next != null) {
            bucket = bucket.next;
            if (bucket.equalsTo(key)) return;
        }
        bucket.next = new Node(key, null);
    }

    public void remove(int key) {
        int hashCode = hashCode(key);
        Node bucket = buckets[hashCode];
        if (bucket == null) return;

        Node next = bucket.next;
        if (bucket.equalsTo(key)) {
            buckets[hashCode] = next;
            return;
        }

        while (bucket.next != null) {
            if (bucket.next.equalsTo(key)) {
                bucket.next = bucket.next.next;
                return;
            }
            bucket = bucket.next;
        }
    }

    public boolean contains(int key) {
        int hashCode = hashCode(key);
        Node bucket = buckets[hashCode];
        if (bucket == null) return false;
        if (bucket.equalsTo(key)) return true;

        while (bucket.next != null) {
            bucket = bucket.next;
            if (bucket.equalsTo(key)) return true;
        }
        return false;
    }

    private static class Node {
        int value;
        Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public boolean equalsTo(Integer key) {
            return value == key;
        }
    }

}
