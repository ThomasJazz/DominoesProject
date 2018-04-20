public class DataDomino
{
    private int right, left, available;
    
    public DataDomino()
    {
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
    
    public void flip()
    {
        int right = this.right;
        this.right = this.left;
        this.left = right;
    }
    
    @Override
    public String toString()
    {
        return(" [" + left + "|" + right + "]" + " ");
    }
}
