/**
 *  Given a fixed array A of size N and integer K.
 *  you need to answer Q queries of the form:
 *  ?LR -> find the value of the following expression
 *      
 *      A[L] + A[L + 1] * k + A[L + 2] * k ^ 2 + ... + A[R] * k ^ (R - L)
 */

import java.util.*;

public class Problem4{

    public static void f_brute(int[] arr, int[][] q, int k){

        for(int[] range: q){
            int l = range[0];

            int r = range[1];

            int sum = queryRangeSum(arr, l, r, k);

            System.out.println(sum);
        }
    }

    public static int queryRangeSum(int[] arr, int l, int r, int k){
        int sum = 0;

        int pow = 1;

        for(int i = l; i <= r; i++){
            sum += (arr[i] * pow);

            pow *= k;
        }

        return sum;
    }

    public static void f_optimal(int[] arr, int[][] q, int k){

        int n = arr.length;

        int pow = k;

        // precompute sum
        int[] p1 = new int[n];

        p1[0] = arr[0];

        for(int i = 1; i < n; i++){
            p1[i] = p1[i - 1] + (arr[i] * pow);

            pow *= k;
        }

        int[] p2 = new int[n];

        int x = 1;

        for(int i = 0; i < n; i++){

            p2[i] = x;

            x *= k;
        }
        
        for(int[] range : q){

            int l = range[0];

            int r = range[1];

            // int sum = queryRangeSumOptimal(p1, l, r, k);

            int sum = queryRangeSumOptimal2(p1, p2, l, r);

            System.out.println(sum);
        }
    }

    public static int queryRangeSumOptimal(int[] p, int l, int r, int k){

        int x = p[r] - (l == 0 ? 0 : p[l - 1]);

        int pow = 1;

        for(int i = 0; i < l; i++){
            pow *= k;
        }

        return (x / pow);
    }

    public static int queryRangeSumOptimal2(int[] p1, int[] p2, int l, int r){
        int x = p1[r] - (l == 0 ? 0 : p1[l - 1]);

        int pow = p2[l];

        return (x / pow);
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};

        int k = 2;

        int[][] q = { {0, 2}, {1, 3}, {2, 4} };

        // f_brute(arr, q, k);

        f_optimal(arr, q, k);
    }
}