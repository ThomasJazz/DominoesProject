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
            System.out.println("\nPlayer " + playerID + " is Drawing:");
            
            for (int i = 0; i < 10; i++) { // not sure why I only had this iterate 12 times before...
                // get unique pieceNo values from 0-27
                JRandom randomPieceNum = new JRandom();
                pieceNo = randomPieceNum.getRandom(0, boneyard.getMyDominoList().size() - 1);
                playerOBJ[playerID].takePiece(pieceNo);
            }
        }
        
        System.out.println("\n'Master boneyard' now contains " + boneyard.getMyDominoList().size()
        + " pieces: ");
        System.out.println(boneyard.toString());
        System.out.println();
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
    
    // Prints out the whole game.
    public void printGame()
    {
        System.out.println("*********** Dominos In Play ***********\n");
        System.out.println(dominos);
        System.out.println();
    }
}
