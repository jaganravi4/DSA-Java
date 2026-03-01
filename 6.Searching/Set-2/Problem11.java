/**
 *  Problem link -> https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 */

public class Problem11{

    public static int f(int[] bloomDay, int m, int k){
        int n = bloomDay.length;

        if((n / k) < m){
            return -1;
        }

        int low = Integer.MAX_VALUE;

        int high = Integer.MIN_VALUE;

        for(int day : bloomDay){

            low = Math.min(low, day);

            high = Math.max(high, day);
        }

        int ans = high;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(bloomDay, mid, m, k, n)){
                ans = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] bloomDay, int maxDay, int m, int k, int n){
        
        int count = 0;

        for(int i = 0; i < n; i++){

            if(bloomDay[i] <= maxDay){
                count += 1;

            }else{
                count = 0;
            }

            if(count == k){
                m -= 1;

                count = 0;
            }
        }

        return m <= 0;
    }

    public static void main(String[] args){

        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};

        int m = 2, k = 3;

        int res = f(bloomDay, m, k);

        System.out.println(res);
    }
}