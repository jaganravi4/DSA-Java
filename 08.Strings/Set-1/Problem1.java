/**
 *  Replace ASCII -> Given string s of length n and you have to replace each character if ith
 *  character is in even index then replace with next character and if it is in odd index then replace
 *  with previous character.
 * 
 *  eg: String s = "abcdef" -> "badcfe" 
 */

import java.util.*;

public class Problem1{

    public static String f(String s){

        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){

            char c = s.charAt(i);

            if(i % 2 == 0){

                c = (char) (c + 1);
            }else{

                c = (char) (c - 1);
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args){

        String s = "abcdef";

        String res = f(s);

        System.out.println(res);
    }
}