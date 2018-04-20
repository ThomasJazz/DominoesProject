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

        System.out.println("****************************");
        System.out.println("Player 1: " + playerOBJ[0].hand);
        System.out.println("Player 2: " + playerOBJ[1].hand);

        /* now we actually start taking turns.
        // real dominoes would have the player with the highest domino go first, but we just
        start with player[0]*/
        //myTableOBJ.
        for (int i = 0; !winner; i++) {
            int playerTurn = i%2; // use mod 2 to toggle player turn
            i++;

            if (canPlay(playerOBJ[playerTurn]) == -1){
                playerOBJ[playerTurn].draw(playerTurn);
            }

            if (myTableOBJ.boneyard.isEmpty() && canPlay(playerOBJ[0]) == -1 && canPlay(playerOBJ[1]) == -1) {
                winner = true;
                System.out.println("Neither player can play and boneyard is empty!" +
                        "\nExiting game...");
            }

            if (playerOBJ[playerTurn].getHand().size() == 0){
                winner = true;
                System.out.println("Player " + playerTurn + " has played all their dominos!");
                System.out.println("**Player " + playerTurn + " wins!!**");
            }

        }
    }

    public int canPlay(JPlayer player){
        int top = myTableOBJ.getTopSide();
        int bot = myTableOBJ.getBotSide();
        for (int i = 0; i < player.getHand().size(); i++){
            if (player.getHand().get(i).getLeft() == top || player.getHand().get(i).getRight() == top)
                return i;

            if (player.getHand().get(i).getLeft() == bot || player.getHand().get(i).getRight() == bot)
                return i;
        }
        return -1; // if we never find a match in the players hand, we return -1
    }
}
