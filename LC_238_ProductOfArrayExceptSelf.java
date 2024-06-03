/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class LC_238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] leftProds = new int[nums.length];
        int[] rightProds = new int[nums.length];
        int[] results = new int[nums.length];

        // build array with product of all nums to the left of nums[i]
        leftProds[0] = 1; // no element to the left of first number
        for (int i = 1; i < nums.length; i++) { // start from second element
            leftProds[i] = nums[i - 1] * leftProds[i - 1];
        }

        // build array with product of all nums to the right of nums[i]
        rightProds[nums.length - 1] = 1; // no element to the right of last number
        for (int i = nums.length - 2; i >= 0; i--) { // start from second to last element, iterate backwards
            rightProds[i] = nums[i + 1] * rightProds[i + 1];
        }

        // build result array by multiplying products to the left and right of i
        for (int i = 0; i < nums.length; i++) {
            results[i] = leftProds[i] * rightProds[i];
        }
        return results;
    }
}
