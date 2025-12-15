/**
 *  Q: Given a number n, print the first n fibonacci numbers.
 *  eg: n = 5 -> 0 1 1 2 3
 */

public class Problem10{

    public static void fib(int n){

        int prev = 0;
        int curr = 1;
        
        for(int i = 0; i < n; i++){
            System.out.print(prev + " ");

            int next = prev + curr;
            prev = curr;
            curr = next;
        }
    }

    public static void fibRec(int n, int prev, int curr, int idx){
        if(idx == n){
            return;
        }

        System.out.print(prev + " ");

        int next = prev + curr;
        fibRec(n, curr, next, idx + 1);
    }

    public static void main(String[] args){
        int n = 8;
        
        // fib(n);

        fibRec(n, 0, 1, 0);
    }
}