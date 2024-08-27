/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 */
public class LC_287_FindTheDuplicateNumber {

    /*
    --Floyd's Tortoise and Hare algorithm for cycle detection in linked lists--
    - We imagine the input array as a linked list where every element points to the next INDEX (e.g. nums[i] would be the next node to visit)
    - Since we have n+1 numbers that are all between 1 and 'n', there must be a "cycle" in our imaginary linked list (two nodes will point to the same NEXT-node)
    - By using two pointers, we can find where the "cycle" starts which will also be our duplicate number
    */
    public int findDuplicate(int[] nums) {
        // initialize pointers to first element of the array
        int tortoise = nums[0]; // slow pointer
        int hare = nums[0]; // fast pointer

        // first we need both pointers to be placed somewhere within the cycle
        do {
            tortoise = nums[tortoise]; // move ONE step at a time with the slow pointer
            hare = nums[nums[hare]]; // move TWO steps at a time with the fast pointer
        } while (tortoise != hare); // pointers met

        tortoise = nums[0]; // reset slow pointer (keep fast pointer at meeting point from previous loop)

        // now we try to find the duplicate number by checking the NEXT-nodes of both the fast and slow pointers
        while (tortoise != hare) { // this time we move both pointers ONE step at a time until they meet
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise; // duplicate number
    }
}
