/**
 *  Q: Given an array and print subsequences.
 *  eg: arr = [1, 2, 3] -> [], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]
 */

import java.util.*;

public class Problem5{

    public static void print(int[] arr, int n, List<Integer> ds, int idx){
        if(idx == n){
            System.out.println(ds);
            return;
        }

        // pick
        ds.add(arr[idx]);

        print(arr, n, ds, idx + 1);

        // not pick
        ds.removeLast(); // ds.remove(ds.get(ds.size() - 1));

        print(arr, n, ds, idx + 1);
    }


    public static void main(String[] args){

        int[] arr = {1, 2, 3};

        int n = arr.length;

        List<Integer> ds = new ArrayList<>();

        print(arr, n, ds, 0);
    }
}