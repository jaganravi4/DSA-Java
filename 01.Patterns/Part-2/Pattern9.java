public class Pattern9 {
    public static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                func(i, j, n);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
    /*
        * * * * 
        *     * 
        *     * 
        * * * *             
    */
    public static void func(int i, int j, int n) {
        if (i == 0 || j == 0 || j == n - 1 || i == n - 1) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 4;

        print(n);
    }
}
