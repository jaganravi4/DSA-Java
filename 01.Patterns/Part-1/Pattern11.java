public class Pattern11 {


    public static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                System.out.print(func2(i, j, n) + " ");
            }

            System.out.print("\n");
        }
    }

    /*
        * . . . . . . . * 
        . * . . . . . * . 
        . . * . . . * . . 
        . . . * . * . . . 
        . . . . * . . . . 
    */
    public static char func1(int i, int j, int n) {
        if (i == j || i + j == 2 * n - 2) {
            return '*';
        }
        return '.';
    }
    
    /*
        * . . . . . . . * 
        * * . . . . . * * 
        * * * . . . * * * 
        * * * * . * * * * 
        * * * * * * * * * 
    */
    public static char func2(int i, int j, int n) {
        if (i >= j || i + j >= 2 * n - 2) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}
