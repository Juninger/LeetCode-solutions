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

        // add all numbers (up to k) to the heap with custom add-method
        for (int num : nums) add(num);
    }

    // add new elements and return the kth largest
    public int add(int val) {

        if (minHeap.size() < k) minHeap.add(val); // less than k elements, add new val directly
        else if (val > minHeap.peek()) { // new val larger than smallest in heap
            minHeap.poll(); // remove smallest element
            minHeap.add(val); // add new value to heap
        }

        return minHeap.peek(); // kth smallest element is stored in root of heap
    }

    /* -------------------------------------------------------------------------------------------- */

    // min-heap that stores the k largest elements
    PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();
    int k2;

    /*
    public LC_703_KthLargestElementInAStream2(int k, int[] nums) {

        this.k2 = k; // store value of k in class variable

        // add all numbers to the heap
        for (int num : nums) minHeap2.add(num);

        // remove elements to only keep the k largest
        while (minHeap2.size() > k) minHeap2.poll();
    }
    */

    // add new elements and return the kth largest
    public int add2(int val) {
        minHeap2.add(val); // add new value to heap
        if (minHeap2.size() > k2) minHeap2.poll(); // more than k elements in heap --> remove the smallest one
        return minHeap2.peek(); // kth smallest element is stored in root of heap
    }
}
