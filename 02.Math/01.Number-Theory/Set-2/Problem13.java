// Problem link -> https://leetcode.com/problems/ugly-number/description/

import java.util.*;

public class Problem13{

    public static int repeatedDivision(int n, int factor){
        while(n > 1 && (n % factor) == 0){
            n = n / factor;
        }
        return n;
    }

    public static boolean isUglyBrute(int n){
        int result = repeatedDivision(n , 2);

        result = repeatedDivision(result , 3);

        result = repeatedDivision(result , 5);
        
        return result == 1;
    }
    

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isUglyBrute(n));

        sc.close();
    }
}