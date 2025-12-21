/**
 *  Q: Given an array, print all subarrays of the given array.
 *  
 *  Subarray -> it is a contiguous cross-section of array.
 * 
 *  eg: [1, 2, 3] -> [1] [1, 2] [1, 2, 3] [2] [2, 3] [3]
 */

import java.util.*;

public class Problem7{

    public static List<List<Integer>> f(int[] arr, int n){
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<Integer> sub = new ArrayList<>();

            for(int j = i; j < n; j++){
                sub.add(arr[j]);

                res.add(new ArrayList<>(sub));
            }
        }

        return res;
    }

    public static void f_rec(int[] arr, int idx, int n, List<List<Integer>> res){
        if(idx == n){
            return;
        }

        List<Integer> ds = new ArrayList<>();

        for(int i = idx; i < n; i++){
            ds.add(arr[i]);

            res.add(new ArrayList<>(ds));
        }

        f_rec(arr, idx + 1, n, res);
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3};

        int n = arr.length;

        // List<List<Integer>> res = f(arr, n);

        List<List<Integer>> res = new ArrayList<>();

        f_rec(arr, 0, n, res);

        System.out.println(res);
    }
}