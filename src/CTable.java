package dominosprojectcs380;

public class CTable {
    public CPlayer[] playerOBJ = null;

    public void selecting_pieces(){
        int pieceNo, totalPlayer = 2, pieceWasAvailable;

        System.out.println("take piece one by one");

        for (int playerID=0; playerID<totalPlayer; playerID++) {
            for (int i = 0; i < 7; i++) { // not sure why I only had this iterate 12 times before...
                // get unique pieceNo values from 0-27
                CRandom randomPieceNum = new CRandom();
                pieceNo = randomPieceNum.getRandomPublic(0, 27);

                System.out.println("pieceNo = " + pieceNo);
                pieceWasAvailable = playerOBJ[playerID].takePiece(pieceNo);

                if (pieceWasAvailable == 1)
                {
                    System.out.println("piece available");
                }
                
                else
                {
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

            // Does this just display each players hand or is there additional functionality?
            /*for (int pieceNo = 0; pieceNo < playerOBJ[playerID].gotHand.size(); pieceNo++){
                showPiece = playerOBJ[playerID].gotHand.get(pieceNo);
                System.out.println("[" + showPiece.left + "|" + showPiece.right +"]" +
                " available = " + showPiece.available);
            } */
        }
    }
    public void API(CPlayer[] players){
        playerOBJ = players; // copy players array into playerOBJ

        selecting_pieces();
        showPlayerHand();
    }
}
