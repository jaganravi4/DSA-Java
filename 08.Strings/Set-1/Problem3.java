/**
 *  Problem link -> https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */

public class Problem3{

    public static int f(String s){

        int n = s.length();

        int[] map = new int[26];

        for(int i = 0; i < map.length; i++){

            map[i] = -1;
        }

        int res = -1;

        for(int i = 0; i < n; i++){

            int x = s.charAt(i) - 'a';

            if(map[x] == -1){

                map[x] = i;
            }else{

                int len = i - map[x] - 1;

                if(res < len){

                    res = len;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){

        String s = "abca";

        int res = f(s);

        System.out.println(res);
    }
}