/**
 *  Problem link -> https://leetcode.com/problems/permutation-sequence/description/
 */

import java.util.*;

public class Problem4{

    public static void f_brute(StringBuilder sb, int n, int k, int idx, List<String> list){
        
        if(idx == n){
            
            list.add(sb.toString());

            return;
        }

        for(int i = idx; i < n; i++){

            swap(sb, i, idx);

            f_brute(sb, n, k, idx + 1, list);

            swap(sb, i, idx);
        }
    }

    public static void swap(StringBuilder sb, int i, int j){

        char temp = sb.charAt(i);

        sb.setCharAt(i, sb.charAt(j));

        sb.setCharAt(j, temp);
    }

    public static String f_optimal(StringBuilder sb, int n, int k){
        
        int fact = f_factorial(n);

        k = k - 1;

        StringBuilder res = new StringBuilder();

        while(true){

            int x = k / fact;

            res.append(sb.charAt(x));

            sb.deleteCharAt(x);

            if(sb.length() == 0){
                break;
            }

            k = k % fact;

            fact = fact / sb.length();
        }

        return res.toString();
    }

    public static int f_factorial(int n){

        int fact = 1;

        for(int i = 1; i < n; i++){

            fact *= i;
        }

        return fact;
    }

    public static void main(String[] args){

        int n = 4, k = 17;

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){

            sb.append(i);
        }

        // List<String> list = new ArrayList<>();

        // f_brute(sb, n, k, 0, list);

        // Collections.sort(list);

        // System.out.println(list.get(k - 1));

        String res = f_optimal(sb, n, k);

        System.out.println(res);
    }
}