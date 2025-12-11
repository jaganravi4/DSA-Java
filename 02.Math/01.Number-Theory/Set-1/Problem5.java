/**
 *  Q: Finding the kth prime
 */


import java.util.*;

public class Problem5{

    private static int N = 86028121; // (5 * 10 ^ 6) -> constraint
    private static boolean[] sieve = new boolean[N + 1];

    private static List<Integer> ds = new ArrayList<>(); // store all primes till N
    
    private static void checkSieve(){

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

        for(int i = 2; i <= N; i++){
            if(sieve[i] == true){
                ds.add(i);
            }
        }
    }

    public static void main(String[] args) {
        checkSieve(); // precompute

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while(q-- > 0){
            int k = sc.nextInt();

            System.out.println(ds.get(k - 1));
        }
        sc.close();
    }
}