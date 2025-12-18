/** 
 *  Q: Given a array and print a subset whose sum is divisible by k
 *  eg: arr = [4, 3, 2] k = 3
 *      output -> [4, 2] -> [4, 2], [3], [4, 3, 2] (print any one of them)
 */

import java.util.*;

public class Problem17{

    public static boolean f(int idx, int[] arr, int n, int k, int sum, List<Integer> ds){
        if(idx == n){
            if(sum % k == 0){
                return true;
            }
            return false;
        }

        // pick
        ds.add(arr[idx]);

        sum += arr[idx];

        if(f(idx + 1, arr, n, k, sum, ds) == true){
            return true;
        }

        // not pick
        sum -= ds.removeLast();

        if(f(idx + 1, arr, n, k, sum, ds) == true){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 4};

        int n = arr.length;

        int k = 3;

        List<Integer> ds = new ArrayList<>();

        boolean res = f(0, arr, n, k, 0, ds);

        System.out.println(ds);
    }
}