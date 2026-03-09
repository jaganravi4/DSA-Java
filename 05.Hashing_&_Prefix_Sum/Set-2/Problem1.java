/**
 *  Problem link -> https://leetcode.com/problems/product-of-array-except-self/description/
 */

import java.util.*;

public class Problem1{

    public static int[] f(int[] arr){

        int n = arr.length;

        int[] res = new int[n];

        int[] p = new int[n];

        p[0] = 1;

        for(int i = 1; i < n; i++){

            p[i] = p[i - 1] * arr[i - 1];
        }

        int[] s = new int[n];

        s[n - 1] = 1;

        for(int i = n - 2; i >= 0; i--){

            s[i] = s[i + 1] * arr[i + 1];
        }

        for(int i = 0; i < n; i++){

            int prod = p[i] * s[i];

            res[i] = prod;
        }

        return res;
    }

    public static int[] f_optimal(int[] arr){

        int n = arr.length;

        int[] res = new int[n];

        int[] p = new int[n];

        p[0] = 1;

        for(int i = 1; i < n; i++){

            p[i] = p[i - 1] * arr[i - 1];
        }

        int s = 1;

        res[n - 1] = 1;

        for(int i = n - 1; i >= 0; i--){

            res[i] = p[i] * s;

            s *= arr[i];
        }

        return res;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4};

        // int[] res = f(arr);

        int[] res = f_optimal(arr);

        System.out.println(Arrays.toString(res));
    }
}