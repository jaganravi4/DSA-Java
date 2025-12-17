/**
 *  Q: count the subsets whose sum = k
 *  
 *  eg: arr = [1, 2, 3, 4] k = 6 -> output: 2 ([1, 2, 3], [2, 4])
 */

import java.util.*;

public class Problem9{

    public static int f(int[] arr, int n, int idx, int k, int sum){
        if(idx == n){

            if(sum == k){
                return 1;
            }
            return 0;
        }

        sum += arr[idx];

        int left = f(arr, n, idx + 1, k, sum);

        sum -= arr[idx];

        int right = f(arr, n, idx + 1, k, sum);

        return left + right;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};

        int n = arr.length;
        
        int k = 6;

        int res = f(arr, n, 0, k, 0);

        System.out.println(res);
    }
}