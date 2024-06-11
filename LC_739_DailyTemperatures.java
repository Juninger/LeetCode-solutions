import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Example:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: results = [1,1,4,2,1,1,0,0]
 */
public class LC_739_DailyTemperatures {

    // optimized solution that only needs one pass over array
    public int[] dailyTemperatures(int[] temperatures) {

        int[] results = new int[temperatures.length]; // stores number of days until warmer temp (from i:th day)
        Stack<Integer> stack = new Stack<>(); // stores indices of temperatures

        // iterate over each input element
        for (int i = 0; i < temperatures.length; i++) {

            // while we have temps left to compare AND the current is warmer than top of stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop(); // index of the colder day
                results[idx] = i - idx; // calculate number of days until warmer day is found
            }
            stack.push(i); // adds current index to the stack --> waiting for a warmer day
        }
        // default value of untouched elements are 0
        return results;
    }

    // bad and slow solution that brute forces all temperature comparisons in O(N^2)
    public int[] dailyTemperatures2(int[] temperatures) {

        int[] results = new int[temperatures.length];

        // iterates all days and compares temperature with all days after
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) { // warmer day found
                    results[i] = j - i;
                    break;
                }
            }
        }
        return results;
    }
}
