/**
 *  https://www.geeksforgeeks.org/problems/aggressive-cows/1
 */

import java.util.*;

public class Problem8{

    public static int f(int[] stalls, int k){

        int n = stalls.length;

        Arrays.sort(stalls);

        int low = 1, high = stalls[n - 1] - stalls[0];

        int ans = high;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(stalls, mid, k)){
                ans = mid;

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] stalls, int minDiff, int k){
        
        int count = 1;

        int x = stalls[0];

        for(int i = 1; i < stalls.length; i++){

            int diff = stalls[i] - x;

            if(diff >= minDiff){
                count += 1;

                x = stalls[i];
            }
        }

        return count >= k;
    }

    public static void main(String[] args){

        int[] stalls = {2, 12, 11, 3, 26, 7};

        int k = 5;

        int res = f(stalls, k);

        System.out.println(res);
    }
}