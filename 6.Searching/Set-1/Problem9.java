/**
 *  find the xth root of n.
 */

public class Problem9{

    public static int f(int n, int x){

        int low = 1, high = n;

        int res = 1;

        while(low <= high){

            int mid = (low + high) / 2;

            // int p = pow_brute(mid, x);

            int p = pow_optimal(mid, x);

            if(p <= n){

                res = mid;

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return res;
    }

    public static int pow_brute(int a, int b){

        int res = 1;

        for(int i = 1; i <= b; i++){

            res = res * a;
        }

        return res;
    }

    public static int pow_optimal(int a, int b){

        int res = 1;

        while(b > 0){

            if(b % 2 != 0){
                res = res * a;

                b = b - 1;
            }else{
                a = a * a;

                b = b >> 1;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int n = 50;

        int x = 4;

        int res = f(n, x);

        System.out.println(res);
    }
}