/**
 *  Q: max frequency character
 * 
 *  Given a input string. find out and print the maximum frequency character.
 *  
 *  eg: s = "aabccbddbbba" -> 'b' (output)
 */

public class Problem3{

    public static char f(String s){

        int n = s.length();

        int[] map = new int[26];

        int max = 0;

        char res = ' ';

        for(int i = 0; i < n; i++){

            int x = s.charAt(i) - 'a';

            map[x]++;

            if(map[x] > max){

                max = map[x];
            }
        }

        for(int i = 0; i < map.length; i++){

            if(map[i] == max){

                res = (char) ('a' + i);
            }
        }

        return res;
    }

    public static void main(String[] args){

        String s = "aabccbddbbba";

        char res = f(s);

        System.out.println(res);
    }
}