package Easy;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    private List<Integer>[] buckets;
    private int SIZE = 10000;

    public MyHashSet() {
        buckets = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void add(int key) {
        int index = key % SIZE;
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = key % SIZE;
        buckets[index].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = key % SIZE;
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
