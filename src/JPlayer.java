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
     *
     * @param pieceNo
     * @return
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