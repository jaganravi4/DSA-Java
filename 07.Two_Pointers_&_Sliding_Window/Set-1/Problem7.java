/**
 *  Problem link -> https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */

public class Problem7{

    public static String f(String s){

        char[] arr = s.toCharArray();

        int n = arr.length;

        int left = 0, right = n - 1;

        while(left < right){

            if(!isVowel(arr[left])){

                left++;
            }

            if(!isVowel(arr[right])){

                right--;
            }

            if(isVowel(arr[left]) && isVowel(arr[right])){

                swap(arr, left, right);

                left++;

                right--;
            }
        }

        return new String(arr);
    }

    public static boolean isVowel(char c){

        return (c == 'a' || c == 'A') || (c == 'e' || c == 'E') || (c == 'i' || c == 'I') || (c == 'o' || c == 'O') || (c == 'u' || c == 'U');
    }

    public static void swap(char[] arr, int i, int j){

        char temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;
    }

    public static void main(String[] args){

        String s = "IceCreAm";

        String res = f(s);

        System.out.println(res);
    }
}