/**
 *  Q: Given a string s, check if it is palindrome or not by using recursion
 *  eg: s = "11011" -> true
 *      s = "10100" -> false
 */

public class Problem4{

    public static boolean isPalindromeRec(String s, int i, int j){
        if(i >= j){
            return true;
        }

        if(s.charAt(i) != s.charAt(j)){
            return false;
        }

        return isPalindromeRec(s, i + 1, j - 1);
    }

    public static void main(String[] args){
        String s = "11011";

        // String s = "100111";

        int n = s.length();

        boolean res = isPalindromeRec(s, 0, n - 1);

        System.out.println(res);
    }
}