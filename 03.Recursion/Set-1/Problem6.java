/**
 *  Q: Print the subsets whose sum is divisible by k
 *  eg: arr = [4, 3, 2] k = 3
 * 
 *      output: [3], [4, 2], [4, 3, 2]
 */

import java.util.*;

public class Problem6{

    public static void f(int[] arr, int n, int idx, int k, List<Integer> ds, List<List<Integer>> res, int sum){

        if(idx == n){
            if(sum != 0 && sum % k == 0){
                res.add(new ArrayList<>(ds)); 
            }
            return;
        }

        ds.add(arr[idx]);

        sum += arr[idx];

        f(arr, n, idx + 1, k, ds, res, sum);

        sum = sum - ds.removeLast();

        f(arr, n, idx + 1, k, ds, res, sum);
    }


    public static void main(String[] args){
        int[] arr = {4, 3, 2};

        int n = arr.length;

        int k = 3;

        List<Integer> ds = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        f(arr, n, 0, k, ds, res, 0);

        System.out.println(res);
    }
}