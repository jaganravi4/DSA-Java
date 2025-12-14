/**
 *  Q: Given a number x, check if the number is even or odd?
 *  eg: x = 20 -> even
 *      x = 5 -> odd
 */

import java.util.*;

public class Problem3{

    // check by using modulo operator
    public static void checkByModulo(int x){
        if(x % 2 == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }

    // check by using last bit
    public static void checkByLastBit(int x){
        if((x & 1) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }

    public static void main(String[] args){
        int x = 15;

        // checkByModulo(x);

        checkByLastBit(x);
    }
}