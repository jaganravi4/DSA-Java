/**
 *  Problem link -> https://leetcode.com/problems/maximum-number-of-removable-characters/description/
 */

import java.util.*;

public class Problem6{

    public static int f(String s, String p, int[] removable){

        int n = s.length();

        int m = p.length();

        int low = 1, high = removable.length;

        char[] brr = p.toCharArray();

        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isSubsequence(s, brr, mid, removable, n, m)){

                ans = mid;

                low = mid + 1;
            }else{

                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isSubsequence(String s, char[] brr, int k, int[] removable, int n, int m){

        char[] arr = s.toCharArray();

        for(int i = 0; i < k; i++){

            arr[removable[i]] = '*';
        }

        int i = 0, j = 0;

        while(i < n && j < m){

            if(arr[i] == brr[j]){

                j++;
            }

            i++;
        }

        return j == m;
    }

    public static void main(String[] args){

        String s = "abcbddcb";

        String p = "abcd";

        int[] removable = {3, 2, 1, 4, 5, 6};

        int res = f(s, p, removable);

        System.out.println(res);
    }
}