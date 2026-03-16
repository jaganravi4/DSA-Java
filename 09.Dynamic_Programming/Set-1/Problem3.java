/**
 *  https://leetcode.com/problems/climbing-stairs/description/
 */

public class Problem3{

    public static int f(int level, int n, int[] dp){

        if(level > n){
            return 0;
        }

        if(level == n){
            return 1;
        }

        if(dp[level] != -1){
            return dp[level];
        }

        int ans = 0;

        ans += f(level + 1, n, dp);

        ans += f(level + 2, n, dp);

        dp[level] = ans;

        return ans;
    }

    public static void main(String[] args){

        int n = 10;

        int[] dp = new int[50];

        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }

        int res = f(0, n, dp);

        System.out.println(res);
    }
}