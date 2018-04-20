public class JTable {
    public JPlayer[] playerOBJ = null;
    public JDomino boneyard = new JDomino();

    public void selecting_pieces(){
        int pieceNo, totalPlayer = 2, pieceWasAvailable;

        System.out.println("take piece one by one");

        for (int playerID=0; playerID<totalPlayer; playerID++) {
            for (int i = 0; i < 7; i++) { // not sure why I only had this iterate 12 times before...
                // get unique pieceNo values from 0-27
                JRandom randomPieceNum = new JRandom();
                pieceNo = randomPieceNum.getRandomPublic(0, 27);

                System.out.println("pieceNo = " + pieceNo);
                pieceWasAvailable = playerOBJ[playerID].takePiece(pieceNo);

                if (pieceWasAvailable == 1) {
                    System.out.println("piece available");
                } else {
                    i--;
                }
            }
            System.out.println(playerOBJ[1].getPlayerBoneyard());
        }

        for (DataDomino domino: playerOBJ[1].getPlayerBoneyard().getMyDominoList()) {
            // if the domino at index i is still available after drafting phase, we move it into
            // the 'master' boneyard
            if (domino.getAvailable()==1)
                boneyard.add(domino);
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
                playerOBJ[playerID].gotHand.size() + " pieces.\n");
        }
    }

    public void API(JPlayer[] players){
        playerOBJ = players; // copy players array into playerOBJ

        selecting_pieces();
        showPlayerHand();
    }
}
