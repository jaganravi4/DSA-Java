/**
 *  Q: Given 3 numbers a,b,c and check if we can form a triangle 
 *  using the side length as a, b, c
 *  eg: a = 7, b = 10, c = 5 -> true
 *      a = 1, b = 10, c = 12 -> false
 */

import java.util.*;

public class Problem4{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a + b > c && b + c > a && a + c > b){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        sc.close();
    }
}