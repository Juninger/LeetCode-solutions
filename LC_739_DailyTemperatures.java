/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Example:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: results = [1,1,4,2,1,1,0,0]
 */
public class LC_739_DailyTemperatures {

    // bad and slow solution that brute forces all temperature comparisons in O(N^2)
    public int[] dailyTemperatures(int[] temperatures) {

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
