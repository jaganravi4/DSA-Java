/**
 *  Q: Given an integer n, return the number of trailing zeros in n!
 *  eg: n = 3 -> 3 * 2 * 1 -> 6 -> 0 [ans]
 *      n = 5 -> 5 * 4 * 3 * 2 * 1 -> 120 -> 1 [ans]
 * 
 *  problem link -> https://leetcode.com/problems/factorial-trailing-zeroes/description/
 */

public class Problem12{

    public static int trailingZeros(int n){
        int result = 0;

        int num = n / 5;
        while(num > 0){
            result += num;
            num = num / 5;
        }
        return result;
    }

    public static void main(String[] args){
        int n = 25;

        int res = trailingZeros(n);
        System.out.println(res);
    }
}