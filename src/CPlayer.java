package dominosprojectcs380;

import java.util.LinkedList;

/**
 *
 * @author cs380003_14
 */
public class CPlayer extends CRandom
{
    LinkedList<DataDomino> gotHand;
    CDomino[] playerPDominoOBJ = null;
    
    // Passing Object as Pointer - for different classes interface.
    public void api(CDomino[] recieveDominoPointerOBJ)
    {
        int pieceID;
        playerPDominoOBJ = recieveDominoPointerOBJ;
    }
    
    public int takePiece(int pieceNo)
    {
        int playerID;
        int counter = 0, max = 14, numberWasAvailable = 0;
        
        DataDomino takenPiece = playerPDominoOBJ.getPiece(pieceNo);
        
        if(takenPiece.getAvailable() == 1)
        {
            numberWasAvailable = takenPiece.getAvailable();
            
            // Set the domino to "No Longer Available".
            takenPiece.setAvailable(0);
            
            // MODIFY THIS STATEMENT WHEN CLASSES ARE MERGER!!!!!!!!!!!!!!!!!!!!
            playerPDominoOBJ.myDomion.set(pieceNo, takenPiece);
            
            System.out.println("[" + takenPiece.getLeft() + "|" + takenPiece.getRight() + "]"
                             + " Just Taken - No Longer Avaliable From The Pile = 0");
            
            // Set the domino to "Available" in Player's hand.
            takenPiece.setAvailable(1);
            
            // Push the domino onto the LinkedList.
            gotHand.addFirst(takenPiece);
        }
        
        else
            System.out.println("NOT AVAILABLE");
        
        return (numberWasAvailable);
        }
    }
}
