/**
 *  Problem statement -> In workshop -> N problems {t, s} where t is time and s is skill.
 * 
 *  you have x time and k slot. find the max skill gain you can get?
 * 
 *  eg : problems = {{3, 3}, {5, 4}, {4, 1}, {2, 3}, {1, 1}}, x = 6, k = 2 -> 6 (output)
 */

import java.util.*;

public class Problem1{

    public static int f_brute(int level, int timeTaken, int itemTaken, int[][] p, int n, int x, int k){

        // base case
        if(level == n){
            return 0;
        }

        // not pick
        int ans = f_brute(level + 1, timeTaken, itemTaken, p, n, x, k);

        // pick
        if(timeTaken + p[level][0] <= x && itemTaken + 1 <= k){
            int pick = p[level][1] + f_brute(level + 1, timeTaken + p[level][0], itemTaken + 1, p, n, x, k);

            ans = Math.max(ans, pick);
        }

        return ans;
    }

    public static int f_optimal(int level, int timeTaken, int itemTaken, int[][] p, int n, int x, int k, int[][][] dp){

        if(level == n){
            return 0;
        }

        // cache check
        if(dp[level][timeTaken][itemTaken] != -1){
            return dp[level][timeTaken][itemTaken];
        }

        // not pick
        int ans = f_optimal(level + 1, timeTaken, itemTaken, p, n, x, k, dp);

        // pick
        if(timeTaken + p[level][0] <= x && itemTaken + 1 <= k){
            int pick = p[level][1] + f_optimal(level + 1, timeTaken + p[level][0], itemTaken + 1, p, n, x, k, dp);

            ans = Math.max(ans, pick);
        }

        dp[level][timeTaken][itemTaken] = ans;

        return ans;
    }

    public static void main(String[] args){

        int[][] p = {{3, 3}, {5, 4}, {4, 1}, {2, 3}, {1, 1}};

        int n = p.length;

        int x = 6, k = 2;

        // int res = f_brute(0, 0, 0, p, n, x, k);

        int[][][] dp = new int[n + 1][x + 1][k + 1];

        for(int i = 0; i < dp.length; i++){

            for(int j = 0; j < dp[0].length; j++){

                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = f_optimal(0, 0, 0, p, n, x, k, dp);

        System.out.println(res);
    }
}