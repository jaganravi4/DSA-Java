/**
 *  Q: Given q queries and for each query given integer n where n is always prime number. how many number in the 
 *  range [1 to 10^6] have minimum prime factor as n
 * 
 *  for example: n = 2 -> (2, 4, 6, 8, 10, ... 10^6)
 *               n = 3 -> (3, 9, 15, ... 10^6)
 */

import java.util.*;

public class Problem6{

    private static int N = 20;
    private static int[] sieve = new int[N + 1];

    /**
     *  Time: O(N log(log N))
     *  Space: O(N)
     */
    private static void checkSieve(){
        for(int i = 2; i <= N; i++){
            sieve[i] = 1;
        }

        for(int i = 2; i <= N; i++){
            if(sieve[i] == 1){
                for(int j = i * i; j <= N; j += i){
                    if(sieve[j] != 0){
                        sieve[j] = 0;
                        sieve[i]++;
                    }
                }
            }
        }
    }

    public static void main(String[] args){

        // precomputation
        checkSieve();
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        // O(q)
        while(q-- > 0){
            int n = sc.nextInt();

            int res = ds[n];
            System.out.println(res);
        }

        System.out.println(Arrays.toString(sieve));
        sc.close();
    }
}