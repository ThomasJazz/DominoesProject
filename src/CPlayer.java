import java.util.LinkedList;

/**
 *
 * @author cs380003_14
 */
public class CPlayer extends CRandom {
    LinkedList<DataDomino> gotHand = new LinkedList<>();
    CDomino playerPDominoOBJ = new CDomino();
    
    // Passing Object as Pointer - for different classes interface.
    public void API(CDomino recieveDominoPointerOBJ) {
        int pieceID;
        playerPDominoOBJ = recieveDominoPointerOBJ;
    }

    /**
     *
     * @param pieceNo
     * @return
     */
    public int takePiece(int pieceNo) {
        int playerID;
        int counter = 0, max = 14, numberWasAvailable = 0;
        
        DataDomino takenPiece = playerPDominoOBJ.getPiece(pieceNo);
        
        if(takenPiece.getAvailable() == 1) {
            numberWasAvailable = takenPiece.getAvailable();
            
            // Set the domino to "No Longer Available".
            takenPiece.setAvailable(0);

            // MODIFY THIS STATEMENT WHEN CLASSES ARE MERGER!!!!!!!!!!!!!!!!!!!!
            playerPDominoOBJ.myDomino.set(pieceNo, takenPiece);
            
            // Set the domino to "Available" in Player's hand.
            takenPiece.setAvailable(1);
            
            // add the domino onto the LinkedList
            gotHand.add(takenPiece);
        } else {
            System.out.println("NOT AVAILABLE");
        }
        return (numberWasAvailable);
    }
}