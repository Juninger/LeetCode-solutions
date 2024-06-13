/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class LC_70_ClimbingStairs {

    // brute force solution: calculate all permutations, inefficient and much redundant work
    // essentially creates a decision-tree structure with lots of overlapping calculations: O(2^n)
    public int climbStairs(int n) {
        // base cases for small stairs, terminates recursion
        if (n == 1) return 1; // one way to climb 1 step
        if (n == 2) return 2; // two ways to climb 2 steps (1+1 or 2)

        // for (n > 2): the way to climb n steps depends on the ways to climb the previous two steps
        return climbStairs(n - 1) + climbStairs(n - 2); // recursively sum subproblems
    }
}
