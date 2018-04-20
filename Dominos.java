package dominosprojectcs380;


public class Dominos {
    public static void main(String[] args) {
       new Dominos().play(); // best to leave main method according to my old DS teacher
    }
    public void play(){
        boolean winner = false;
        int pieceID;

        JDomino dominoOBJ = new JDomino();
        dominoOBJ.API();

        JPlayer[] playerOBJ = new JPlayer[2];
        playerOBJ[0] = new JPlayer();
        playerOBJ[1] = new JPlayer();

        playerOBJ[0].API(dominoOBJ);
        playerOBJ[1].API(dominoOBJ);

        JTable myTableOBJ = new JTable(dominoOBJ);
        myTableOBJ.API(playerOBJ);
        
        // ************ FOR TESTING ************
        System.out.println("****************************");
        System.out.println("Player 1: " + playerOBJ[0].getHand());
        System.out.println("Player 2: " + playerOBJ[1].getHand());
        
        System.out.println("Full List:" + dominoOBJ);
        // ************ FOR TESTING ************
        
        
        // now we actually start taking turns.
        // real dominoes would have the player with the highest domino go first, but we just
        for(int i = 0; !winner; i++)
        {
            // use mod 2 to toggle player turn
            int playerTurn = i%2;
            
        }
    }
}