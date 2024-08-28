import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 *
 * - LRUCache(int capacity) --> Initialize the LRU cache with positive size capacity.
 *
 * - int get(int key) --> Return the value of the key if the key exists, otherwise return -1.
 *
 * - void put(int key, int value) --> Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LC_146_LRU_Cache {

    // solution that leverages Java's standard library for LinkedHashmap
    private LinkedHashMap<Integer, Integer> cache;

    public LC_146_LRU_Cache(int capacity) {
        // initializes the LinkedHashmap with given capacity, standard load-factor, and automatic ordering of items based on access (instead of insertion)
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            // overrides standard functionality to automatically remove the oldest entry
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity; // size of current map vs given capacity limit
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1); // returns value if key exists, otherwise -1
    }

    public void put(int key, int value) {
        cache.put(key, value); // LinkedHashMap automatically manages the removal of older entries when capacity is exceeded
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
