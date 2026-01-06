/**
 *  Given an array [Arr] of size N and initially all 0's and you are also given a fixed integer k.
 *  you need to answer Q queries of the form:
 *  +ALR -> add the GP with first term A and
 *          common ratio k to the range L to R.
 *      
 *      Arr[L] += A;
 *      Arr[L + 1] += A * k;
 *      Arr[L + 2] += A * k ^ 2;
 *      ... 
 *      Arr[R] += A * k ^ (R - L);
 */

import java.util.*;

public class Problem6{

    public static void f_brute(int[] arr, int[][] q, int k){

        for(int[] range : q){

            int a = range[0];

            int l = range[1];

            int r = range[2];

            queryRangeSum(arr, a, l, r, k);
        }
    }

    public static void queryRangeSum(int[] arr, int a, int l, int r, int k){
        
        int pow = 1;

        for(int i = l; i <= r; i++){
            arr[i] += (a * pow);

            pow *= k;
        }
    }

    public static void f_optimal(int[] arr, int[][] q, int k){

        int n = arr.length;

        int[] p = new int[n + 1];

        int pow = 1;

        for(int i = 0; i <= n; i++){
            p[i] = pow;

            pow *= k;
        }

        for(int[] range : q){

            int a = range[0];

            int l = range[1];

            int r = range[2];

            queryRangeSumOptimal(arr, p, a, l, r, n);
        }

        for(int i = 1; i < n; i++){
            arr[i] = arr[i - 1] * k + arr[i];
        }
    }

    public static void queryRangeSumOptimal(int[] arr, int[] p, int a, int l, int r, int n){

        int pow = p[r - l + 1];

        if(r + 1 < n){
            arr[r + 1] -= (a  * pow);
        }

        arr[l] += a;
    }

    public static void print(int[] arr, int n){

        for(int i = 0; i < n; i++){

            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){

        int n = 5;

        int[] arr = new int[n];

        int k = 2;

        int[][] q = { {2, 0, 2}, {1, 1, 3}, {3, 2, 4} };

        // f_brute(arr, q, k);

        f_optimal(arr, q, k);

        print(arr, n);
    }
}