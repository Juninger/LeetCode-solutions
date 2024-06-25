import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 */
public class LC_703_KthLargestElementInAStream {

    // min-heap that stores the k largest elements
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public LC_703_KthLargestElementInAStream(int k, int[] nums) {

        this.k = k; // store value of k in class variable

        // add all numbers to the heap
        for (int num : nums) minHeap.add(num);

        // remove elements to only keep the k largest
        while (minHeap.size() > k) minHeap.poll();
    }

    // add new elements and return the kth largest
    public int add(int val) {
        minHeap.add(val); // add new value to heap
        if (minHeap.size() > k) minHeap.poll(); // more than k elements in heap --> remove the smallest one
        return minHeap.peek(); // kth smallest element is stored in root of heap
    }
}
