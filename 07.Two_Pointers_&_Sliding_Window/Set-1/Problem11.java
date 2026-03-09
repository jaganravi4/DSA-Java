/**
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */

import java.util.*;

public class Problem11{

    public static List<Integer> f_optimal(String s, String p){

        int n = s.length();

        int m = p.length();

        List<Integer> res = new ArrayList<>();

        if(n < m){
            return res;
        }

        int[] m1 = new int[26];

        int[] m2 = new int[26];

        for(int i = 0; i < m; i++){
            m1[p.charAt(i) - 'a']++;

            m2[s.charAt(i) - 'a']++;
        }

        if(check(m1, m2)){
            res.add(0);
        }

        for(int i = m; i < n; i++){

            m2[s.charAt(i - m) - 'a']--;

            m2[s.charAt(i) - 'a']++;

            if(check(m1, m2)){
                res.add(i - m + 1);
            }
        }

        return res;
    }

    public static boolean check(int[] m1, int[] m2){
        for(int i = 0; i < m1.length; i++){

            if(m1[i] != m2[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String s = "aabaabaa";

        String p = "aaba";

        List<Integer> res = f_optimal(s, p);

        System.out.println(res);
    }
}