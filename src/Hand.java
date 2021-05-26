/*
 * File: NumberTile.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/**
 * A player's hand of NumberTiles
 */
public class Hand
{
    private NumberTile [] hand ;    // a player's hand of tiles
    private int handSize ;          // current number of tiles in the hand
    private static final int MAX_TILES = 50 ;    // maximum hand size
    private static final int INITIAL_SIZE = 5 ;  // starting hand size
    
    /** Creates a new hand containing INITIAL_SIZE NumberTiles, 
     *  but with a capacity of MAX_TILES
     */
    public Hand()
    {
       // creates a hand with a capacity of MAX_TILES NumberTiles
       hand = new NumberTile[MAX_TILES];
       handSize = 0;                     // set the size of the hand to 0
       
       // traverse the hand and add INITIAL_SIZE NumberTiles to it
       for (int i = 0; i < INITIAL_SIZE; i++)
       {
           NumberTile newTile = new NumberTile();  // create a new NumberTile
           hand[i] = newTile;                      // add the tile to the hand
           handSize++;                             // increase the counter by 1
       }
    }
       
    /** 
     * Get the NumberTile at the specified index in this Hand
     * 
     * @param index the position at which the tile is stored.
     * @return The tile placed at the given index.
     */
    public NumberTile get(int index)
    {
       return hand[index];
    }
    
    /**
     * Get the number of tiles in this Hand
     * 
     * @return Number of tiles in the hand
     */
    public int getSize()
    {
       return handSize;
    }
    
    /**
     * Add a new NumberTile to this Hand
     */
    public void addTile()
    {
       NumberTile newTile = new NumberTile();   // create a new NumberTile
       hand[handSize] = newTile;        // add the tile to the end of the hand
       handSize++;                      // increase the counter by 1
    }
    
    /**
     * Remove the NumberTile at the specified index from this Hand
     * 
     * @param index position at which the tile is stored
     */
    public void removeTile(int index)
    {
        // in case the tile to remove is the last in the hand
        if(index == handSize - 1)
        {
            hand[index] = null;    // remove the tile
            handSize--;            // decrease the counter of size by one
        }
        // in case the tile to remove is not the last in the hand
        else
        { 
            // traverse the list and move up every tile after
            // the one that is to be removed, taking up its place
            for (int i = index; i < handSize - 1; i++)
            {
                // every tile after the one that is removed
                // takes the position of the previous one
                hand[i] = hand[i + 1];
            }
            
            handSize--;    // decrease the counter of size by 1
        }        
    }
    
    /**
     * Check if this hand is empty
     * 
     * @return a boolean with the value true if the hand is empty and false
     * if the hand has tiles
     */
    public boolean isEmpty()
    {
       return handSize == 0;
       
    }
    
    /**
     * Return this Hand as a multiline String.
     * If this Hand is empty, return an appropriate message
     * 
     * @return a multiline string representing the hand
     * @return a message in case the hand is empty
     */
    public String toString()
    {
       if (!(handSize == 0))      // check the hand has tiles
       {
        // create an empty string to add the tiles in the hand
        String currentHand = "";  
        
        // traverse the hand to get each tile
        for (int i = 0; i < handSize; i++)
        {
                // take each tile and add it to the string
               currentHand = currentHand + "\n" + hand[i].toString();
        }
       
        return currentHand;    // return the string
       }
       // return a message saying that the hand is empty
       return "This hand is empty"; 
    }
}