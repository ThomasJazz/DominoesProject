/* have to use LinkedList instead of Deque because java version of Deque doesn't allow us to access
* the object at any given index like the C++ version does*/
import java.util.LinkedList;
public class CDomino {
    public LinkedList<data_domino> myDomino;

    public void API(){
        init();
    }

    /**
     *
     * @param pieceID
     * @return
     */
    public data_domino getPiece(int pieceID){
        data_domino myPiece = myDomino.get(pieceID);
        System.out.println("[" + myPiece.left + "|" + myPiece.right + "]"
            + " available = " + myPiece.available);
        myDomino.set(pieceID, myPiece); // equivalent to myDomino.at(pieceID)=myPiece
        return myPiece;
    }

    private void init(){
        data_domino myPiece = new data_domino();
        for (int right = 0; right < 7; right++) {
            for (int left = right;left <7 ; left++) {
                myPiece.right = right;
                myPiece.left = left;
                myPiece.available = 1;
                System.out.println("[" + myPiece.left + "|" + myPiece.right + "]" + " ");
                myDomino.push(myPiece);
            }
            System.out.println();
        }
        System.out.println("myDomino stores " + myDomino.size() + " pieces.\n");
    }
}
