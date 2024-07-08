/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class LC_33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int leftP = 0; // left pointer for binary search
        int rightP = nums.length - 1; // right pointer for binary search

        // iterate until pointers meet
        while (leftP <= rightP) {

            int middleP = (leftP + rightP) / 2; // calculate middle pointer

            if (nums[middleP] == target) return middleP; // check if target is on middle pointer

            // check if we are in the left or right portion of the array
            if (nums[leftP] <= nums[middleP]) { // left portion
                if (target > nums[middleP] || target < nums[leftP]) { // search right side
                    leftP = middleP + 1;
                } else { // search left side
                    rightP = middleP - 1;
                }
            } else { // right portion
                if (target < nums[middleP] || target > nums[rightP]) { // search left side
                    rightP = middleP - 1;
                } else { // search right side
                    leftP = middleP + 1;
                }
            }
        }
        return -1; // target not found during binary search
    }
}
