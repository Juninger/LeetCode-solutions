/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class LC_70_ClimbingStairs {

    // dynamic programming solution with constant space
    public int climbStairs(int n) {

        // base cases
        if (n == 1) return 1; // one way to climb 1 step
        if (n == 2) return 2; // two ways to climb 2 steps (1+1 or 2)

        // number of ways to reach the previous two steps
        int twoStepsBack = 1; // one way to climb the first step
        int oneStepBack = 2; // two ways to climb the second step

        // calculate ways to reach each step
        for (int i = 3; i <= n; i++) {
            int thisStep = twoStepsBack + oneStepBack; // number of ways to reach the current step
            twoStepsBack = oneStepBack; // move pointer for twoStepsBack to oneStepBack
            oneStepBack = thisStep; // move pointer for oneStepBack to current step
        }

        // ways to reach the final step is stored in the final value of oneStepBack after loop
        return oneStepBack;
    }

    /* -------------------------------------------------------------------------------------------- */

    // dynamic programming solution with bottom-up approach
    public int climbStairs2(int n) {

        // base cases
        if (n == 1) return 1; // one way to climb 1 step
        if (n == 2) return 2; // two ways to climb 2 steps (1+1 or 2)

        // stores computed results for how many ways to reach i:th step
        int[] results = new int[n + 1];
        results[1] = 1; // 1 way to reach first step
        results[2] = 2; // 2 ways to reach second step

        // calculate ways to reach each step
        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        // ways to reach the final step is stored in the last value of array
        return results[n];
    }

    /* -------------------------------------------------------------------------------------------- */

    private int[] memo; // used to memoize results of subproblems

    // brute force solution but with memoization for improved efficiency
    public int climbStairs3(int n) {

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

    /* -------------------------------------------------------------------------------------------- */

    // brute force solution: calculate all permutations, inefficient and much redundant work
    // essentially creates a decision-tree structure with lots of overlapping calculations: O(2^n)
    public int climbStairs4(int n) {
        // base cases for small stairs or end of recursion
        if (n == 1) return 1; // one way to climb 1 step
        if (n == 2) return 2; // two ways to climb 2 steps (1+1 or 2)

        // for (n > 2): the way to climb n steps depends on the ways to climb the previous two steps
        return climbStairs4(n - 1) + climbStairs4(n - 2); // recursively sum subproblems
    }
}
