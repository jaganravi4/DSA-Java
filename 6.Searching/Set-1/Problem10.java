/**
 *  Binary Exponentiation -> a^b
 * 
 *  eg: a = 2, b = 5 -> 32
 */

public class Problem10{

    public static int f(int a, int b){

        if(b == 0){
            return 1;
        }

        int res = 1;

        while(b != 0){

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

        int a = 2;

        int b = 10;

        int res = f(a, b);

        System.out.println(res);
    }
}