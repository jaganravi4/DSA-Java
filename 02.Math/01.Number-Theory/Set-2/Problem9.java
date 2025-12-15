/**
 *  Q: Given a number n, print the nth fibonacci numbers.
 *  eg: n = 4 -> 3 (0 1 1 2 3)
 */

public class Problem9{

    public static int fibRec(int n){
        if(n <= 1){
            return n;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fib(int n){
        if(n <= 1){
            return n;
        }

        int prev = 0;
        int curr = 1;
        
        for(int i = 2; i <= n; i++){
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    public static void main(String[] args){
        int n = 4;

        // int res = fibRec(n);

        int res = fib(n);
        
        System.out.println(res);
    }
}