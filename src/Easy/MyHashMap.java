package Easy;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    private final List<int[]>[] buckets;
    private final int SIZE = 10000;

    public MyHashMap() {
        buckets = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        for (int[] bucket : buckets[index]) {
            if (bucket[0] == key) {
                bucket[1] = value;
                return;
            }
        }

        buckets[index].add(new int[]{key, value});
    }

    public int get(int key) {
        int index = key % SIZE;
        for (int[] bucket : buckets[index]) {
            if (bucket[0] == key) {
                return bucket[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;
        buckets[index].removeIf(x -> x[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
