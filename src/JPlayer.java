package dominosprojectcs380;

import java.util.LinkedList;

public class JPlayer extends JRandom {

    LinkedList<DataDomino> hand = new LinkedList<>();
    JDomino playerBoneyard = new JDomino();

    boolean winner;

    // Passing Object as Pointer - for different classes interface.
    public void API(JDomino recieveDominoPointerOBJ) {
        playerBoneyard = recieveDominoPointerOBJ;
    }

    /**
     * Takes a piece from the player boneyard and adds it to their hand, if it
     * can be added
     *
     * @param pieceNo The ID of the piece to be taken
     * @return 0 if the piece is unavailable, 1 if the piece is available
     */
    public void takePiece(int pieceNo) {
        DataDomino takenPiece = playerBoneyard.getPiece(pieceNo);
        System.out.println("Taken Piece: " + takenPiece);

        // Remove the Domino from myDominoList and add it into got 
        hand.add(playerBoneyard.getMyDominoList().remove(pieceNo));
    }

    public LinkedList<DataDomino> getHand() {
        return hand;
    }

    public void draw(int playerID) {
        int pieceNo;
        
        // Add a random domino from myDominoList to hand by removing it from myDominoList.
        JRandom randomPieceNum = new JRandom();
        pieceNo = randomPieceNum.getRandom(0, playerBoneyard.getMyDominoList().size() - 1);
        hand.add(playerBoneyard.getMyDominoList().remove(pieceNo));
        
        System.out.println("Player " + playerID + " has drawn pieceNo: " + pieceNo);
    }

    public JDomino getPlayerBoneyard() {
        return playerBoneyard;
    }
}
