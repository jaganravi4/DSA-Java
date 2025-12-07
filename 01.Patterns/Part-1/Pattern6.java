public class Pattern6 {


    public static void print(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(func2(i, j, n) + " ");
            }
            System.out.print("\n");
        }
    }

    /*
        . . * . . 
        . . * . . 
        * * * * * 
        . . * . . 
        . . * . . 
     */
    public static char func1(int i, int j, int n) {
        if (i == n / 2 || j == n / 2)
            return '*';
        return '.';
    }

    /*
        * . . . * 
        . * . * . 
        . . * . . 
        . * . * . 
        * . . . *
    */
    public static char func2(int i, int j, int n) {
        if (i == j || i + j == n - 1) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }  
}
