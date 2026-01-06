/**
 *  Given an array [Arr] of size N and initially all 0's.
 *  you need to answer Q queries of the form:
 *  +ADLR -> add the arithmatic progression of first term A and
 *          common difference D to the range L to R.
 *      
 *      Arr[L] += A;
 *      Arr[L + 1] += A + D;
 *      Arr[L + 2] += A + 2 * D;
 *      ... 
 *      Arr[R] += A + (R - L) * D;
 */

import java.util.*;

public class Problem5{

    public static void f_brute(int[] arr, int[][] q){

        for(int[] range : q){

            int a = range[0];

            int d = range[1];

            int l = range[2];

            int r = range[3];

            queryRangeSum(arr, a, d, l, r);
        }
    }

    public static void queryRangeSum(int[] arr, int a, int d, int l, int r){

        for(int i = l; i <= r; i++){
            arr[i] += (a + (i - l) * d);
        }
    }

    public static void f_optimal(int[] arr, int[][] q){

        int n = arr.length;

        int[] p1= new int[n];

        int[] p2 = new int[n];

        for(int[] range : q){

            int a = range[0];

            int d = range[1];

            int l = range[2];

            int r = range[3];

            queryRangeSumOptimal(p1, p2, a, d, l, r, n);
        }

        for(int i = 1; i < n; i++){
            p1[i] = p1[i - 1] + p1[i];

            p2[i] = p2[i - 1] + p2[i];
        }

        for(int i = 0; i < n; i++){
            arr[i] = p1[i] + p2[i] * i;
        }
    }

    public static void queryRangeSumOptimal(int[] p1, int[] p2, int a, int d, int l, int r, int n){

        int x = a - (l * d);

        p1[l] += x;

        if(r != n - 1){
            p1[r + 1] += (-1 * x);
        }

        p2[l] += d;

        if(r != n - 1){
            p2[r + 1] += (-1 * d);
        }
    }

    public static void print(int[] arr, int n){

        for(int i = 0; i < n; i++){

            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){

        int n = 5;

        int[] arr = new int[n];

        int[][] q = { {2, 1, 0, 2}, {1, 2, 1, 3}, {2, 3, 2, 4} }; // { A, D, L, R}

        // f_brute(arr, q);

        f_optimal(arr, q);

        print(arr, n);
    }
}