import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class LC_128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>(); // stores all unique elements from input
        int longestSeq = 0; // longest sequence found

        // add all numbers to set
        for (int num : nums) set.add(num);

        for (int num : nums) {
            // check if current number is the start of a sequence
            if (!set.contains(num - 1)) { // current number IS the start of a sequence
                int currentSeq = 0; // length of current sequence
                // calculate total length of the sequence
                while (set.contains(num + currentSeq)) {
                    currentSeq++;
                }
                longestSeq = Math.max(longestSeq, currentSeq); // update longest sequence if needed
            }
        }
        return longestSeq;
    }
}
