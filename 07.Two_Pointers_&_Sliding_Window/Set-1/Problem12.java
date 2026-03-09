/**
 *  https://leetcode.com/problems/permutation-in-string/description/
 */

public class Problem12{

    public static boolean f(String s1, String s2){

        int n = s1.length();

        int m = s2.length();

        if(n > m){
            return false;
        }

        int[] m1 = new int[26];

        int[] m2 = new int[26];

        for(int i = 0; i < n; i++){

            m1[s1.charAt(i) - 'a']++;

            m2[s2.charAt(i) - 'a']++;
        }

        if(check(m1, m2)){
            return true;
        }

        for(int i = n; i < m; i++){

            m2[s2.charAt(i - n) - 'a']--;

            m2[s2.charAt(i) - 'a']++;

            if(check(m1, m2)){
                return true;
            }
        }

        return false;
    }

    public static boolean check(int[] m1, int[] m2){

        for(int i = 0; i < 26; i++){

            if(m1[i] != m2[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        String s1 = "ab";

        String s2 = "eidbaooo";

        boolean res = f(s1, s2);

        System.out.println(res);
    }
}