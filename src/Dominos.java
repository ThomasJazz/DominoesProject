package dominosprojectcs380;

/**
 * DOMINOES RULES THAT OUR CODE FOLLOWS
 * Game starts by having players draw 10 dominoes each.
 * 1st round: Player 0 places a domino on the board
 * 2nd+ round: Players alternate placing dominoes on each end of the domino line.
 * If a player CANNOT play with the dominoes in their hand, they keep drawing
 * until they CAN play or until there are 2 dominoes left in the boneyard
 * Winning: The game is over if either: a player has played all their dominoes or
 * the boneyard is empty and neither player is able to play
 */
public class Dominos
{
   private JDomino dominoOBJ;
   private JPlayer[] playerOBJ;
   private JTable myTableOBJ;
   private String sideToAddTo;

   public static void main(String[] args)
   {
      // best to leave main method according to my old DS teacher
      new Dominos().play();
   }

   public void play()
   {
      boolean winner = false;
      int pieceID;

      dominoOBJ = new JDomino();
      dominoOBJ.API();

      playerOBJ = new JPlayer[2];
      playerOBJ[0] = new JPlayer();
      playerOBJ[1] = new JPlayer();

      playerOBJ[0].API(dominoOBJ);
      playerOBJ[1].API(dominoOBJ);

      myTableOBJ = new JTable(dominoOBJ);
      myTableOBJ.API(playerOBJ);

      // ************ FOR TESTING ************
      System.out.println("****************************");
      System.out.println("Player 1: " + playerOBJ[0].getHand());
      System.out.println("Player 2: " + playerOBJ[1].getHand());

      System.out.println("Full List:" + dominoOBJ);
      System.out.println("\n");
      // ************ FOR TESTING ************

      /*
       * for testing
       * playerOBJ[0].draw(0);
       * System.out.println("New hand after drawing: \n" + playerOBJ[0].getHand());
       */
      // now we actually start taking turns.
      // real dominoes would have the player with the highest domino go first, but we just
      //start with player[0]
      //myTableOBJ.
      JRandom rand = new JRandom();
      int start = rand.getRandom(0, 1); // randomly decide who starts first

      for (int i = start; !winner; i++)
      {
         // Formatting for printing, so each turn is distinguishable.
         System.out.println("************************************************************************************");

         // use mod 2 to toggle player turn
         int playerTurn = i % 2;

         // if the player has a domino they can play, they play it.
         if (canPlay(playerOBJ[playerTurn]) != -1)
         {
            // Place the domino onto the table.
            placeDomino(playerTurn);
         }

         else
         {
            // player draws until they can play a domino or until boneyard is empty
            while (canPlay(playerOBJ[playerTurn]) == -1 && !myTableOBJ.boneyard.isEmpty())
            {
               playerOBJ[playerTurn].draw(playerTurn);
            }

            // if neither player can play and the boneyard is empty, the game is over
            if (myTableOBJ.boneyard.isEmpty() && canPlay(playerOBJ[0]) == -1 && canPlay(playerOBJ[1]) == -1)
            {
               winner = true;
               System.out.println("\n------------------------------------------------------------------------------------");
               System.out.println("---------------------------------- FINAL RESULTS -----------------------------------");
               System.out.println("------------------------------------------------------------------------------------");
               System.out.println("Neither player can play and boneyard is empty!");
               System.out.println("Exiting game...");
            }

            // Check again if the player has a domino they can play, then play it.
            if (canPlay(playerOBJ[playerTurn]) != -1)
            {
               System.out.println();

               // Place the domino onto the table.
               placeDomino(playerTurn);
            }
         }

         // If one of the players no longer has any dominos in
         // hand, then they win. Game Over.
         if (playerOBJ[playerTurn].getHand().size() == 0)
         {
            winner = true;

            // Set the winning and losing player variables for simplicity.
            int winningPlayer = playerTurn + 1;
            int losingPlayerID = (playerTurn + 1) % 2;
            int losingPlayer = losingPlayerID + 1;

            // Announce the First Place player (who won).
            System.out.println("\n------------------------------------------------------------------------------------");
            System.out.println("---------------------------------- FINAL RESULTS -----------------------------------");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Player " + winningPlayer + " has played all their dominos!");
            System.out.println("**PLAYER " + winningPlayer + " WINS!!**");

            // Announce the Second Place player (who lost), give the
            // size of their domino set and list the dominos in their hand.
            System.out.println();
            System.out.println("Player " + losingPlayer + " has lost.");
            System.out.println("Number of dominos in Player " + losingPlayer + "'s hand: "
                              + playerOBJ[(losingPlayerID)].getHand().size());
            System.out.println("Dominos in Player " + losingPlayer + "'s hand: "
                              + playerOBJ[(losingPlayerID)].getHand());
         }
      }
   }

   // Check which domino the player can play.
   public int canPlay(JPlayer player)
   {
      int top = myTableOBJ.getTopSide();
      int bot = myTableOBJ.getBotSide();
      
      for (int i = 0; i < player.getHand().size(); i++)
      {
         if (player.getHand().get(i).getLeft() == top || player.getHand().get(i).getRight() == top)
         {
            // Flip domino if left side is equal to top.
            if (player.getHand().get(i).getLeft() == top)
               player.getHand().get(i).flip();

            // Since the domino can be added to top,
            // set the sideToAddTo to top.
            sideToAddTo = "top";

            // Return the playable domino index in hand.
            return i;
         }

         if (player.getHand().get(i).getLeft() == bot || player.getHand().get(i).getRight() == bot)
         {
            // Flip domino if right side is equal to bot.
            if (player.getHand().get(i).getRight() == bot)
               player.getHand().get(i).flip();

            // Since the domino can be added to bot,
            // set the sideToAddTo to bot.
            sideToAddTo = "bot";

            // Return the playable domino index in hand.
            return i;
         }
      }

      // if we never find a match in the players hand, we return -1
      return -1;
   }

   /*
    * Places a Domino from the players hand onto the Table.
    *
    * @param playerID The player from whose hand the domino is placed.
    */
   public void placeDomino(int playerID)
   {
      // Get the index of the domino or -1.
      int dominoIndex = canPlay(playerOBJ[playerID]);

      if (sideToAddTo.equals("top"))
         myTableOBJ.setLeftDomino(playerOBJ[playerID].getHand().remove(dominoIndex));

      if (sideToAddTo.equals("bot"))
         myTableOBJ.setRightDomino(playerOBJ[playerID].getHand().remove(dominoIndex));

      // State who placed a domino onto the table.
      System.out.println("PLAYER " + (playerID + 1) + " HAS PLACED A DOMINO\n");

      // Print the player hands and the dominos on the table.
      System.out.println("Player 1: " + playerOBJ[0].getHand());
      System.out.println("Player 2: " + playerOBJ[1].getHand());
      myTableOBJ.printGame();
      System.out.println("\n");
      System.out.println("\n************************************************************************************");
   }
}
