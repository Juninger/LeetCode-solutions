import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class LC_215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // iterate input and keep the k largest elements in minHeap
        for (int num : nums) {

            // ensures that we maintain a maximum of k elements in heap
            if (minHeap.size() < k) minHeap.add(num); // less than k elements, add new val
            else if (num > minHeap.peek()) { // new val larger than smallest in heap
                minHeap.poll(); // remove smallest element
                minHeap.add(num); // add new value to heap
            }
        }
        return minHeap.peek();
    }
}
