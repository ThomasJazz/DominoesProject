/**
 * @author cs380003_14
 */
public class DataDomino
{
    protected int right, left, available;
    
    
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
}
