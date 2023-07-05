import java.util.HashMap;
import java.util.Map;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 */
public class LC_167_TwoSum2_InputArrayIsSorted {

    // Uses two pointers [left, right] to traverse numbers-array from both sides
    // We know ONE solution exists, thus the target will be found before the pointers meet
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) { // Iterates until pointers meet

            int sum = numbers[left] + numbers[right]; // Current sum of a smaller number on the left and a larger number on the right

            if (sum > target) { // Current sum too large, we decrease the right pointer to make it smaller
                right--;
            } else if (sum < target) { // Current sum too small, we increase the left pointer to make it bigger
                left++;
            } else { // Current sum is equal to target, we return the pointers to the indices (+1 because of 1-indexing)
                return new int[] {left+1 , right+1};
            }
        }
        return null; // Will never be reached since we know a solution exists
    }

    // Same solution as "LC_1_TwoSum" but modified for 1-indexing
    // Overall slow solution with some extra space due to complement hashmap
    public int[] twoSum2(int[] numbers, int target) {

        int[] result = new int[2]; // Stores found indices
        Map<Integer, Integer> map = new HashMap<>(); // Used to store and check for complement of (target - current number)

        for (int i = 0; i < numbers.length; i++) {

            int complement = target - numbers[i];

            if (map.containsKey(complement)) { // Numbers found

                result[0] = map.get(complement); // First index
                result[1] = i+1; // Second index
                break;

            } else {

                map.put(numbers[i], i+1); // Adds current number to hashmap as future "reverse-complement"

            }
        }

        return result;
    }
}
