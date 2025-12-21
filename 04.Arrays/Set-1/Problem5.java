/**
 *  Problem link -> https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */

import java.util.*;
import java.lang.Math.*;

public class Problem5{

    /**
     *  Time: O(N)
     *  Space: O(N) -> using extra space [map -> array]
     */
    public static List<Integer> f_brute(int[] arr, int n){
        
        boolean[] map = new boolean[n + 1];

        for(int i = 0; i < n; i++){
            map[arr[i]] = true;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(!map[i]){
                res.add(i);
            }
        }

        return res;
    }

    /**
     *  Time: O(N)
     *  Space: O(1)
     */
    public static List<Integer> f_optimal(int[] arr, int n){

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            int x = Math.abs(arr[i]);

            // go to (x - 1) index and make it a negative value
            if(arr[x - 1] > 0){
                arr[x - 1] = arr[x - 1] * -1; 
            }
        }

        for(int i = 0; i < n; i++){
            
            if(arr[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};

        int n = arr.length;

        // List<Integer> res = f_brute(arr, n);

        List<Integer> res = f_optimal(arr, n);

        System.out.println(res);
    }
}