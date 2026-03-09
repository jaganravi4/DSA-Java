/**
 *  Print nth fibonacci number
 */

public class Problem1{

    public static int f(int n){

        if(n == 1){
            return 0;
        }

        if(n == 2){
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }

    public static int f_optimal(int n, int i, int prev, int curr){

        if(n == 1){
            return prev;
        }

        if(n == 2){
            return curr;
        }

        if(i == n){
            return curr;
        }

        int temp = prev + curr;

        prev = curr;

        curr = temp;

        return f_optimal(n, i + 1, prev, curr);
    }

    public static void main(String[] args){

        int n = 5;

        // int res = f(n);

        int res = f_optimal(n, 2, 0, 1);

        System.out.println(res);
    }
}