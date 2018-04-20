/* have to use LinkedList instead of Deque because java version of Deque doesn't allow us to access
* the object at any given index like the C++ version does*/
import java.util.LinkedList;

public class JDomino {
    public LinkedList<DataDomino> myDominoList = new LinkedList<>();

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
        
        // Print is for Debug
//        System.out.println("[" + myPiece.getLeft() + "|" + myPiece.getRight() + "]"
//            + " available = " + myPiece.getAvailable());
        
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

    public DataDomino remove(int index){
        return myDominoList.remove(index);
    }

    /**
     * First we clear the players boneyard list. Then we add the masters boneyard list
     * @param master
     */
    public void updateList(JDomino master) {
        myDominoList.clear();
        myDominoList.addAll(master.getMyDominoList());
    }

    public boolean add(DataDomino incoming){
        myDominoList.add(incoming);
        return true;
    }
    public String toString(){
        return myDominoList.toString();
    }
}
