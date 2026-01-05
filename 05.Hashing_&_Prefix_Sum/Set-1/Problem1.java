/**
 *  find answers to Q queries on a static array of size N.
 *  find the sum of elements in the range L to R in the array?
 *  
 *  eg: arr = [1, 2, 3, 4, 5]
 *      Queries = [[0, 2], [1, 3], [2, 4]] -> [6, 9, 12]
 */

import java.util.*;

public class Problem1{

    /**
     *  Time: O(Q * N)
     */
    public static List<Integer> f_brute(int[] arr, int n, int[][] queries){
        
        List<Integer> res = new ArrayList<>();

        for(int[] range : queries){

            int l = range[0];

            int r = range[1];

            int sum = findSum(arr, l, r);

            res.add(sum);
        }

        return res;
    }

    public static int findSum(int[] arr, int left, int right){

        int sum = 0;

        for(int i = left; i <= right; i++){
            sum += arr[i];
        }

        return sum;
    }

    /**
     *  Time: O(N + Q)
     */
    public static List<Integer> f_optimal(int[] arr, int n, int[][] queries){

        int[] p = new int[n];

        int sum = 0;

        for(int i = 0; i < n; i++){

            sum += arr[i];

            p[i] = sum;
        }

        List<Integer> res = new ArrayList<>();

        for(int[] range: queries){

            int left = range[0];

            int right = range[1];

            int rangeSum = queryRangeSum(p, left, right);

            res.add(rangeSum);
        }

        return res;
    }

    public static int queryRangeSum(int[] p, int l, int r){

        // edge case
        if(l == 0){
            return p[r];
        }

        return p[r] - p[l - 1];
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};

        int n = arr.length;

        int[][] queries = { {0, 2}, {1, 3}, {2, 4} };

        // List<Integer> res = f_brute(arr, n, queries);

        List<Integer> res = f_optimal(arr, n, queries);

        System.out.println(res);
    }
}