/**
 *  Problem link -> https://leetcode.com/problems/minimum-time-to-complete-trips/description/
 */

public class Problem12{

    public static long f(int[] time, int totalTrips){

        int n = time.length;

        int min = Integer.MAX_VALUE;

        for(int t : time){
            min = Math.min(min, t);
        }

        long low = 1, high = 1L * min * totalTrips;

        long ans = high;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(time, mid, totalTrips, n)){
                ans = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] time, long maxTime, int totalTrips, int n){

        long res = 0;

        for(int i = 0; i < n; i++){

            long trip = maxTime / time[i];

            res += trip;
        }

        return res >= totalTrips;
    }

    public static void main(String[] args){

        int[] time = {5, 10, 10};

        int totalTrips = 9;

        long res = f(time, totalTrips);

        System.out.println(res);
    }
}