/**
 *  Q: Given a number n, return the sum of first n natural numbers.
 *  eg: n = 8 -> 36
 */

public class Problem6{

    /**
     *  Time: O(N)
     */
    public static void brute(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }

        System.out.println(sum);
    }

    /**
     *  Time: O(1)
     */
    public static void optimal(int n){

        int sum = (n * (n + 1)) / 2;
        
        System.out.println(sum);
    }

    public static void main(String[] args){

        int n = 20;

        // brute(n);

        optimal(n);
    }
}