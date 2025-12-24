/**
 *  Problem link -> https://leetcode.com/problems/intersection-of-two-arrays/
 */

import java.util.*;

public class Problem9{

    public static int[] f(int[] a, int[] b){
        int n = a.length, m = b.length;

        boolean[] map1 = new boolean[1001]; // 1 <= a[i], n[i] <= 1000

        for(int i = 0; i < n; i++){
            // mark
            map1[a[i]] = true;
        }

        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i < m; i++){

            if(map1[b[i]]){
                temp.add(b[i]);

                map1[b[i]] = false; // unmark
            }
        }

        int[] res = new int[temp.size()];

        for(int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }

        return res;
    }

    public static void main(String[] args){
        int[] a = {4, 9, 5};
        
        int[] b = {9, 4, 9, 8, 4};

        int[] res = f(a, b);

        System.out.println(Arrays.toString(res));
    }
}