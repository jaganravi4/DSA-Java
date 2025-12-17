/**
 *  Q: Print all the subsets whose sum = k [repetition allowed]
 * 
 *  eg: arr = [1, 2, 3] k = 4
 *      output -> [1, 1, 1, 1], [2, 2], [1, 1, 2], [1, 3]
 */

import java.util.*;

public class Problem11{

    public static void print(int[] arr, int n, int idx, int sum, int k, List<Integer> ds, List<List<Integer>> res){
        // base case
        if(sum == k){
            res.add(new ArrayList<>(ds));
            return;
        }

        if(sum > k || idx == n){
            return;
        }

        // pick
        ds.add(arr[idx]);

        sum += arr[idx];

        print(arr, n, idx, sum, k, ds, res);

        // not pick
        sum -= ds.removeLast();

        print(arr, n, idx + 1, sum, k, ds, res);
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3};

        int n = arr.length;

        int k = 4;

        List<Integer> ds = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        print(arr, n, 0, 0, k, ds, res);

        System.out.println(res);
    }
}