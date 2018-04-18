public class CTable {
    public CPlayer[] playerOBJ = null;

    public void selecting_pieces(){
        int pieceNO, totalPlayer = 2, pieceWasAvailable;

        System.out.println("selecting pieces and giving 12 pieces to each player");

        for (int playerID=0; playerID<totalPlayer; playerID++) {
            for (int i = 0; i < 12; i++) {
                pieceNO = playerOBJ[playerID].getRandomPublic(0, 27);
                System.out.println(" pieceNO : " + pieceNO);
                pieceWasAvailable = playerOBJ[playerID].takePiece(pieceNO);

                // his C++ version does this but we need a boolean value instead of int
                if (pieceWasAvailable == 1) {
                 System.out.println("piece available");
                } else {
                    System.out.println("////////////////////////////////////////////////");
                    System.out.println("piece not available - try to take a piece again");
                    i--;
                }
            }
        }
    }
    public void showPlayerHand() {
        DataDomino showPiece = new DataDomino();
        int totalPlayer = 2;
        for (int playerID = 0; playerID < totalPlayer; playerID++){
            System.out.println("playerID = " + playerID + " stores " +
                playerOBJ[playerID].gotHand.size() + " pieces.\n");

            for (int pieceNo = 0; pieceNo < playerOBJ[playerID].gotHand.size(); pieceNo++){
                showPiece = playerOBJ[playerID].gotHand.get(pieceNo);
                System.out.println("[" + showPiece.left + "|" + showPiece.right +"]" +
                " available = " + showPiece.available);
            }
        }
    }
    public void API(CPlayer[] players){
        playerOBJ = players; // copy players array into playerOBJ

        selecting_pieces();
        showPlayerHand();
    }
}
