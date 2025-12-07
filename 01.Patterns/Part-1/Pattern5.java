public class Pattern5 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(func3(i, j, n) + " ");
            }
            System.out.print("\n");
        }
    }
    
    /*
        . . . . . * 
        . . . . * . 
        . . . * . . 
        . . * . . . 
        . * . . . . 
        * . . . . . 
    */
    public static char func1(int i, int j, int n) {
        // i + j = c, here n - 1 is c.
        if (i + j == n - 1) {
            return '*';
        }
        return '.';
    }

    /*
        * * * * * * 
        * * * * * . 
        * * * * . . 
        * * * . . . 
        * * . . . . 
        * . . . . . 
    */
    public static char func2(int i, int j, int n) {
        if (i + j <= n - 1) {
            return '*';
        }
        return '.';
    }

    /*
        . . . . . * 
        . . . . * * 
        . . . * * * 
        . . * * * * 
        . * * * * * 
        * * * * * *
    */
    public static char func3(int i, int j, int n) {
        if (i + j >= n - 1) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 6;

        print(n);
    }    
}
