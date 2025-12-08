public class Pattern8 {
    
    public static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {

                func(i, j, n);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
    /*
        * * * * * * * * * 
          * * * * * * *   
            * * * * *     
              * * *       
                *         
    */
    public static void func(int i, int j, int n) {
        if (i <= j && i + j <= 2 * n - 2) {
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
