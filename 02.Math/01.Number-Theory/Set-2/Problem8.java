/**
 *  Q: Given a number n, calculate the sum of digits.
 *  eg: n = 1234 -> 10
 */

public class Problem8{

    public static void sumOfDigits(int n){
        int sum = 0;

        while(n > 0){
            int lastDigit = n % 10;
            sum += lastDigit;
            n = n / 10;
        }

        System.out.println(sum);
    }

    public static void sumOfDigitsRec(int n, int sum){
        if(n <= 0){
            System.out.println(sum);
            return;
        }

        int lastDigit = n % 10;
        sum += lastDigit;
        sumOfDigitsRec((n / 10), sum);
    }

    public static void main(String[] args){
        int n = 9876;

        // sumOfDigits(n);

        sumOfDigitsRec(n, 0);
    }
}