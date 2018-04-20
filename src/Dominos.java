/**
 * DOMINOES RULES THAT OUR CODE FOLLOWS
 * Game starts by having players draw 7 dominoes each.
 * 1st round:   Player 0 places a domino on the board
 * 2nd+ round:  Players alternate placing dominoes on each end of the domino line.
 *              If a player CANNOT play with the dominoes in their hand, they keep drawing
 *              until they CAN play or until there are 2 dominoes left in the boneyard
 * Winning:     The game is over if either: a player has played all their dominoes or
 *              the boneyard is empty and neither player is able to play
 */


public class Dominos {
    private JDomino dominoOBJ;
    private JPlayer[] playerOBJ;
    private JTable myTableOBJ;

    public static void main(String[] args) {
       new Dominos().play(); // best to leave main method according to my old DS teacher
    }
    
    public void play(){
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

        /* for testing
        playerOBJ[0].draw(0);
        System.out.println("New hand after drawing: \n" + playerOBJ[0].getHand());
         */
        // now we actually start taking turns.
        // real dominoes would have the player with the highest domino go first, but we just
        //start with player[0]
        //myTableOBJ.
        JRandom rand = new JRandom();
        int start = rand.getRandom(0,1); // randomly decide who starts first

        for (int i = start; !winner; i++) {
            // use mod 2 to toggle player turn
            int playerTurn = i % 2;

            // if the player has a domino they can play, they play it.
            if (canPlay(playerOBJ[playerTurn]) != -1) {

            }
            
            else {
                // player draws until they can play a domino or until boneyard is empty
                while (canPlay(playerOBJ[playerTurn]) == -1 && !myTableOBJ.boneyard.isEmpty())
                    playerOBJ[playerTurn].draw(playerTurn);

                // if neither player can play and the boneyard is empty, the game is over
                if (myTableOBJ.boneyard.isEmpty() && canPlay(playerOBJ[0]) == -1 && canPlay(playerOBJ[1]) == -1) {
                    winner = true;
                    System.out.println("Neither player can play and boneyard is empty!" +
                            "\nExiting game...");
                }
            }
            
            // If one of the players no longer has any dominos in
            // hand, then they win. Game Over.
            if (playerOBJ[playerTurn].getHand().size() == 0){
                winner = true;
                System.out.println("Player " + playerTurn + " has played all their dominos!");
                System.out.println("**Player " + playerTurn + " wins!!**");
            }
        }
    }
    
    // Check which domino the player can play.
    public int canPlay(JPlayer player) {
        int top = myTableOBJ.getTopSide();
        int bot = myTableOBJ.getBotSide();
        
        for (int i = 0; i < player.getHand().size(); i++){
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
