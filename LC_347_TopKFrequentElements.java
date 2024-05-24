import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class LC_347_TopKFrequentElements {

    // Min-Heap (priority queue) solution
    public int[] topKFrequent(int[] nums, int k) {

        // frequency map < number : frequency >
        Map<Integer, Integer> freqMap = new HashMap<>();

        // builds frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // defines structure and rules for the min-heap using Java's built-in Comparator and PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                // compares based on frequency value in freqMap's entrySets
                Comparator.comparingInt(Map.Entry::getValue)
        );

        // iterates through frequency map
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            // adds entry to min-heap
            minHeap.offer(entry);
            // removes entry with the lowest frequency if heap contains more than 'k' elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // builds result array, remaining elements in heap are the top k frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }


    // slow solution : uses map to track most frequent numbers
    public int[] topKFrequent2(int[] nums, int k) {

        if (nums.length == 1) return nums;

        // frequency map < number : frequency >
        Map<Integer, Integer> freqMap = new HashMap<>();

        // builds frequency map
        for (int num : nums) {
            // add +1 of current number to frequency map
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        // finds top 'k' entries in map
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> maxEntry = null;
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
            if (maxEntry != null) {
                result[i] = maxEntry.getKey(); // adds current max entry to result list
                freqMap.remove(maxEntry.getKey()); // removes current max from map
            }
        }
        return result;
    }
}
