public class Pattern3 {

    
    public static void print(int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(func(i, j, r, c) + " ");
            }
            System.out.print("\n");
        }
    }

    /*
        . . . * . . 
        . . . * . .
        . . . * . .
        . . . * . .
        * * * * * *
        . . . * . .
    */
    public static char func(int i, int j, int r, int c) {
        if (i == 4 || j == 3) {
            return '*';
        }
        return '.';
    }

    public static void main(String[] args) {
        int row = 6;
        int col = 6;

        print(row, col);
    }
}
