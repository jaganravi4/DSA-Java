/**
 *  Q: count the subsets whose sum is divisible by k
 *  eg: arr = [4, 3, 2] k = 3
 * 
 *          -> [3], [4, 2], [4, 3, 2]
 * 
 *      output: 3
 */

import java.util.*;

public class Problem7{

    public static int f(int[] arr, int n, int idx, int k, int sum){
        if(idx == n){
            if(sum != 0 && sum % k == 0){
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
        int[] arr = {4, 3, 2};

        int n = arr.length;

        int k = 3;

        int res = f(arr, n, 0, k, 0);

        System.out.println(res);
    }
}