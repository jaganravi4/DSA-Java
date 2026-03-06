/**
 *  Problem link -> https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
 */

import java.util.*;

public class Problem5{

    public static int f_brute(int m, int n, int k){

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= m; i++){

            for(int j = 1; j <= n; j++){

                list.add(i * j);
            }
        }

        Collections.sort(list);

        return list.get(k - 1);
    }

    public static int f_optimal(int m, int n, int k){

        int low = 1, high = m * n;

        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            int count = f_helper_optimal(mid, m, n);

            if(count >= k){

                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static int f_helper(int x, int m, int n){

        int res = 0;

        for(int i = 1; i <= m; i++){

            if(i > x){
                break;
            }

            for(int j = 1; j <= n; j++){

                if(i * j > x){
                    break;
                }

                if(i * j <= x){
                    res++;
                }
            }
        }

        return res;
    }

    public static int f_helper_optimal(int x, int m, int n){

        int res = 0;

        for(int i = 1; i <= m; i++){

            res += (Math.min(x / i, n));
        }

        return res;
    }

    public static void main(String[] args){

        int m = 3, n = 3, k = 6;

        // int res = f_brute(m, n, k);

        int res = f_optimal(m, n, k);

        System.out.println(res);
    }
}