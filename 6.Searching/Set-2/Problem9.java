/**
 *  https://leetcode.com/problems/koko-eating-bananas/description/
 */

public class Problem9{

    public static int f(int[] piles, int h){

        int n = piles.length;

        int low = 1;

        int high = 0;

        for(int pile : piles){

            high = Math.max(high, pile);
        }

        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(piles, mid, h)){
                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] piles, int speed, int h){

        long count = 0;

        for(int i = 0; i < piles.length; i++){

            int x = (piles[i] / speed);

            if(piles[i] % speed != 0){
                x += 1;
            }

            count += x;
        }

        return count <= h * 1L;
    }

    public static void main(String[] args){

        int[] piles = {3, 6, 7, 11};

        int h = 8;

        int res = f(piles, h);

        System.out.println(res);
    }
}