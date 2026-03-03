/**
 *  Problem link -> https://leetcode.com/problems/maximum-running-time-of-n-computers/description/
 */

public class Problem4{

    public static long f(int n, int[] batteries){

        int k = batteries.length;

        if(n > k){
            return 0;
        }

        long sum = 0;

        for(int b : batteries){
            sum += (b * 1L);
        }

        long low = 1, high = (1L * sum / n);

        long ans = 1;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(n, batteries, mid, k)){
                ans = mid;

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int n, int[] batteries, long minute, int k){

        long sum = 0;

        for(int i = 0; i < k; i++){

            sum += (Math.min(batteries[i], minute) * 1L);

            if(sum >= 1L * n * minute){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        int n = 2;

        int[] batteries = {6, 3};

        long res = f(n, batteries);

        System.out.println(res);
    }
}