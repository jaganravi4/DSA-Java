/**
 *  Pow(x, n) -> https://leetcode.com/problems/powx-n/description/
 */

public class Problem2{

    public static double f_brute(double x, int n, boolean isNegative, double res){

        if(n == 0){
            return isNegative ? (1 / res) : res;
        }

        res = res * x;

        return f_brute(x, n - 1, isNegative, res);
    }

    public static double f_optimal(double x, long n, boolean isNegative, double res){

        if(n == 0){

            return isNegative ? (1 / res) : res;
        }

        if(n % 2 != 0){

            res = res * x;

            return f_optimal(x, n - 1, isNegative, res);
        }

        x = x * x;

        return f_optimal(x, n >> 1, isNegative, res);
    }

    public static void main(String[] args){

        double x = 2.00000;

        int n = -2;

        long nn = n;

        boolean isNegative = nn < 0;

        if(nn < 0){

            nn = nn * -1;
        }

        // double res = f_brute(x, n, isNegative, 1.0);

        double res = f_optimal(x, nn, isNegative, 1.0);

        System.out.println(res);
    }
}