/**
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

import java.util.*;

public class Problem6{

    public static int f(String s){

        int n = s.length();

        int longest = 0;

        for(int i = 0; i < n; i++){

            int[] map = new int[256];

            for(int j = i; j < n; j++){

                if(map[s.charAt(j)] != 0){
                    break;
                }

                longest = Math.max(longest, j - i + 1);

                map[s.charAt(j)]++;
            }
        }
        
        return longest;
    }

    public static int f_optimal(String s){

        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, longest = 0;

        while(j < n){

            char c = s.charAt(j);

            if(map.containsKey(c)){

                i = Math.max(i, map.get(c));
            }

            int len = j - i + 1;

            longest = Math.max(longest, len);

            map.put(c, j + 1);

            j++;
        }

        return longest;
    }

    public static void main(String[] args){

        String s = "aabaab!bb";

        // int res = f(s);

        int res = f_optimal(s);

        System.out.println(res);
    }
}