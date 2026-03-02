/**
 *  Problem statement :
 *      You are given an array trees representing the heights of various trees, and an integer m representing the exact amount of wood you need. 
 *      You set your saw blade to a height h, and all parts of the trees higher than h are cut off and collected. 
 *      Find the maximum integer height h you can set the saw blade to such that you collect at least m units of wood.
 * 
 *      for eg : trees = {20, 15, 10, 17}, m = 7 -> 15 (output)
 */

public class Problem13{

    public static long f(int[] trees, int m){

        int n = trees.length;

        long high = 0;

        for(int i = 0; i < n; i++){

            high = Math.max(high, trees[i]);
        }

        long low = 0;

        long ans = 0;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(trees, mid, m, n)){
                ans = mid;

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] trees, long minHeight, int m, int n){

        long res = 0;

        for(int i = 0; i < n; i++){

            if(trees[i] >= minHeight){

                res += (trees[i] - minHeight);
            }

            if(res >= m){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        int[] trees = {4, 42, 40, 26, 46};

        int m = 20;

        long res = f(trees, m);

        System.out.println(res);
    }
}