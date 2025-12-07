public class Pattern9 {

    public static void print(int n) {
        
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {

                System.out.print(func(i, j, n) + " ");
            }
            System.out.print("\n");
        }
    }

    /*  
        . . . . * . . . . 
        . . . * * * . . . 
        . . * * * * * . . 
        . * * * * * * * . 
        * * * * * * * * * 
        . * * * * * * * . 
        . . * * * * * . . 
        . . . * * * . . . 
        . . . . * . . . .      
    */
    public static char func(int i, int j, int n) {
        if (i + j >= n - 1 && i >= j - n + 1 && i <= j + n - 1 && i + j <= 3 * n - 3) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
    
}
