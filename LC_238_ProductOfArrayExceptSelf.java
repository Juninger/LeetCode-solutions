/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class LC_238_ProductOfArrayExceptSelf {

    /**
     * Solution that uses no extra space.
     * Iterates input array length twice and uses result array to store intermediate states
     * of left products (1st pass) and right products (2nd pass)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];

        results[0] = 1; // no element to the left of first number
        // build array with products of all elements to the left of [i]
        for (int i = 1; i < nums.length; i++) {
            results[i] = nums[i - 1] * results[i - 1]; // calculates product of all elements to left of nums[i]
        }

        int rightProd = 1; // no element to the right of last number
        // update result array with products of all elements to left AND right of [i]
        for (int i = nums.length - 1; i >= 0; i--) { // iterate backwards
            results[i] = results[i] * rightProd; // multiplies current result (left product) with right product
            rightProd *= nums[i]; // updates right prod to include element at nums[i] in next iteration
        }
        return results;
    }

    // solution that uses extra space (2x arrays) to store the product of all numbers left and right of nums[i]
    public int[] productExceptSelf2(int[] nums) {
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
