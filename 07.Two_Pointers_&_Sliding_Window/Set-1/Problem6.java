/**
 *  Given an array of integers. find the max sum of a subarray whose size is k.
 */

import java.util.*;

public class Problem6{

    public static int f_brute(int[] arr, int k){

        int n = arr.length;

        if(n < k){
            return 0;
        }

        int res = 0;

        for(int i = 0; i <= n - k; i++){

            int sum = 0;

            for(int j = i; j < k + i - 1; j++){

                sum += arr[j];

                if(j - i + 1 == k){

                    if(res < sum){
                        res = sum;
                    }

                    break;
                }
            }
        }

        return res;
    }

    public static int f_optimal(int[] arr, int k){

        int n = arr.length;

        if(n < k){
            return 0;
        }

        int[] p = new int[n + 1];

        for(int i = 1; i <= n; i++){

            p[i] = p[i - 1] + arr[i - 1];
        }

        int i = 0, j = k;

        int res = 0;

        while(j <= n){

            int sum = p[j] - p[i];

            if(res < sum){
                res = sum;
            }

            i++;

            j++;
        }

        return res;
    }

    public static int f_optimal_2(int[] arr, int k){

        int n = arr.length;

        int max = 0;

        int sum = 0;

        int i = 0, j = 0;

        while(j < k){

            sum += arr[j];

            j++;
        }

        while(j < n){
            max = Math.max(max, sum);

            sum += arr[j];

            sum -= arr[i];

            i++;

            j++;
        }

        max = Math.max(sum, max);

        return max;
    }

    public static void main(String[] args){

        int[] arr = {1, 3, 5, 2, 7};

        int k = 1;

        // int res = f_brute(arr, k);

        // int res = f_optimal(arr, k);

        int res = f_optimal_2(arr, k);

        System.out.println(res);
    }
}