import java.util.LinkedList;


public class JPlayer extends JRandom {
    LinkedList<DataDomino> gotHand = new LinkedList<>();
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
        int numberWasAvailable = 0;

        DataDomino takenPiece = playerBoneyard.getPiece(pieceNo);
        System.out.println("Taken Piece: " + takenPiece);

        if(takenPiece.getAvailable() == 1) {
            numberWasAvailable = takenPiece.getAvailable();

            // Set the domino to "No Longer Available".
            takenPiece.setAvailable(0);

            // MODIFY THIS STATEMENT WHEN CLASSES ARE MERGER!!!!!!!!!!!!!!!!!!!!
            playerBoneyard.myDominoList.set(pieceNo, takenPiece);

            // add the domino onto the LinkedList
            gotHand.add(takenPiece);

        } else {
            System.out.println("********NOT AVAILABLE********");
        }
        return (numberWasAvailable);
    }

    public JDomino getPlayerBoneyard(){
        return playerBoneyard;
    }

    public void updateBoneyard(JDomino input){
        playerBoneyard.updateList(input);
    }
}