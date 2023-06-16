/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class LC_121_BestTimeToBuyAndSellStock {

    // Brute force solution, very slow --> O(N^2)
    public int maxProfit2(int[] prices) {

        int maxProfit = 0; // tracks current best profit

        // for every price, check the profit when comparing to all other prices
        for (int i = 0; i < prices.length; i++) {

            int buy = prices[i]; // current buy price

            for (int j = i+1; j < prices.length; j++) {

                int sell = prices[j]; // current sell price
                int profit = sell - buy;

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
