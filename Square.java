package labs.apcs_ch6_lab_2;

// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//          
// ****************************************************************

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Square
{

    int[][] square;
    int size;
    Scanner scan = new Scanner(System.in);

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    public Square(int size)
    {
        square = new int[size][size];
        this.size = size;
        readSquare();
    }

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += square[row][i];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumCol(int col)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += square[i][col];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag()
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += square[i][i];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag()
    {
        int sum = 0;
        for (int i = 1; i <= size; i++)
        {
            sum += square[size - i][size - i];
        }
        return sum;
    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean magic()
    {
        
        int[]sumMatrix = new int[2*size + 2]; //Number of sums to hold 2*length + diagonals (two of them)
        boolean magic = true;
        int tempSum = sumRow(0);
        
        //Add values to matrix.  
        //Add row sum
        for (int i = 0; i < size; i++){
            sumMatrix[i] = sumRow(i);
        }
        //Add column sum
        for (int i = 0; i < size; i++) {
            sumMatrix[i+ size] = sumCol(i);
        }
        
        //Add diagonals
        sumMatrix[sumMatrix.length-2] = sumMainDiag();  //second to last entry
        sumMatrix[sumMatrix.length -1] = sumOtherDiag();  //last entry 

        //loop through whole matrix and determine if sums match up.
        
        for (int value = 0; value < sumMatrix.length; value++)
        {
            
                if (sumMatrix[value] != tempSum) magic = false;
            
        }
        return magic;
    }

    //--------------------------------------
    //read info into the square from the standard input.
    //--------------------------------------
    public void readSquare()
    {
        for (int row = 0; row < square.length; row++)
         {
            for (int col = 0; col < square.length; col ++)
            {
                System.out.println("Enter value for cell:");
                square[row][col] = scan.nextInt();
          }
        }
        scan.close();
    }
    
    public static void readData() {
        
        
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "/magic.txt";
        System.out.println(fileName);
        
        File file = new File(fileName);
        
        try {
    
            Scanner sc = new Scanner(file);
    
            while (sc.hasNextLine()) {
                int i = sc.nextInt();
                System.out.println(i);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare()
    {
         for (int row = 0; row < square.length; row++)
         {
            for (int col = 0; col < square.length; col ++)
            {
                System.out.print(square[row][col] + "\t");
          }
          System.out.println();
        }
    }
    
    public String toString() {
        printSquare();
        String output; 
        
        if (magic()) output = "The above square is a magic square";
        else output = "The above square is not a magic square";
        
        return output;
    }

}
