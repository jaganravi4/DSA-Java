/**
 *  Given an array of size N. initially of all 0's.
 * 
 *  There are Q queries of the form:
 *  + LRX -> Add x to all the index in the range L to R.
 * 
 *  After all the queries you need to find the final array.
 * 
 *  eg: arr = [0, 0, 0, 0, 0] n = 5;
 * 
 *      Q = [[0, 2, 1], [1, 3, 2], [2, 4, 5]] -> [1, 3, 8, 7, 5] (output)
 */

public class Problem2{

    public static void f_brute(int[] arr, int[][] queries){

        for(int[] range: queries){

            int left = range[0];

            int right = range[1];

            int x = range[2];

            f_add(arr, left, right, x);
        }
    }

    public static void f_add(int[] arr, int l, int r, int x){

        for(int i = l; i <= r; i++){
            arr[i] += x;
        }
    }

    public static void f_optimal(int[] arr, int[][] queries, int n){

        for(int[] range: queries){
            int left = range[0];

            int right = range[1];

            int x = range[2];

            f_optimal_add(arr, left, right, x, n);
        }

        for(int i = 1; i < n; i++){
            arr[i] = arr[i] + arr[i - 1];
        }
    }

    public static void f_optimal_add(int[] arr, int l, int r, int x, int n){
        
        // edge case
        if(r != n - 1){
            arr[r + 1] = -1 * x;
        }

        arr[l] = x;
    }

    public static void print(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int n = 5;

        int[] arr = new int[n];

        int[][] queries = { {0, 2, 1}, {1, 3, 2}, {2, 4, 5} };

        // f_brute(arr, queries);

        f_optimal(arr, queries, n);

        print(arr);
    }
}