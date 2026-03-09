/**
 *  Given an integer array and a number k, return true/false. if the given array is divided into pairs
 *  such that each pairs sum is divisible by k. (length of the array is always even)
 * 
 *  eg: arr = {9, 7, 5, 3} k = 6 -> return true [9, 3], [7, 5];
 */

import java.util.*;

public class Problem4{

    public static boolean f_brute(int[] arr, int k){

        int n = arr.length;

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){

            if(vis[i]){
                continue;
            }

            for(int j = i + 1; j < n; j++){

                if(vis[j]){
                    continue;
                }

                int sum = arr[i] + arr[j];

                if(sum % k == 0){

                    vis[i] = true;

                    vis[j] = true;

                    break;
                }
            }
        }

        for(int i = 0; i < n; i++){

            if(!vis[i]){
                return false;
            }
        }

        return true;
    }

    public static boolean f_optimal(int[] arr, int k){

        int n = arr.length;

        int[] freq = new int[k];

        for(int i = 0; i < n; i++){
            
            int x = ((arr[i] % k) + k) % k;

            freq[x]++;
        }   

        if(freq[0] % 2 != 0){
            return false;
        }

        for(int i = 1; i <= (k / 2); i++){

            if(freq[i] != freq[k - i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        int[] arr = {9, 7, 5, 3};

        int k = 6;

        // boolean res = f_brute(arr, k);

        boolean res = f_optimal(arr, k);

        System.out.println(res);
    }
}
