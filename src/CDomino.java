/* have to use LinkedList instead of Deque because java version of Deque doesn't allow us to access
* the object at any given index like the C++ version does*/
import java.util.LinkedList;
public class CDomino {
    public LinkedList<DataDomino> myDomino = new LinkedList<>();

    public void API(){
        init();
    }

    /**
     *
     * @param pieceID
     * @return
     */
    public DataDomino getPiece(int pieceID){
        DataDomino myPiece = myDomino.get(pieceID);
        System.out.println("[" + myPiece.left + "|" + myPiece.right + "]"
            + " available = " + myPiece.available);
        myDomino.set(pieceID, myPiece); // equivalent to myDomino.at(pieceID)=myPiece
        return myPiece;
    }

    private void init(){
        for (int right = 0; right < 7; right++) {
            for (int left = right;left < 7 ; left++) {
                DataDomino myPiece = new DataDomino();
                myPiece.right = right;
                myPiece.left = left;
                myPiece.available = 1;
                System.out.print("[" + myPiece.left + "|" + myPiece.right + "]" + " ");
                myDomino.add(myPiece);
            }
            System.out.println();
        }
        System.out.println("myDomino stores " + myDomino.size() + " pieces.\n");
    }
}
