/**
 *  Problem link -> https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
 */

public class Problem14{

    public static int f(int[] candies, long k){

        int n = candies.length;

        long low = 1, high = 0;

        long maxCandies = 0;

        for(int c : candies){
            high = Math.max(high, c);

            maxCandies += c;
        }

        if(maxCandies < k){
            return 0;
        }

        long ans = low;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(candies, mid, k, n)){

                ans = mid;

                low = mid + 1;
            }else{

                high = mid - 1;
            }
        }

        return (int) ans;
    }

    public static boolean isPossible(int[] candies, long maxCandies, long k, int n){

        long res = 0;

        for(int i = 0; i < n; i++){

            res += ((candies[i] * 1L) / maxCandies);

            if(res >= k){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        int[] candies = {5, 8, 6};

        long k = 4;

        int res = f(candies, k);

        System.out.println(res);
    }
}