/**
 *  Q: Given n, you need to figure out 3 integers (a, b, c)
 *  condition -> a * b * c == n and all 3 integers should be distinct and should not be 1.
 *  constraint -> n <= 10 ^ 9
 */

public class Problem3{

    /**
     *  Time: O(sqrt(n))
     *  Space: O(1)
     */
    public static String func(int n){

        int a = -1;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                a = i;
                break;
            }
        }

        if(a == -1){
            return "No";
        }

        n = n / a;

        int b = -1;
        for(int i = a + 1; i * i <= n; i++){
            if(n % i == 0){
                b = i;
                break;
            }
        }

        if(b == -1){
            return "No";
        }

        int c = n / b;

        if(b != c){
            System.out.println(a + " " + b + " " + c);
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args){
        int n = 48;

        String res = func(n);
        System.out.println(res);
    }
}