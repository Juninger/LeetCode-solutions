/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 */
public class LC_153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int min = nums[0]; // stores smallest value we have found
        int leftP = 0; // left pointer for binary search
        int rightP = nums.length - 1; // right pointer for binary search

        // iterate until pointers meet
        while (leftP <= rightP) {
            if (nums[leftP] < nums[rightP]) { // we found a sorted subarray, compare to previous minimum
                min = Math.min(min, nums[leftP]); // update min if needed
                break; // smallest possible value found, exit loop
            }

            int midIndex = (leftP + rightP) / 2; // calculate the index of the midpoint with current pointers
            min = Math.min(min, nums[midIndex]); // update min if needed

            // check if we want to search the left or right side of nums
            if (nums[midIndex] >= nums[leftP]) { // midpoint is part of the left sorted side --> we search the right side
                leftP = midIndex + 1; // shift left pointer
            } else { // midpoint is part of the right sorted side --> we search the left side
                rightP = midIndex - 1; // shift right pointer
            }
        }
        return min;
    }
}
