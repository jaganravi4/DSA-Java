/**
 *  Problem link -> https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
 */

public class Problem3{

    public static int f(int[] dist, double hour){

        int n = dist.length;

        int low = 1, high = 1000000000;

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(dist, mid, hour, n)){
                ans = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] dist, int mid, double hour, int n){

        double h = 0;

        for(int i = 0; i < n; i++){

            h = Math.ceil(h);

            double x = ((double) dist[i] / mid);

            h += x;
        }

        return h <= hour;
    }

    public static void main(String[] args){

        int[] dist = {1, 3, 2};

        double hour = 6;

        int res = f(dist, hour);

        System.out.println(res);
    }
}