/**
 *  Q: count all the subsets whose sum = k [repetition allowed]
 * 
 *  eg: arr = [1, 2, 3] k = 4
 *      output -> 4 -> [1, 1, 1, 1], [2, 2], [1, 1, 2], [1, 3]
 */

import java.util.*;

public class Problem12{

    public static int print(int[] arr, int n, int idx, int sum, int k){

        if(sum == k){
            return 1;
        }

        if(sum > k || idx == n){
            return 0;
        }

        // pick
        sum += arr[idx];

        int left = print(arr, n, idx, sum, k);

        // not pick
        sum -= arr[idx];

        int right = print(arr, n, idx + 1, sum, k);

        return left + right;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3};

        int n = arr.length;

        int k = 4;

        int res = print(arr, n, 0, 0, k);

        System.out.println(res);
    }
}