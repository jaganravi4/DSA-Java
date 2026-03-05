/**
 *  Problem link -> https://leetcode.com/problems/reverse-words-in-a-string/description/
 */

import java.util.*;

public class Problem4{

    public static String f(String s){

        int n = s.length();

        int left = -1, right = -1;

        for(int i = 0; i < n; i++){

            char c = s.charAt(i);

            if(c != ' '){

                left = i;

                break;
            }
        }

        for(int i = n - 1; i >= left; i--){

            char c = s.charAt(i);

            if(c != ' '){

                right = i;

                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        while(right >= left){

            char c = s.charAt(right);

            if(c != ' '){

                sb.append(c);

                flag = true;

            }else if(flag){

                sb.append(" ");

                flag = false;
            }

            right--;
        }

        int i = 0, j = 0;

        while(j < sb.length()){

            char c = sb.charAt(j);

            if(c == ' '){

                reverse(sb, i, j - 1);

                i = j + 1;
            }

            j++;
        }

        reverse(sb, i, j - 1);

        return sb.toString();
    }

    public static void reverse(StringBuilder sb, int start, int end){

        while(start < end){

            swap(sb, start, end);

            start++;

            end--;
        }
    }

    public static void swap(StringBuilder sb, int i, int j){

        char temp = sb.charAt(i);

        sb.setCharAt(i, sb.charAt(j));

        sb.setCharAt(j, temp);;
    }

    public static void main(String[] args){

        String s = "the sky is blue";

        String res = f(s);

        System.out.println(res);
    }
}