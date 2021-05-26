/*
 * File: NumberTile.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/** Implements a domino-like game where two players, both of whom are
 * the computer, take turns inserting NumberTiles into a Board
 */
public class TileGame
{
   // instance vars
   private Board board ;     // the game board
   private Hand hand1 ;      // Player 1 hand
   private Hand hand2 ;      // Player 2 hand
   private String winner ;   // the winner - player1, player2, or a tie game
   
  
   /** Creates a new TileGame with two initial hands and a board
    * 
    * @param firstHand the hand that belongs to the player 1
    * @param secondHand the hand that belongs to the player 2
    */
   public TileGame(Hand firstHand, Hand secondHand)
   {
      hand1 = new Hand();       // create the hand of player 1
      hand2 = new Hand();       // create the hand of player 2
      firstHand = hand1;        // initiate the hand of player 1
      secondHand = hand2;       // initiate the hand of player 2
      board = new Board();      // create a new board
   }
   
    /** Players take turn moving until one or both hand are empty
    * 
    */
   public void play()
   {
      // play while players have tiles on their hands
      while (hand1.getSize() > 0 && hand2.getSize() > 0)
      {
         // each player makes a move
         makeMove(hand1);
         makeMove(hand2);
         
         // if both hands are empty declare a tie
         if(hand1.isEmpty() && hand2.isEmpty())  
         {
             winner = "It's a Tie!";    // set the winner to a tie
             break;
         }
         // if hand 1 is empty, player 1 wins
         else if(hand1.isEmpty())
         {
             winner = "Player 1 Wins!";  // set the winner to player 1
             break;
         }
         // if hand 2 is empty, player 2 wins
         else if(hand2.isEmpty())
         {
             winner = "Player 2 Wins!";  // set the winner to player 2
             break;
         }
      }

   }

  /** Calculates the index at which a new tile will be inserted into the board, 
    *  or returns -1 if the tile cannot be inserted.
    * 
    * @param tile the tile for which we want to find the fit index in the board
    * @return the index where the tile fits or -1 in case the tile does not fit
    */
   private int getIndexForFit(NumberTile tile)
   {
      // traverse the board to look where the tile fits
      for (int i = 0; i < board.getSize(); i++)
      {
        // store the tile at index i
        NumberTile currentTile = board.getTile(i);
        // store the number of rotations made to the tile
        int rotationCount = 0;
        
        // check if the tile fits at the beginning of the board
        if (board.getTile(0).getLeft() == tile.getRight())
        {
            return 0;
        }
        // check if the tile fits at the end of the board
        else if (board.getTile(board.getSize() - 1).getRight()
                == tile.getLeft())
        {
            return board.getSize();
        }
        // check if the tile fits between two tiles
        else if (currentTile.getLeft() == tile.getRight() && 
                    tile.getLeft() == tile.getRight())
        {
            return i;
        }
        // rotate the tile and check if it fits now
        else if (rotationCount < 3)
        {     
            tile.rotate();     // rotate the tile 90 degrees
            rotationCount++;   // increase the number of rotations by 1
        }
        
      }
      return -1 ;   // return -1 if the tile does't fit
   }

    /** Checks consecutive tiles in the hand 
    *  - by calling method getIndexForFit()
    *  - to see if one can be inserted into the board.
    * 
    * @param hand the hand from which we are taking the tile to move.
    */
   private void makeMove(Hand hand)
   {
      // traverse the hand and check if each tile fits in the board
      for (int i = 0; i < hand.getSize(); i++)
      {
          // store the index where the tile fits (-1 in case it doesn't)
          int tileIndex = getIndexForFit(hand.get(i));
          
          // if the index returned is different from -1,
          // add the tile to that index
          if(tileIndex != -1)
          {
              // take the tile that will be played
              NumberTile currentTile = hand.get(i); 
              // remove the tile that will be played from the hand
              hand.removeTile(i);
              // add the tile in the board, in the position where it fits
              board.addTile(tileIndex, currentTile);
          }
          // if none of the tiles fit, add a new tile to the hand
          else if (tileIndex == -1 &&
                  i == hand.getSize() - 1)
          {
              hand.addTile();  // add a new tile to the hand
          }
          
      }
   }
   
   /** Return results of the game as a humongous multi-line String containing
    *  the final board, both both player's final hands, and the winner
    * 
    * @return A multiline string containing the final boards, both player's
    * final hands and the winner
    */
   public String getResults()
   {
      // store the final boards, both player's final hands,
      // and the winner to a multiline string
      String results = "Final Board: \n" + board.toString() + 
              "\nPlayer 1 Final Hand: " + 
              hand1.toString() + "\nPlayer 2 Final Hand: " 
              + hand2.toString() + "\n" + winner;
              
      return results;     
   }
} // end of TileGame2 class