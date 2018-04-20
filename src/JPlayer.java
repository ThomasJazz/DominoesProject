import java.util.LinkedList;

public class JPlayer extends JRandom {
    private LinkedList<DataDomino> hand = new LinkedList<>();
    private JDomino playerBoneyard = new JDomino();

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
    public void takePiece(int pieceNo) {
        DataDomino takenPiece = playerBoneyard.getPiece(pieceNo);
        System.out.println("Taken Piece: " + takenPiece);
        hand.add(playerBoneyard.getMyDominoList().remove(pieceNo));
    }

    public LinkedList<DataDomino> getHand(){
        return hand;
    }

    public void draw(int playerID){
        int pieceNo;

        JRandom randomPieceNum = new JRandom();
        pieceNo = randomPieceNum.getRandom(0, playerBoneyard.getMyDominoList().size()-1);
        hand.add(playerBoneyard.getMyDominoList().remove());

        System.out.println("Player " + playerID + " has drawn piece:" + hand.get(hand.size()-1));
    }
    public JDomino getPlayerBoneyard(){
        return playerBoneyard;
    }
}