import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 */
public class LC_1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2]; //stores found indices
        Map<Integer, Integer> map = new HashMap<>(); //used to store and check for complement of (target - current number)

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // best case scenario we find a solution in second iteration, worst case we check all nums once
            if (map.containsKey(complement)) {

                result[0] = i;
                result[1] = map.get(complement);
                break;

            } else {

                map.put(nums[i], i); // adds current num to hashmap as future "reverse-complement"

            }
        }

        return result;
    }
}

