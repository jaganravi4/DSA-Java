/**
 *  Q: Print subsets whose sum = k
 *  eg : arr = [1, 2, 3, 4] k = 5
 *      -> [1, 4], [2, 3] 
 */

import java.util.*;

public class Problem8{

    public static void print(int[] arr, int n, int idx, int k, int sum, List<Integer> ds, List<List<Integer>> res){
        if(idx == n){

            if(sum == k){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        ds.add(arr[idx]);

        sum += arr[idx];

        print(arr, n, idx + 1, k, sum, ds, res);

        sum -= ds.removeLast();

        print(arr, n, idx + 1, k, sum, ds, res);
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};

        int n = arr.length;
        
        int k = 6;

        List<Integer> ds = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        print(arr, n, 0, k, 0, ds, res);

        System.out.println(res);
    }
}