package Algorithm20250602;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
            map.put(key, value);
        } else {
            if (size == capacity) {
                int oldKey = list.removeLast();
                map.remove(oldKey);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache a = new LRUCache(6);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
