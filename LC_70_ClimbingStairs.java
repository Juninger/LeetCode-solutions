/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class LC_70_ClimbingStairs {

    private int[] memo; // used to memoize results of subproblems

    // brute force solution but with memoization for improved efficiency
    public int climbStairs(int n) {

        // initialize all values in memoization array to -1 to indicate non-computed values
        memo = new int[n + 1]; // +1 because we start from "step 0"
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        // start recursive method
        return stairClimber(n);
    }

    public int stairClimber(int n) {
        // base cases for small stairs or end of recursion
        if (n == 1) return 1; // one way to climb 1 step
        if (n == 2) return 2; // two ways to climb 2 steps (1+1 or 2)

        if (memo[n] != -1) return memo[n]; // result already calculated, return memoized value

        // for (n > 2): compute ways to climb the previous two steps and memoize result
        memo[n] = stairClimber(n - 1) + stairClimber(n - 2);
        return memo[n]; // return computed value
    }

    // brute force solution: calculate all permutations, inefficient and much redundant work
    // essentially creates a decision-tree structure with lots of overlapping calculations: O(2^n)
    public int climbStairs2(int n) {
        // base cases for small stairs or end of recursion
        if (n == 1) return 1; // one way to climb 1 step
        if (n == 2) return 2; // two ways to climb 2 steps (1+1 or 2)

        // for (n > 2): the way to climb n steps depends on the ways to climb the previous two steps
        return climbStairs2(n - 1) + climbStairs2(n - 2); // recursively sum subproblems
    }
}
