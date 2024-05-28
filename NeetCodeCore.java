import java.util.ArrayList;

/**
 * This class holds a collection of "core skill" problems
 * to solve from NeetCode.io (https://neetcode.io/practice).
 */
public class NeetCodeCore {

    // Design a singly linked list class
    class DesignSinglyLinkedList {

        // definition for a single node in the linked list
        class ListNode {
            private int value;
            private ListNode next;

            ListNode(int value, ListNode next) {
                this.value = value;
                this.next = next;
            }
        }

        private ListNode head; // start of the list
        private ListNode tail; // end of the llist

        // will initialize an empty linked list
        public DesignSinglyLinkedList() {
            // dummy node, helps removal and insertions at start of list
            head = new ListNode(-1, null);
            tail = head;
        }

        // will return the value of the ith node (0-indexed). If the index is out of bounds, return -1
        public int get(int index) {
            ListNode current = head.next;
            int i = 0;
            // traverse list until we find node at index (or reach out of bounds)
            while (current != null) {
                if (i == index) return current.value; // node found
                i++;
                current = current.next;
            }
            return -1; // index out of bounds
        }

        // will insert a node with val at the head of the list
        public void insertHead(int val) {
            // adds new head and moves old node +1 index
            ListNode newNode = new ListNode(val, head.next);
            head.next = newNode; // moves dummy pointer
            if (newNode.next == null) tail = newNode; // if list was empty before insertion, move tail pointer
        }

        // will insert a node with val at the tail of the list
        public void insertTail(int val) {
            tail.next = new ListNode(val, null); // adds new node
            tail = tail.next; // moves tail pointer
        }

        // will remove the ith node (0-indexed). If the index is out of bounds, return false, otherwise return true
        public boolean remove(int index) {
            ListNode current = head;
            int i = 0;
            while (i < index && current != null) {
                // move pointer to node BEFORE the target node
                i++;
                current = current.next;
            }
            // check to see if both the current AND the target node is not null
            if (current != null && current.next != null) {
                // if we delete the tail, update tail pointer
                if (current.next == tail) tail = current;
                // shift next pointer to "delete" target
                current.next = current.next.next;
                return true;
            }
            return false; // out of bounds
        }

        // return an array of all the values in the linked list, ordered from head to tail
        public ArrayList<Integer> getValues() {
            ListNode current = head.next;
            ArrayList<Integer> values = new ArrayList<>();
            while (current != null) {
                values.add(current.value);
                current = current.next;
            }
            return values;
        }
    }

    /**
     * Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++
     */
    class DesignDynamicArray {

        private int[] arr;
        private int capacity; // total available capacity of the array
        private int elements = 0; // current number of items in array

        // will initialize an empty array with a capacity of capacity, where capacity > 0
        DesignDynamicArray(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
        }

        // will return the element at index i. Assume that index i is valid
        public int get(int i) {
            return arr[i];
        }

        // will set the element at index i to n. Assume that index i is valid
        public void set(int i, int n) {
            arr[i] = n;
        }

        // Will push the element n to the end of the array.
        // If we call this but the array is full, we should resize the array first.
        public void pushback(int n) {
            if (elements >= capacity) resize();

            arr[elements] = n;
            elements++;
        }

        // will pop and return the element at the end of the array. Assume that the array is non-empty
        public int popback() {
            elements--;
            return arr[elements]; // soft deletion
        }

        // will double the capacity of the array
        private void resize() {
            capacity = capacity * 2;
            int[] temp = arr;
            arr = new int[capacity];

            // if (elements >= 0) System.arraycopy(temp, 0, arr, 0, elements);

            for (int i = 0; i < elements; i++) {
                arr[i] = temp[i];
            }
        }

        // will return the number of elements in the array
        public int getSize() {
            return elements;
        }

        // will return the capacity of the array
        public int getCapacity() {
            return capacity;
        }
    }
}