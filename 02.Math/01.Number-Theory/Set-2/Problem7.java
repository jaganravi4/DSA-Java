/**
 *  Q: Given a number n, find the sum of all odd numbers in the range [1, n]
 *  eg: n = 8 -> 16
 */

public class Problem7{

    /**
     *  Time: O(N / 2)
     *  Space: O(1)
     */
    public static void brute(int n){
        int sum = 0;

        for(int i = 1; i <= n; i += 2){
            sum += i;
        }

        System.out.println(sum);
    }

    /**
     *  Time: O(1)
     */
    public static void optimal(int n){
        /**
         *  if n is even -> k = (n / 2)
         *  if n is odd -> k = ((n + 1) / 2)
         *      
         *  sum = k * k;
        */

        int k = 0;

        if(n % 2 == 0){
            k = n >> 1;
        }else{
            k = (n + 1) >> 1;
        }

        int sum = k * k;

        System.out.println(sum);
    }
    public static void main(String[] args){
        int n = 8;

        // brute(n);

        optimal(n);
    }
}