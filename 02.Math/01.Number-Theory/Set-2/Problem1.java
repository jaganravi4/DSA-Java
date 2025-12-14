/**
 *  last bit -> every even number in binary is always zero. 
 *  eg: 8 -> 1000 -> 100[0]
 *      4 -> 100 -> 10[0] 
 * 
 *  last bit -> every odd number in binary is always one.
 *  eg: 5 -> 101 -> 10[1]
 *      3 -> 11 -> 1[1]
 * 
 *  we can write 2^n by writing a 1 followed by n zeros.
 *  eg: 2^2 -> 100 (4)
 *      2^3 -> 1000 (8)
 *      2^5 -> 100000(32)
 */


import java.util.*;

public class Problem1{

    
    /**
     *  for any even number, if we remove last bit
     *  we get -> (number / 2)
     *  eg: 8 -> 1000 -> 100
     *      6 -> 110 -> 11
     * 
     *  for any odd number, if we remove last bit
     *  we get integer part of (number / 2)
     *  eg: 9 -> 1001 -> 100 (4)
     *      7 -> 111 -> 11 (3)
     */
    public static int removeLastBit(int n){
        return n >> 1;
    }

    /**
     *  if we append zero at the last part the binary
     *  of any number, we get (number * 2)
     *  eg: 4 * 2 -> 100[4] -> 1000 [8]
     *      3 * 2 -> 11[3] -> 110 [6]
     */
    public static int appendLastBit(int n){
        return n << 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            // System.out.println(removeLastBit(n));

            System.out.println(appendLastBit(n));
        }

        sc.close();
    }
}