/**
 *  Problem link -> https://leetcode.com/problems/generate-parentheses/description/
 */

import java.util.*;

public class Problem3{

    public static void f(int i, int j, int n, StringBuilder sb, List<String> res){

        if(i == n && j == n){

            res.add(sb.toString());

            return;
        }
        
        if(i + 1 <= n){

            sb.append("(");

            f(i + 1, j, n, sb, res);

            sb.deleteCharAt(sb.length() - 1);
        }

        if(j + 1 <= n && j + 1 <= i){

            sb.append(")");

            f(i, j + 1, n, sb, res);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args){

        int n = 3;

        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        
        f(0, 0, n, sb, res);

        System.out.println(res);
    }
}