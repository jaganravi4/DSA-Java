/**
 *  Problem link -> https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
 */

import java.util.*;

public class Problem8{

    public static List<Integer> f_brute(int[] arr, int k){

        int n = arr.length;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n - k + 1; i++){

            int x = 0;

            for(int j = i; j <= i + k - 1; j++){

                if(arr[j] < 0){

                    x = arr[j];

                    break;
                }
            }

            res.add(x);
        }

        return res;
    }

    public static void main(String[] args){

        int[] arr = {-8, 2, 3, -6, 10};

        int k = 2;

        List<Integer> res = f_brute(arr, k);

        System.out.println(res);
    }
}