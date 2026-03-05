/**
 *  Print All Substring
 */

import java.util.*;

public class Problem2{

    public static void f(String s){

        int n = s.length();

        for(int i = 0; i < n; i++){

            StringBuilder sb = new StringBuilder();

            for(int j = i; j < n; j++){

                char c = s.charAt(j);

                sb.append(c);

                System.out.println(sb);
            }
        }
    }

    public static void f_rec(String s, int idx, int n){

        if(idx == n){
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = idx; i < n; i++){

            char c = s.charAt(i);

            sb.append(c);

            System.out.println(sb);
        }

        f_rec(s, idx + 1, n);
    }

    public static void main(String[] args){

        String s = "code";

        // f(s);

        f_rec(s, 0, s.length());
    }
}