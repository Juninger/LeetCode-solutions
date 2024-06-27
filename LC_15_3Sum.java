import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class LC_15_3Sum {

    // basic idea is to sort the input and then use two-pointers as in "LC_167_TwoSum2_InputArrayIsSorted"
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) return new ArrayList<>(); // edge case, not enough numbers in input

        ArrayList<List<Integer>> resultList = new ArrayList<>(); // stores found solutions

        Arrays.sort(nums); // sort input array --> O(n log(n))

        // iterate all numbers in input
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue; // current value is same as previous, skip iteration

            int leftP = i + 1; // start left pointer at i + 1
            int rightP = nums.length - 1; // start right pointer at last number

            // iterate rest of input until pointers meet or a solution is found
            while (leftP < rightP) {

                // sum of current number plus numbers at pointers
                int sum = nums[i] + nums[leftP] + nums[rightP];

                if (sum > 0) {
                    rightP--; // decrease right pointer to check for smaller sum
                } else if (sum < 0) {
                    leftP++; // increase right pointer to check for larger sum
                } else { // sum is 0 --> add to list of results
                    ArrayList<Integer> threeSum = new ArrayList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[leftP]);
                    threeSum.add(nums[rightP]);
                    resultList.add(threeSum);

                    do { // updates pointer while also checking for duplicates
                        leftP++;
                    } while (nums[leftP] == nums[leftP - 1] && leftP < rightP);
                }
            }
        }
        return resultList;
    }
}
