/**
 *  Q: Given two numbers a and b, find the greatest common divisor of a and b.
 *  eg: a = 28, b = 24 => 4
 *      28 -> 2, [4], 7, 14, 28
 *      24 -> 2, 3, [4], 6, 8, 12, 24
 */


public class Problem14{


    public static int gcdBrute(int a, int b){
        if(a < b){
            return gcdBrute(b, a);
        }

        int ans = 1; // minimum potential ans

        for(int i = 2; i <= a; i++){
            if(a % i == 0 && b % i == 0){
                ans = i;
            }
        }

        return ans;
    }

    public static int gcdOptimal(int a, int b){
        if(a < b){
            return gcdOptimal(b, a);
        }   

        if(a % b == 0){
            return b;
        }

        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int gcdOptimalRec(int a, int b){
        if(a < b){
            return gcdOptimalRec(b, a);
        }

        if(a % b == 0){
            return b;
        }

        return gcdOptimalRec(b, a % b);
    }

    public static void main(String[] args){
        int a = 28, b = 24;

        // int res = gcdBrute(a, b);

        // int res = gcdOptimal(a, b);

        int res = gcdOptimalRec(a, b);

        System.out.println(res);
    }
}