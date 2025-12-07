public class Pattern7 {

    public static void print(int n) {
        for (int i = 0; i < n * 2 - 1; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {

                System.out.print(func(i, j, n) + " ");
            }
            System.out.print("\n");
        }
    }
    
    /*
        . . . . * . . . . 
        . . . * . * . . . 
        . . * . . . * . . 
        . * . . . . . * . 
        * . . . . . . . * 
        . * . . . . . * . 
        . . * . . . * . . 
        . . . * . * . . . 
        . . . . * . . . . 
    */
    public static char func(int i, int j, int n) {
        // top
        if (i + j == n - 1 || i == j + 1 - n) {
            return '*';
        }
        
        // bottom
        if ( i == j + n - 1 || i + j  == 3 * n - 3) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}   
