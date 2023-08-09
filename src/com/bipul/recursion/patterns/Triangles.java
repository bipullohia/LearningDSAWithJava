package com.bipul.recursion.patterns;

public class Triangles {
    public static void main(String[] args) {
        int n = 5; //n is the number of rows in the triangle
//        triangle1(n,0);
        triangle2(n,0);
    }

    /* Implementation
        Assumptions:
        1. the value passed onto arg c will always be 0 when the func is called for the first time

        Params:
        row, col for rows and columns

        Return value:
        void
        Prints a pattern (for n=3):
        ***
        **
        *
    */
    private static void triangle1(int row, int col) {
        if(row==0) return;
        if(col<row){
            System.out.print("*");
            triangle1(row, col+1);
        }else{
            System.out.println();
            triangle1(row-1, 0);
        }
    }

    /* Implementation
    Assumptions:
    1. the value passed onto arg c will always be 0 when the func is called for the first time

    Params:
    row, col for rows and columns

    Return value:
    void
    Prints a pattern (for n=3):
    *
    **
    ***
*/
    private static void triangle2(int row, int col) { // a bit diff to comprehend that func will run first, and while stacking out, printing will happen
        if(row==0) return;
        if(col<row){
            triangle2(row, col+1);
            System.out.print("*");
        }else{
            triangle2(row-1, 0);
            System.out.println();
        }
    }
}
