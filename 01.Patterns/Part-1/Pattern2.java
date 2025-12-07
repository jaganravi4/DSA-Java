
public class Pattern2 {

    public static void print(int row, int col) {

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                System.out.print(func(i, j, row, col) + " ");
            }

            System.out.print("\n");
        }
    }
    
    /*
        * * * * * * 
        * * * * * *
        * * * * * * 
        . . . . . .
        . . . . . .
        . . . . . .
    */
    public static char func(int i, int j, int r, int c) {
        if(i < r / 2){
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
