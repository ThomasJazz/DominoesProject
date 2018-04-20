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
     * Takes a piece from the player boneyard and adds it to their hand, if it can be added
     * @param pieceNo   The ID of the piece to be taken
     * @return          0 if the piece is unavailable, 1 if the piece is available
     */
    public int takePiece(int pieceNo) {
        int numberWasAvailable = 1;

        DataDomino takenPiece = playerBoneyard.getPiece(pieceNo);
        System.out.println("Taken Piece: " + takenPiece);
        
        // Remove the Domino from myDominoList and add it into got 
        hand.add(playerBoneyard.getMyDominoList().remove(pieceNo));

        return (numberWasAvailable);
    }
    
    public LinkedList<DataDomino> getHand()
    {
        return hand;
    }
    
    public JDomino getPlayerBoneyard(){
        return playerBoneyard;
    }
}