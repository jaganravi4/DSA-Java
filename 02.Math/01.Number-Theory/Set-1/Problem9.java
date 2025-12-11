/**
 *  Given t -> testcases and for each testcase, given 2 integers [l, r]
 *  Print all the primes from the range of [l, r]
 *  for example: 
 *      l = 1, r = 10 -> 2, 3, 5, 7
 *      l = 110, r = 130 -> 113, 127
 */

import java.util.*;
public class Problem9{
    
    private static int N = 1000000;
    private static boolean[] sieve = new boolean[N + 1];

    private static void createSieve(){
        for(int i = 2; i <= N; i++){
            sieve[i] = true;
        }

        for(int i = 2; i * i <= N; i++){
            if(sieve[i] == true){
                for(int j = i * i; j <= N; j+= i){
                    sieve[j] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        createSieve();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();

            for(int i = l; i <= r; i++){
                if(sieve[i] == true){
                    System.out.print(i + " ");
                }
            }

            System.out.print("\n");
        }

        sc.close();
    }
}