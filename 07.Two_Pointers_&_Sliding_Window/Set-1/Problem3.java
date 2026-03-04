/**
 *  Problem link -> https://leetcode.com/problems/valid-palindrome/description/
 */

import java.util.*;

public class Problem3{

    public static boolean f(String s){

        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){

            char c = s.charAt(i);

            if(isAlphanumeric(c)){

                if(isUppercase(c)){
                    c = (char) (c + 32);
                }

                sb.append(c);
            }
        }

        int i = 0, j = sb.length() - 1;

        while(i < j){

            char x = sb.charAt(i);

            char y = sb.charAt(j);

            if(x != y){
                return false;
            }

            i++;

            j--;
        }

        return true;
    }

    public static boolean isAlphanumeric(char c){

        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static boolean isUppercase(char c){
        return c >= 'A' && c <= 'Z';
    }

    public static boolean f_optimal(String s){

        int n = s.length();

        int i = 0, j = n - 1;

        while(i < j){

            char x = s.charAt(i);

            char y = s.charAt(j);

            if(!isAlphanumeric(x)){
                i++;

                continue;
            }

            if(!isAlphanumeric(y)){
                j--;

                continue;
            }

            if(isUppercase(x)){
                x = (char) (x + 32);
            }

            if(isUppercase(y)){
                y = (char) (y + 32);
            }

            if(x != y){
                return false;
            }

            i++;

            j--;
        }

        return true;
    }

    public static void main(String[] args){

        String s = "A man, a plan, a canal: Panama";

        // boolean res = f(s);

        boolean res = f_optimal(s);

        System.out.println(res);
    }
}