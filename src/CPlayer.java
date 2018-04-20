package dominosprojectcs380;

import java.util.LinkedList;


public class CPlayer extends CRandom {
    LinkedList<DataDomino> gotHand = new LinkedList<>();
    CDomino playerPDominoOBJ = new CDomino();
    
    boolean winner;
    
    // Passing Object as Pointer - for different classes interface.
    public void API(CDomino recieveDominoPointerOBJ) {
        playerPDominoOBJ = recieveDominoPointerOBJ;
    }

    /**
     *
     * @param pieceNo
     * @return
     */
    public int takePiece(int pieceNo) {
        int numberWasAvailable = 0;
        
        DataDomino takenPiece = playerPDominoOBJ.getPiece(pieceNo);
        System.out.println("Taken Piece: " + takenPiece);
        
        if(takenPiece.getAvailable() == 1) {
            numberWasAvailable = takenPiece.getAvailable();
            
            // Set the domino to "No Longer Available".
            takenPiece.setAvailable(0);

            // MODIFY THIS STATEMENT WHEN CLASSES ARE MERGER!!!!!!!!!!!!!!!!!!!!
            playerPDominoOBJ.myDomino.set(pieceNo, takenPiece);
            System.out.println(playerPDominoOBJ.myDomino);
            
            // Set the domino to "Available" in Player's hand.
            //takenPiece.setAvailable(1);
            System.out.println(playerPDominoOBJ.myDomino);
            
            // add the domino onto the LinkedList
            gotHand.add(takenPiece);
            
        } else {
            System.out.println("NOT AVAILABLE");
        }
        return (numberWasAvailable);
    }
}