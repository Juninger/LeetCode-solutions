/**
 * This class holds a collection of "core skill" problems
 * to solve from NeetCode.io (https://neetcode.io/practice).
 */
public class NeetCodeCore {

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
