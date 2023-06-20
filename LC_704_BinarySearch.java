import java.util.Arrays;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class LC_704_BinarySearch {

    // Non-recursive manual implementation with pointers
    public int search(int[] nums, int target) {

        // Pointers represent the boundaries of the sub-array being searched --> "current search space"
        int leftPointer = 0;
        int rightPointer = nums.length -1;

        // Traverse nums until pointers meet
        while (leftPointer <= rightPointer) {

            // Same result as "(leftPointer + rightPointer) / 2" but avoids risk of integer overflow
            int midIndex = leftPointer + (rightPointer - leftPointer) / 2;
            
            if (nums[midIndex] == target) { // Target found on middle index of current search space
                return midIndex;
            } else if (nums[midIndex] < target) { // Target "exists" on the RIGHT half of current search space
                leftPointer = midIndex + 1;
            } else { // Target "exists" on the LEFT half of current search space
                rightPointer = midIndex - 1;
            }
        }

        return -1; // Target not found in array
    }

    // Implementation using Java libraries, still very fast and easy to understand
    public int search2(int[] nums, int target) {

        int index = Arrays.binarySearch(nums, target);

        return Math.max(index, -1); // Returns target's index or -1, see Arrays.binarySearch return-specification
    }
}
