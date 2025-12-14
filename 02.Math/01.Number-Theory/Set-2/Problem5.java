/**
 *  Q: Given 3 numbers, calculate the minimum of 3 numbers.
 *  eg: a = 2, b = -3, c = 10 -> -3
 */

import java.util.*;

public class Problem5{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a < b && a < c){
            System.out.println(a);
        }else if(b < a && b < c){
            System.out.println(b);
        }else{
            System.out.println(c);
        }
    }
}