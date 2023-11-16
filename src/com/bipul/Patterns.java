package com.bipul;

public class Patterns {
    public static void main(String[] args) {
        printPattern8(4);
    }

    /*printing the pattern
    #
    # #
    # # #
    # # # #
    # # #
    # #
    #
     */
    static void printPattern1(int n){
        //this will print 2n-1 rows
        for(int row = 1; row < 2 * n; row++){
            int colLimit = row > n ? 2 * n - row: row;
            for(int col = 0; col < colLimit; col++){
                System.out.print("# ");
            }
            System.out.println();
         }

    }

    /*printing the pattern
        #
       # #
      # # #
     # # # #
    # # # # #
     # # # #
      # # #
       # #
        #
     */
    static void printPattern2(int n){
        //this will print 2n-1 rows
        for(int row = 1; row < 2 * n; row++){
            int spacesToPrint = row > n ? row-n : n-row;
            for(int spc=0; spc<spacesToPrint; spc++){
                System.out.print(" ");
            }
            int colLimit = row > n ? 2 * n - row: row;
            for(int col = 0; col < colLimit; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /*printing the pattern
        1
       212
      32123
     4321234
    543212345
     */
    static void printPattern3(int n){
        //this will print n rows and 2n-1 cols
        for(int row = 1; row <= n; row++){
            int spacesToPrint = n-row;
            for(int spc=0; spc<spacesToPrint; spc++){
                System.out.print(" ");
            }
            for(int col = row; col > 1; col--){
                System.out.print(col);
            }
            for(int col = 1; col <= row; col++){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    /*printing the pattern
    4
    4 3
    4 3 2
    4 3 2 1
    4 3 2
    4 3
    4
    */
    static void printPattern5(int n){
        //this will print 2n-1 rows upto n cols
        for(int row = 1; row <= 2*n-1; row++){
            int colsToPrint = row > n ? 2*n-row : row;
            for(int col=0; col<colsToPrint; col++){
                System.out.print(n-col);
            }
            System.out.println();
        }
    }

    /*printing the pattern
          4
        3 4
      2 3 4
    1 2 3 4
      2 3 4
        3 4
          4
    */
    static void printPattern6(int n){
        //this will print 2n-1 rows upto n cols
        for(int row = 1; row <= 2*n-1; row++){
            int spacesToPrint = row > n ? row-n: n-row;
            for(int spc = 0; spc<spacesToPrint; spc++){
                System.out.print("  ");
            }
            int startDigit = row > n ? (row+1)-n : n-(row-1);
            for(int col=startDigit; col<=n; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /*printing the pattern
        4 4 4 4 4
          3 3 3
            2

            2
          3 3 3
        4 4 4 4 4
    */
    static void printPattern7(int n){
        //this will print 2n-1 rows upto n cols
        for(int row = 1; row <= 2*n-1; row++){
            int spacesToPrint = row > n ? row-n: n-row;
            for(int spc = 0; spc<spacesToPrint; spc++){
                System.out.print("  ");
            }
            int startDigit = row > n ? (row+1)-n : n-(row-1);
            for(int col=startDigit; col<=n; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /*printing the pattern
    4 4 4 4 4 4 4
    4 3 3 3 3 3 4
    4 3 2 2 2 3 4
    4 3 2 1 2 3 4
    4 3 2 2 2 3 4
    4 3 3 3 3 3 4
    4 4 4 4 4 4 4
    */
    static void printPattern8(int n){
        //this will print 2n-1 rows upto n cols
        for(int row = 1; row <= 2*n-1; row++){
            //LEFT
            int colsToPrint = row > n ? 2*n-row : (row == n ? row-1 : row); //we print until 2 (not 1)
            for(int col=0; col<colsToPrint; col++){
                System.out.print(n-col + " ");
            }
            //MIDDLE
            int colsCount = row > n ? (2*row)-(2*n)-1 : (row == n ? 1 : (2*n)-(2*row)-1);
            int digitToPrint = row > n ? row-n+1 : (row==n ? 1: n+1-row);
            for(int spc = 0; spc<colsCount; spc++){
                System.out.print(digitToPrint + " ");
            }
            //RIGHT
            int startDigit = row > n ? (row+1)-n : (row == n ? n-(row-2) : n-(row-1)); //we print from 2 (not 1)
            for(int col=startDigit; col<=n; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        //the condition for the middle row (where row==n has been written distinctly in all the cases
        //there is a much better way to solve this ques/pattern
    }

}
