public class Dominos {
    public static void main(String[] args) {
       new Dominos().play(); // best to leave main method according to my old DS teacher
    }
    public void play(){
        int pieceID;
        JDomino dominoOBJ = new JDomino();
        dominoOBJ.API();

        JPlayer[] playerOBJ = new JPlayer[2];
        playerOBJ[0] = new JPlayer();
        playerOBJ[1] = new JPlayer();

        playerOBJ[0].API(dominoOBJ);
        playerOBJ[1].API(dominoOBJ);

        JTable myTableOBJ = new JTable();
        myTableOBJ.API(playerOBJ);

        System.out.println("****************************");
        System.out.println("Player 1: " + playerOBJ[0].gotHand);
        System.out.println("Player 2: " + playerOBJ[1].gotHand);
    }
}
