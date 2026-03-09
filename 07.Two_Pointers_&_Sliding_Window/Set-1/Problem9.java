/**
 *  https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
 */

import java.util.*;

public class Problem9{

    public static List<Integer> f_brute(int[] arr, int k){

        int n = arr.length;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n - k + 1; i++){

            Set<Integer> set = new HashSet<>();

            for(int j = i; j <= k + i - 1; j++){

                set.add(arr[j]);
            }

            res.add(set.size());
        }

        return res;
    }

    public static List<Integer> f_optimal(int[] arr, int k){

        int n = arr.length;

        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++){

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        res.add(map.size());

        for(int i = k; i < n; i++){

            int x = arr[i - k];

            if(map.get(x) == 1){
                
                map.remove(x);
            }else{

                map.put(x, map.get(x) - 1);
            }

            int y = arr[i];

            map.put(y, map.getOrDefault(y, 0) + 1);

            res.add(map.size());
        }

        return res;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 1, 3, 4, 2, 3};

        int k = 4;

        // List<Integer> res = f_brute(arr, k);

        List<Integer> res = f_optimal(arr, k);

        System.out.println(res);
    }
}