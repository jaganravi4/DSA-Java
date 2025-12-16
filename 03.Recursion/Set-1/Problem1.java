/**
 *  Q: Given a number n, return the factorial of n
 *  eg: n = 5 -> 5 * 4 * 3 * 2 * 1 -> 120
 */

public class Problem1{

    public static void factorial(int n){
        int fact = 1;

        for(int i = 1; i <= n; i++){
            fact *= i;
        }
        
        System.out.println(fact);
    }

    /**
     *  Time: O(N)
     *  Space: O(N) -> stack space
     */
    public static void factorialRec(int n, int fact){
        // base case 
        if(n == 0){
            System.out.println(fact);
            return;
        }

        factorialRec(n - 1, fact * n);
    }

    public static void main(String[] args){
        int n = 5;

        // factorial(n);

        factorialRec(n, 1);
    }
}