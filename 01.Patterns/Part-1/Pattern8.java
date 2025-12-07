public class Pattern8 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ((n / 2) + 1); j++) {

                System.out.print(func(i, j, n) + " ");
            }
            System.out.print("\n");
        }
    }

    /*
        . . * 
        . * * 
        * * * 
        . * * 
        . . *
    */
    public static char func(int i, int j, int n) {
        if (i + j >= n / 2 && i <= j + n / 2) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}
