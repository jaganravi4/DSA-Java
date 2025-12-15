/**
 *  Q: Given a number n, reverse the number and store the reversed number in new int variable
 *  and print the variable.
 *  eg: n = 1234 -> 4321
 *      n = 15200 -> 251
 */

public class Problem11{

    public static int reverse(int n){
        int rev = 0;

        while(n > 0){
            int rem = n % 10;
            rev = (rev * 10) + rem;
            n = n / 10;
        }
        return rev;
    }

    public static int reverseRec(int n, int rev){
        if(n <= 0){
            return rev;
        }

        int rem = n % 10;
        rev = (rev * 10) + rem;
        return reverseRec((n / 10), rev);
    }

    public static void main(String[] args){
        int n = 1234;

        // int rev = reverse(n);

        int rev = reverseRec(n, 0);

        System.out.println(rev);
    }
}