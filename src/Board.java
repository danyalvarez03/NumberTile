/*
 * File: NumberTile.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/** The board for the NumberTile game
 * 
 */
public class Board
{
    private NumberTile [] board ;   // the board for the game
    private int boardSize ;         // current number of tiles on the board
    private static final int MAX_BOARD = 100 ;  // maximum number of tiles
    
    /** Creates a new Board that can hold up to MAX_BOARD tiles 
     *  that contains a single NumberTile
     */
    public Board()
    {
       // create a board with MAX_BOARD spaces
       board = new NumberTile[MAX_BOARD]; 
       NumberTile firstTile = new NumberTile(); // create initial NumberTile
       board[0] = firstTile;                    // add NumberTile to board
       boardSize = 1;                           // set the board size to 1
    }
    
     /** Return the NumberTile at the specified index on this Board
     * 
     * @param index position of the tile on the board
     * @return the tile stored at the specified index
     */
    public NumberTile getTile (int index)
    {
       return board[index];   
    }
    
    /** Return the current number of tiles on this Board
     * 
     * @return number of tiles in the game board
     */
    public int getSize()
    {
       return boardSize;
    }
    
    /** Insert a new tile into this Board at the specified index
     * 
     * @param index position where the tile will be added
     * @param tile the tile that will be added to the board
     */
    public void addTile(int index, NumberTile tile)
    {
       // traverse the array and move down every tile after 
       // the position where the new tile will be added
       for (int i = boardSize; i > index; i--)
       {
           board[i] = board[i - 1];  // each tile gets the position of the next
       }
       
       board[index] = tile;   // the new tile is added in the new space
       boardSize++;           // the size of the board increases by 1
    }
    
    /** Return a multiline string containing all the tiles on this Board
     * 
     * @return a multiline string with all the tiles in the board
     */
    public String toString()
    {
        // create an empty string to add the tiles in the board
        String currentBoard = "";
       
       // traverse the array and get each tile
       for (int i = 0; i < boardSize; i++) 
       {
            // take each tile and add them to the multiline string
           currentBoard = currentBoard + "\n" + board[i].toString();
       }
       
       return currentBoard;
    }           
}