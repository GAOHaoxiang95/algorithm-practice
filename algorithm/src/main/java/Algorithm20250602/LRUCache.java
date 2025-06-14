package Algorithm20250602;

import java.util.*;

class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        Integer keyobject = Integer.valueOf(key);
        if (map.containsKey(keyobject)) {
            list.remove(keyobject);
            list.addFirst(keyobject);
            return map.get(keyobject);
        }
        return -1;
    }

    public void put(int key, int value) {
        Integer keyobject = Integer.valueOf(key);
        if (map.containsKey(keyobject)) {
            list.remove(keyobject);
            list.addFirst(keyobject);
            map.put(keyobject, value);
        } else {
            if (list.size() >= capacity) {
                Integer oldKey = list.removeLast();
                list.addFirst(keyobject);
                map.remove(oldKey);
                map.put(keyobject, value);
            } else {
                list.addFirst(keyobject);
                map.put(keyobject, value);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache a = new LRUCache(6);

        List<Integer> list = new ArrayList<>();

        list.addFirst(9);
        list.addFirst(8);

        list.remove(Integer.valueOf(9));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
