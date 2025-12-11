/**
 *  Q: Print Prime factorization
 *  eg: n = 30 -> 2, 3, 5
 *      n = 48 -> 2, 2, 2, 2, 3
 *      n = 35 -> 5, 7
 */

public class Problem7{

    /**
     *  Time: O(n) if n is prime
     */
    private static void printPrimeBrute(int n){

        for(int i = 2; i <= n; i++){

            while(n % i == 0){
                System.out.print(i + " ");
                n = n / i;
            }
        }
    }


    /**
     *  Time: O(sqrt(n))
     */
    private static void printPrimeOptimal(int n){
        for(int i = 2; i * i <= n; i++){
            while(n % i == 0){
                System.out.print(i + " ");
                n = n / i;
            }
        }

        if(n > 1){
            System.out.print(n);
        }
    }

    public static void main(String[] args){
        int n = 48;

        printPrimeOptimal(n);
    }
}