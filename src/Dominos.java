public class Dominos {
    public static void main(String[] args) {
       int pieceID;
        CDomino dominoOBJ = new CDomino();
        dominoOBJ.API();

        CPlayer[] playerOBJ = new CPlayer[2];
        playerOBJ[0].API(dominoOBJ);
        playerOBJ[1].API(dominoOBJ);

        CTable myTableOBJ = new CTable();
        myTableOBJ.API(playerOBJ);

        System.out.println("Check pointer effect on dominoOBJ");
        for(pieceID = 0;pieceID < 28; pieceID++)
            dominoOBJ.getPiece(pieceID);
    }

}
