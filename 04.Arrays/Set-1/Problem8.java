/**
 *  Problem link -> https://leetcode.com/problems/majority-element/description/
 */

import java.util.*;

public class Problem8{

    public static int f_brute(int[] arr, int n){
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > n / 2){
                return e.getKey();
            }
        }

        return -1;
    }

    public static int f_optimal(int[] arr, int n){
        int mElt = arr[0]; // Assume arr[0] as a majority element

        int count = 1;

        for(int i = 1; i < n; i++){
            if(count == 0){
                mElt = arr[i];
                count = 1;
            }else if(arr[i] == mElt){
                count++;
            }else{
                count--;
            }
        }

        count = 0;
        for(int i = 0; i < n; i++){
            if(mElt == arr[i]){
                count++;
            }
        }

        return count > (n / 2) ? mElt : -1;
    }

    public static void main(String[] args){
        int[] arr = {3, 2, 3};

        int n = arr.length;

        // int res = f_brute(arr, n);

        int res = f_optimal(arr, n);

        System.out.println(res);
    }
}