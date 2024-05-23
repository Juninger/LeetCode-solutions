import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class LC_347_TopKFrequentElements {

    // slow solution : uses map to track most frequent numbers
    public int[] topKFrequent(int[] nums, int k) {

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
