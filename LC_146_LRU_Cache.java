import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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

    /**
     * Solution with manual implementation of LRU Cache (no standard Java library for LinkedHashMap)
     */

    // helper-wrapper class for key-value pairs
    class Node {
        int key; // key in hashmap (cache) for this node
        int val; // value associated with the given key
        Node prev, next; // pointers to the previous and next node in doubly linked list

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity; // given maximum capacity of the cache
    Map<Integer, Node> cache; // structure for our LRU cache: <'key', 'pointer to the node with given key'>
    LinkedList<Node> dll; // doubly linked list
    Node left; // LEAST recently used dummy
    Node right; // MOST recently used dummy

    public LC_146_LRU_Cache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        // initialize dummy nodes (create empty doubly linked list)
        left = new Node(0,0); // boundary for the "left" side of the list with the LEAST recently used node
        right = new Node(0,0); // boundary for the "right" side of the list with the MOST recently used node
        // create first links in doubly linked list
        left.next = right;
        right.prev = left;
    }

    // helper method to remove any node from the DLL
    public void remove(Node node) {
        // get the neighbours of the node in the DLL and adjust their pointers to efficiently delete specified node
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // helper method to insert any node to the DLL
    public void insert(Node node) {
        // make the input node the MRU by inserting it just before the "right" dummy node
        Node prev = right.prev; // old MRU value
        Node next = right; // temporarily store dummy end of list
        prev.next = node;
        next.prev = node;
        node.next = next; // add dummy back to end of list
        node.prev = prev;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // remove and insert node in DLL to ensure it is updated to be the most recently used
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1; // key not in cache
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) { // node with associated key already exists in cache
            remove(cache.get(key)); // remove before updating value
        }
        // create new node with given key and insert to list
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        // capacity exceeded, evict the least recently used item
        if (cache.size() > capacity) {
            Node lru = left.next;
            // remove both from ordering-list and cache
            remove(lru);
            cache.remove(lru.key);
        }
    }

    /* ---------------------------------------------------------------------------------------------------------------- */
    // solution that leverages Java's standard library for LinkedHashmap

    private LinkedHashMap<Integer, Integer> cache2;

    public LC_146_LRU_Cache2(int capacity) {
        // initializes the LinkedHashmap with given capacity, standard load-factor, and automatic ordering of items based on access (instead of insertion)
        this.cache2 = new LinkedHashMap<>(capacity, 0.75f, true) {
            // overrides standard functionality to automatically remove the oldest entry
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity; // size of current map vs given capacity limit
            }
        };
    }

    public int get2(int key) {
        return cache2.getOrDefault(key, -1); // returns value if key exists, otherwise -1
    }

    public void put2(int key, int value) {
        cache2.put(key, value); // LinkedHashMap automatically manages the removal of older entries when capacity is exceeded
    }

    /* ---------------------------------------------------------------------------------------------------------------- */

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
