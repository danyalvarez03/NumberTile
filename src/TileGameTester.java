/*
 * File: NumberTile.java
 * 
 * Programmer: Daniel A. Alvarez
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/** A test class for the NumberTile Game
 */
public class TileGameTester
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Boolean seeGame = true;   // represents if the user wants to see a game
      
      // create a new file to store the output
      File outputFile = new File ("output.txt");
      
      // create a PrintWriter object
      PrintWriter outFile = new PrintWriter(outputFile);
      
      // the computewr plays until the user wants to stop
      while (seeGame)
      {
        // create a hand for each player
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        // create a tilegame using the created hands
        TileGame game1 = new TileGame(player1Hand, player2Hand);

        // print the initial hands
        System.out.println("Player 1 hand: " + player1Hand.toString());
        System.out.println("Player 2 hand: " + player2Hand.toString());
        outFile.println("Player 1 hand: " + player1Hand.toString());
        outFile.println("Player 2 hand: " + player2Hand.toString());

        // start the game
        game1.play();

        // print the results of the game
        System.out.println(game1.getResults());
        outFile.print(game1.getResults());

        // ask the user if they want to see another game
        String newGame = JOptionPane.showInputDialog("Do you want to "
                + "see another game?:  " + "(Yes to repeat and No to stop)");

        // if the user answers "no", stop the game
        if(newGame.equalsIgnoreCase("no"))
        {
            seeGame = false;   // set seeGame to false
        }    
      }
      
      // close the file
      outFile.close();
   }
} 