/**
 *  Q: Given q queries and for each query given integer n from 1 to 10^6. Print Prime factorization for n
 *  eg: q = 3
 *      n = 30 -> 2, 3, 5
 *      n = 48 -> 2, 2, 2, 2, 3
 *      n = 35 -> 5, 7
 */

import java.util.*;

public class Problem8{

    private static int N = 1000000;
    private static int[] spf = new int[N + 1];

    private static void createSieve(){
        for(int i = 2; i <= N; i++){
            spf[i] = i;
        }

        for(int i = 2; i * i <= N; i++){
            if(spf[i] == i){
                for(int j = i * i; j <= N; j+= i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        // O(N log(log N))
        createSieve();

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while(q-- > 0){
            int n = sc.nextInt();
            
            // O(log n)
            while(n >= 2){
                System.out.print(spf[n] + " ");
                n = n / spf[n];
            }
            System.out.print("\n");
        }
        sc.close();
    }
}