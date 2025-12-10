/**
 *  Sieve of Eratosthenes
 */

import java.util.*;

public class Problem4{
    static int N = 100000;
    static boolean[] sieve = new boolean[N + 1];

    public static void checkSieve(){
        for(int i = 2; i <= N; i++){
            sieve[i] = true;
        }

        for(int i = 2; i <= N; i++){
            if(sieve[i] == true){
                for(int j = 2 * i; j <= N; j += i){
                    sieve[j] = false;
                }
            }
        }
    }

    public static void checkSieveOptimal(){
        for(int i = 2; i <= N; i++){
            sieve[i] = true;
        }

        for(int i = 2; i * i <= N; i++){
            if(sieve[i] == true){
                for(int j = i * i; j <= N; j += i){
                    sieve[j] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        /**
         *  Time: O(N log(log N))   
         *  space: O(N)
         */
        checkSieveOptimal();

        int t = sc.nextInt();
        // O(T)
        while(t-- > 0){
            int n = sc.nextInt();

            if(sieve[n] == true){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }

        sc.close();
    }
}