import java.util.Arrays;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 *
 * !!! The top floor is NOT in the array, it is technically the "step" at cost[n] !!!
 * Overall, the problem is an extension of LC_70_ClimbingStairs
 */
public class LC_746_MinCostClimbingStairs {

    // dynamic programming solution with constant space
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; // also the "index" of the "step" we need to reach
        if (n == 0) return 0; // no steps
        if (n == 1) return cost[0]; // only one step

        // tracks minimum cost to reach the two previous step from the current step
        int twoStepsBack = cost[0];
        int oneStepBack = cost[1];

        // calculate cost to reach the top, starting from the third step
        for (int i = 2; i < n; i++) {
            int thisStep = cost[i] + Math.min(twoStepsBack, oneStepBack);
            twoStepsBack = oneStepBack; // move pointer for twoStepsBack to oneStepBack
            oneStepBack = thisStep; // move pointer for oneStepBack to current step
        }

        // The minimum cost to reach the top is the minimum of reaching the last two steps
        return Math.min(twoStepsBack, oneStepBack);
    }

    /* -------------------------------------------------------------------------------------------- */

    // dynamic programming solution with bottom-up approach
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length; // also the "index" of the "step" we need to reach
        if (n == 0) return 0; // no steps
        if (n == 1) return cost[0]; // only one step

        int[] results = new int[n]; // stores computed results for cost of reaching i:th step
        results[0] = cost[0]; // cost for reaching first step
        results[1] = cost[1]; // cost for reaching second step

        // calculate costs for reaching each step in input array
        for (int i = 2; i < n; i++) {
            // cost of current step + the MIN cost of reaching the previous two steps
            results[i] = cost[i] + Math.min(results[i - 1], results[i - 2]);
        }

        // minimum cost to reach the top is the minimum cost of reaching any of the last two steps
        return Math.min(results[n - 1], results[n - 2]);
    }

    /* -------------------------------------------------------------------------------------------- */

    // brute force solution with memoization
    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length; // also the "index" of the "step" we need to reach
        int[] memo = new int[n]; // stores already calculated values for fast retrieval
        Arrays.fill(memo, -1); // initializes all values to -1 to indicate non-calculated steps

        // start recursion to calculate cost of reaching the top ("index" n)
        return Math.min(minCost3(cost, n - 1, memo), minCost3(cost, n - 2, memo));
    }

    // recursively calculate cost to reach i:th step
    public int minCost3(int[] cost, int index, int[] memo) {
        if (index == 0) return cost[0]; // cost of first step
        if (index == 1) return cost[1]; // cost of second step

        // check if cost of reaching step has already been calculated
        if (memo[index] != -1) return memo[index];

        // calculate and memoize cost of reaching current step (cost of current step + the MIN cost of reaching the previous two steps)
        memo[index] = cost[index] + Math.min(minCost3(cost, index - 1, memo), minCost3(cost, index - 2, memo));

        return memo[index];
    }

    /* -------------------------------------------------------------------------------------------- */

    // brute force solution, highly inefficient in both space and time
    public int minCostClimbingStairs4(int[] cost) {
        int n = cost.length; // also the "index" of the "step" we need to reach

        // start recursion to calculate cost of reaching the top ("index" n)
        return Math.min(minCost4(cost, n - 1), minCost4(cost, n - 2));
    }

    // recursively calculate cost to reach i:th step
    public int minCost4(int[] cost, int index) {
        if (index == 0) return cost[0]; // cost of first step
        if (index == 1) return cost[1]; // cost of second step

        // cost for i:th step == cost of current step + the MIN cost of reaching the previous two steps
        return cost[index] + Math.min(minCost4(cost, index - 1), minCost4(cost, index - 2));
    }
}
