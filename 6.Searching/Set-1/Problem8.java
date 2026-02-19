/**
 *  find the integer cube root of n.
 */

public class Problem8{

    public static int f(int n){

        int low = 1, high = n;

        int res = 1;

        while(low <= high){
            
            int mid = (low + high) / 2;

            int x = mid * mid * mid;

            if(x <= n){

                res = mid;

                low = mid + 1;
            }else{

                high = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int n = 30;

        int res = f(n);

        System.out.println(res);
    }
}