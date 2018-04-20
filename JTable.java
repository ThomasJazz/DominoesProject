package dominosprojectcs380;

import java.util.*;


public class JTable {
    public JPlayer[] playerOBJ;
    public JDomino boneyard;
    private List<DataDomino> dominos; // will contain the two dominos that can be played upon
    private int topSide, botSide;

    public JTable(JDomino recieveDominoPointerOBJ){
        playerOBJ = null;
        boneyard = recieveDominoPointerOBJ;
        dominos = new LinkedList<>();
    }

    public void selecting_pieces(){
        int pieceNo, totalPlayer = 2, pieceWasAvailable;
        System.out.println("take piece one by one");

        for (int playerID=0; playerID<totalPlayer; playerID++) {
            for (int i = 0; i < 7; i++) { // not sure why I only had this iterate 12 times before...
                // get unique pieceNo values from 0-27
                JRandom randomPieceNum = new JRandom();
                pieceNo = randomPieceNum.getRandomPublic(0, boneyard.getMyDominoList().size() - 1);

                System.out.println("pieceNo = " + pieceNo);
                pieceWasAvailable = playerOBJ[playerID].takePiece(pieceNo);

                if (pieceWasAvailable == 1) {
                    System.out.println("piece available");
                } else {
                    i--;
                }
            }
        }
        
        System.out.println("\n'Master boneyard' now contains " + boneyard.getMyDominoList().size()
        + " pieces: ");
        System.out.println(boneyard.toString());
        System.out.println("");
    }

    public void showPlayerHand() {
        DataDomino showPiece = new DataDomino();
        int totalPlayer = 2;
        for (int playerID = 0; playerID < totalPlayer; playerID++){
            System.out.println("playerID = " + playerID + " stores " +
                playerOBJ[playerID].getHand().size() + " pieces.\n");
        }
    }
    
    public void API(JPlayer[] players){
        playerOBJ = players; // copy players array into playerOBJ

        selecting_pieces();
        showPlayerHand();
    }

    public int getTopSide(){
        return topSide;
    }

    public int getBotSide(){
        return botSide;
    }
}
