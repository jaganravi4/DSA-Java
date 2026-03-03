/**
 *  Problem link -> https://leetcode.com/problems/heaters/description/
 */

import java.util.*;

public class Problem1{

    public static int f(int[] houses, int[] heaters){

        int n = houses.length;

        int m = heaters.length;

        Arrays.sort(houses);

        Arrays.sort(heaters);

        int low = 0, high = Integer.MAX_VALUE;

        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(houses, heaters, n, m, mid)){
                ans = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] houses, int[] heaters, int n, int m, int radius){

        int i = 0, j = 0;

        while(i < n && j < m){

            int c = Math.abs(houses[i] - heaters[j]);

            if(c <= radius){
                i++;
            }else{
                j++;
            }
        }

        return i == n;
    }

    public static void main(String[] args){

        int[] houses = {1, 2, 3, 4};

        int[] heaters = {1, 4};

        int res = f(houses, heaters);

        System.out.println(res);
    }
}