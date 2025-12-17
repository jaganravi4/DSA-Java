/**
 *  Q: Given a array of integers and return the sum of all subsets in the list.
 * 
 *  Problem link -> https://www.geeksforgeeks.org/problems/subset-sums2234/1
 */

import java.util.*;

public class Problem10{

    public static void f(int[] arr, int n, int idx, int sum, List<Integer> res){
        if(idx == n){
            res.add(sum);
            return;
        }

        sum += arr[idx];

        f(arr, n, idx + 1, sum, res);

        sum -= arr[idx];

        f(arr, n, idx + 1, sum, res);
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 1};

        int n = arr.length;

        List<Integer> res = new ArrayList<>();

        f(arr, n, 0, 0, res);

        System.out.println(res);
    }
}