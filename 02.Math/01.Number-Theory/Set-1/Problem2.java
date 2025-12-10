/**
 *  Q: Print sum of factors
 *  example: n = 20 => factors -> 1, 2, 4, 5, 10, 20 = 42
 *           n = 15 => factors -> 1, 3, 5, 15 = 24
 */

public class Problem2{

     /**
     *  Time: O(sqrt(n))
     *  Space: O(1)
     */
    public static void sumOfFactors(int n){
        int sum = 0;

        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                sum += i;

                if((n / i) != i){
                    sum += (n / i);
                }
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args){
        int n = 15;

        sumOfFactors(n);
    }
}