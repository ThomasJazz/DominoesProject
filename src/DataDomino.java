/**
 * @author cs380003_14
 */
public class DataDomino
{
    private int right, left, available;
    
    public DataDomino()
    {
        this.left = 9; // this is how we will mark empty dominos on the board
    }
    
    public DataDomino(DataDomino otherDomino)
    {
        this.right = otherDomino.getRight();
        this.left = otherDomino.getLeft();
        this.available = otherDomino.getAvailable();
    }
    
    
    // ******** GETTER METHODS ********
    public int getRight()
    {
        return right;
    }
    
    public int getLeft()
    {
        return left;
    }
    
    // NOTE: 1 = available, 0 = not avialable
    public int getAvailable()
    {
        return available;
    }
    
    
    // ******** SETTER METHODS ********
    public void setRight(int right)
    {
        this.right = right;
    }
    
    public void setLeft(int left)
    {
        this.left = left;
    }
    
    public void setAvailable(int available)
    {
        this.available = available;
    }
    
    @Override
    public String toString()
    {
        if (left == 9) // if domino is just an empty spot
            return "-";
        else
            return(available + " [" + left + "|" + right + "]" + " ");
    }
}
