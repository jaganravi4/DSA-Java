public class Pattern4 {
    
    public static void print(int n) {

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < n; j++) {

                func(i, j, n);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
    /*
        *         
        * *       
        * * *     
        * * * *   
        * * * * * 
        * * * *   
        * * *     
        * *       
        *    
    */
    public static void func(int i, int j, int n) {
        if (i >= j && i + j <= 2 * n - 2) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}
