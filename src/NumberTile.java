/*
 * File: NumberTile.java
 * 
 * Programmer: Daniel A. Alvarez
 */

import java.util.Random;

/** 
 * A NumberTile is a square tile with a number from 1 to 9 on each side
 */
public class NumberTile 
{
    private int [] tile ;    // the 4-sided tile
            
    /**
     * Create a NumberTile object with 4 random ints in the range 1 to 9
     */
    public NumberTile() 
    {
        tile = new int [4];           // initiate the tile to have 4 sides
        Random gen = new Random() ;   // create a random number generator
        
        // populate the tile with 4 random numbers
        for (int i = 0; i < tile.length; i++)
        {
            tile[i] = gen.nextInt(9) + 1;  // add a random number from 1 to 9
        }
    }
    
    /** 
     * Rotate this NumberTile 90 degrees
     */
    public void rotate() 
    {
       // store the number on the bottom of the tile
       int currentNumber = tile[3];
       tile[3] = 0;             // remove the tile in the bottom to make space
       
       // traverse the array and move down each number in the tile
       for (int i = 3; i > 0; i--)
       {
           // each number takes the position of the next
           tile[i] = tile[i - 1];
       }
       
       // add the tile that was in the bottom to the 
       // left side of the tile (beginning of the array)
       tile[0] = currentNumber; 
    }
    
    /**
     * Return the number on the left side of this NumberTile
     * 
     * @return The number on the left side of the tile (index 0).
     */
    public int getLeft()
    {
        return tile[0] ;
    }
    
    /**
     * Return the number on the right side of this NumberTile
     * 
     * @return The number on the right side of the tile (index 2).
     */
    public int getRight() 
    {
        return tile[2] ;
    }
    
    /** Return this NumberTile as a multiline string in the form:
     *     9
     *  3     7
     *     6
     * 
     * @return A string that represents the tile.
     */
    public String toString() 
    {
       // create the string and store it in the variable currentTile
       String currentTile = "   " + tile[1] + "\n" + tile[0] + 
               "     " +tile[2] + "\n" + "   " + tile[3];
       return currentTile ;
    }    
} // end of NumberTile class