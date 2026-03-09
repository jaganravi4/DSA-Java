/**
 *  https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 */

public class Problem10{

    public static int f_brute(String s, String p){

        int n = s.length();

        int m = p.length();

        if(n < m){
            return 0;
        }

        int[] m1 = new int[26];

        for(int i = 0; i < m; i++){

            m1[p.charAt(i) - 'a']++;
        }

        int count = 0;

        for(int i = 0; i < n - m + 1; i++){

            int[] m2 = new int[26];

            for(int j = i; j <= m + i - 1; j++){

                char c = s.charAt(j);

                m2[c - 'a']++;
            }

            boolean flag = true;

            for(int k = 0; k < m1.length; k++){

                if(m1[k] != m2[k]){
                    flag = false;

                    break;
                }
            }

            if(flag){

                count++;
            }
        }

        return count;
    }

    public static int f_optimal(String s, String p){

        int n = s.length();

        int m = p.length();

        if(n < m){
            return 0;
        }

        int[] m1 = new int[26];

        int[] m2 = new int[26];

        for(int i = 0; i < m; i++){

            m1[p.charAt(i) - 'a']++;

            m2[s.charAt(i) - 'a']++;
        }

        int count = 0;

        count = check(m1, m2);

        for(int i = m; i < n; i++){

            m2[s.charAt(i - m) - 'a']--;

            m2[s.charAt(i) - 'a']++;

            count += check(m1, m2);
        }

        return count;
    }

    public static int check(int[] m1, int[] m2){

        for(int i = 0; i < m1.length; i++){

            if(m1[i] != m2[i]){
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args){

        String s = "aabaabaa";

        String p = "aaba";

        // int res = f_brute(s, p);

        int res = f_optimal(s, p);

        System.out.println(res);
    }
}