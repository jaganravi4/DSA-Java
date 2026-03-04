/**
 *  Problem link -> https://leetcode.com/problems/boats-to-save-people/description/
 */

import java.util.*;

public class Problem4{

    /**
     *  Time: O(N * log N)
     *  Space: O(1)
     */
    public static int f(int[] people, int limit){

        int n = people.length;

        Arrays.sort(people);

        int res = 0;

        int i = 0, j = n - 1;

        while(i <= j){

            int sum = people[i] + people[j];

            if(sum <= limit){

                i += 1;
            }

            res += 1;

            j -= 1;
        }

        return res;
    }

    /**
     *  Time: O(N)
     *  Space: O(max(people))
     */
    public static int f_optimal(int[] people, int limit){
        int n = people.length;

        int max = 0;
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, people[i]);
        }

        int[] count = new int[max + 1];

        for(int i = 0; i < n; i++){

            count[people[i]]++;
        }

        int idx = 0, x = 1;

        while(idx < n){

            while(count[x] == 0){
                x++;
            }

            people[idx++] = x;

            count[x] -= 1;
        }

        int res = 0;

        int i = 0, j = n - 1;

        while(i <= j){

            int sum = people[i] + people[j];

            if(sum <= limit){

                i += 1;
            }

            res += 1;

            j -= 1;
        }

        return res;
    }

    public static void main(String[] args){

        int[] people = {3, 8, 7, 1, 4};

        int limit = 9;

        // int res = f(people, limit);

        int res = f_optimal(people, limit);

        System.out.println(res); 
    }
}