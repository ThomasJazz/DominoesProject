package dominosprojectcs380;

public class Dominos {
    public static void main(String[] args) {
       int pieceID;
        CDomino dominoOBJ = new CDomino();
        dominoOBJ.API();

        CPlayer[] playerOBJ = new CPlayer[2];
        playerOBJ[0] = new CPlayer();
        playerOBJ[1] = new CPlayer();

        playerOBJ[0].API(dominoOBJ);
        playerOBJ[1].API(dominoOBJ);

        CTable myTableOBJ = new CTable();
        myTableOBJ.API(playerOBJ);
        
        System.out.println("****************************");
        System.out.println("Player 1: " + playerOBJ[0].gotHand);
        System.out.println("Player 2: " + playerOBJ[1].gotHand);
        //For Debug
        // System.out.println("Check pointer effect on dominoOBJ");
//        for(pieceID = 0; pieceID < 28; pieceID++)
//            dominoOBJ.getPiece(pieceID);
        
        
        
    }

}
