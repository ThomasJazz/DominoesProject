/* have to use LinkedList instead of Deque because java version of Deque doesn't allow us to access
* the object at any given index like the C++ version does*/
import java.util.LinkedList;


public class JDomino {
    private LinkedList<DataDomino> myDominoList = new LinkedList<>();

    public void API(){
        init();
    }

    /**
     *
     * @param pieceID
     * @return
     */
    public DataDomino getPiece(int pieceID){
        DataDomino myPiece = myDominoList.get(pieceID);
        
        myDominoList.set(pieceID, myPiece); // equivalent to myDominoList.at(pieceID)=myPiece
        return myPiece;
    }

    private void init(){
        for (int right = 0; right < 7; right++) {
            for (int left = right; left < 7 ; left++) {
                DataDomino myPiece = new DataDomino();
                myPiece.setRight(right);
                myPiece.setLeft(left);
                myPiece.setAvailable(1);
                System.out.print(myPiece.toString());
                myDominoList.add(myPiece);
            }
            System.out.println();
        }
        System.out.println("myDominoList stores " + myDominoList.size() + " pieces.");
    }
    public LinkedList<DataDomino> getMyDominoList(){
        return myDominoList;
    }

    public DataDomino getDomino(int index){
        return myDominoList.get(index);
    }
    
    public boolean isEmpty()
    {
        return (myDominoList.size() == 0);
    }
    
    @Override
    public String toString(){
        return myDominoList.toString();
    }
}
