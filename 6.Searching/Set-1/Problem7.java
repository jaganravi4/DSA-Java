/**
 *  Find the integer square root of n.
 *  eg: n = 26 -> output: 5
 */

public class Problem7{

    public static int f(int n){
        
        int low = 1, high = n;

        int res = 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(mid * mid <= n){

                res = mid;

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return res;
    }

    public static void main(String[] args){

        int n = 25;

        int res = f(n);

        System.out.println(res);
    }
}