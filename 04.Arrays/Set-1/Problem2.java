/**
 *  Problem link -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

import java.lang.Math.*;

public class Problem2{

    // try out all possible cases
    public static int f_brute(int[] prices, int n){

        int maxProfit = 0;

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){
                
                int profit = prices[j] - prices[i];

                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }

    public static int f_brute_rec(int[] prices, int idx, int n, int maxProfit){
        if(idx == n){
            return maxProfit;
        }

        for(int i = idx + 1; i < n; i++){

            int profit = prices[i] - prices[idx];

            maxProfit = Math.max(profit, maxProfit);  
        }

        return f_brute_rec(prices, idx + 1, n, maxProfit);
    }

    public static int f_optimal(int[] prices, int n){
        int maxProfit = 0;

        int curr_min = prices[0];

        for(int i = 1; i < n; i++){
            // calculate candidate profit
            int profit = prices[i] - curr_min;

            // check if candidate profit is greater that maxProfit
            maxProfit = Math.max(profit, maxProfit);

            // check if ith stock price is smaller that curr_min
            curr_min = Math.min(prices[i], curr_min);
        }

        return maxProfit;
    }

    public static int f_optimal_rec(int[] prices, int idx, int n, int maxProfit, int curr_min){
        if(idx == n){
            return maxProfit;
        }

        int profit = prices[idx] - curr_min;
        
        maxProfit = Math.max(profit, maxProfit);

        curr_min = Math.min(prices[idx], curr_min);
        
        return f_optimal_rec(prices, idx + 1, n, maxProfit, curr_min);
    }

    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};

        int n = prices.length;

        // int res = f_brute(prices, n);

        // int res = f_brute_rec(prices, 0, n, 0);

        // int res = f_optimal(prices, n);

        int res = f_optimal_rec(prices, 1, n, 0, prices[0]);

        System.out.println(res);
    }
}