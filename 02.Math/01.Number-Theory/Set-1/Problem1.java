/**
 *  Q: Check if n is prime or not?
 *  example: n = 4 -> not a prime
 *           n = 7 -> prime
 */

public class Problem1{

    /**
     *  Time: O(n)
     *  Space: O(1)
     */
    public static void isPrimeBrute(int n){
        int count = 0;

        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                count++;
            }
        }

        if(count == 2){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    /**
     *  Time: O(sqrt(n))
     *  Space: O(1)
     */
    public static void isPrimeOptimal(int n){
        int count = 0;

        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                count++;

                // imp!
                if((n / i) != i){
                    count++;
                }
            }
        }
        if(count == 2){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void main(String[] args){
        int n = 11;

        // isPrimeBrute(n);

        isPrimeOptimal(n);
    }
}