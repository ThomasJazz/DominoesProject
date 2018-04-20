package dominosprojectcs380;

import java.util.Random;

public class Dominos {
    
    JDomino dominoOBJ;
    JPlayer[] playerOBJ;
    JTable myTableOBJ;
    Random rand;
    
    public static void main(String[] args) {
        new Dominos().play(); // best to leave main method according to my old DS teacher
    }

    public void play() {
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
        // ************ FOR TESTING ************

        // now we actually start taking turns.
        // real dominoes would have the player with the highest domino go first, but we just
        
        
        
        for (int i = 0; !winner; i++)
        {
            // use mod 2 to toggle player turn
            int playerTurn = i % 2;
            
            // If no playable pieces in players hand, then draw.
            if (canPlay(playerOBJ[playerTurn]) == -1) {
                playerOBJ[playerTurn].draw(playerTurn);
            }
            
            // If neither player has playable piece and myDominoList
            // is empty, then there is a DRAW, Game Over, no winner.
            if (myTableOBJ.boneyard.isEmpty() && canPlay(playerOBJ[0]) == -1 && canPlay(playerOBJ[1]) == -1) {
                winner = true;
                System.out.println("Neither player can play and boneyard is empty!"
                        + "\nExiting game...");
            }
            
            // If one of the players no longer has any dominos in
            // hand, then they win. Game Over.
            if (playerOBJ[playerTurn].getHand().size() == 0) {
                winner = true;
                System.out.println("Player " + playerTurn + " has played all their dominos!");
                System.out.println("**Player " + playerTurn + " wins!!**");
            }
        }
    }
    
    // Check which domino the player can play.
    public int canPlay(JPlayer player)
    {
        int top = myTableOBJ.getTopSide();
        int bot = myTableOBJ.getBotSide();
        
        for (int i = 0; i < player.getHand().size(); i++) {
            if (player.getHand().get(i).getLeft() == top || player.getHand().get(i).getRight() == top) {
                // Return the playable domino index in hand.
                return i;
            }

            if (player.getHand().get(i).getLeft() == bot || player.getHand().get(i).getRight() == bot) {
                // Return the playable domino index in hand.
                return i;
            }
        }
        
        // if we never find a match in the players hand, we return -1
        return -1;
    }
}
