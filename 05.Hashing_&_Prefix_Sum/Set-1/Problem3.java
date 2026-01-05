/**
 *  Given a fixed array A of size N.
 *  you need to answer Q queries of the form:
 *  ?LR -> find the value of the following expression
 *      
 *      A[L] + A[L + 1] * 2 + A[L + 2] * 3 + ... + A[R] * (R - L - 1)
 */

import java.util.*;

public class Problem3{

    public static void f_brute(int[] arr, int[][] q){

        for(int[] range : q){
            int l = range[0];

            int r = range[1];

            int sum = queryRangeSum(arr, l, r);

            System.out.println(sum);
        }
    }

    public static int queryRangeSum(int[] arr, int l, int r){

        int sum = 0;

        for(int i = l; i <= r; i++){

            sum = sum + (arr[i] * (i - l + 1));
        }

        return sum;
    }

    public static void f_optimal(int[] arr, int[][] q){
        int n = arr.length;

        int[] brr = new int[n];

        for(int i = 0; i < n; i++){
            brr[i] = (arr[i] * (i + 1));
        }

        // prefix sum arrays
        int[] p1 = new int[n];

        int[] p2 = new int[n];

        p1[0] = arr[0];

        p2[0] = brr[0];

        for(int i = 1; i < n; i++){

            p1[i] = p1[i - 1] + arr[i];

            p2[i] = p2[i - 1] + brr[i];
        }

        for(int[] range: q){
            int l = range[0];

            int r = range[1];

            int sum = queryRangeSumOptimal(p1, p2, l, r);

            System.out.println(sum);
        }
    }

    public static int queryRangeSumOptimal(int[] p1, int[] p2, int l, int r){

        int a = p1[r] - (l == 0 ? 0 : p1[l - 1]);

        int b = p2[r] - (l == 0 ? 0 : p2[l - 1]);

        return b - (l * a);
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};

        int[][] q = { {0, 2}, {1, 3}, {2, 4} };

        // f_brute(arr, q);

        f_optimal(arr, q);
    }
}