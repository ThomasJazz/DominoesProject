package dominosprojectcs380;

import java.util.Random;

/**
 *
 * @author cs380003_14
 */
public class CRandom
{
    Random rand = new Random();
    
    public int getRandomPublic(int rangeLow, int rangeHigh)
    {
        int myRandScaled;
        myRandScaled = getRandomPrivate(rangeLow, rangeHigh);
        
        return myRandScaled;
    }
    
    // Generates a uniform distribution between rangeLow and rangeHigh.
    private int getRandomPrivate(int rangeLow, int rangeHigh)
    {
        // Don't let myRand be negative!!
        double myRand = Math.abs(rand.nextInt() / (1.0 + Integer.MAX_VALUE));
        int range = rangeHigh - rangeLow + 1;
        int myRandScaled = (int) ((myRand * range) + rangeLow);
        
        return myRandScaled;
    }
    
    // Generates a uniform distribution between rangeLow and rangeHigh.
    protected int getRandomProtected(int rangeLow, int rangeHigh)
    {
        // Don't let myRand be negative!!
        double myRand = Math.abs(rand.nextInt() / 1.0 + Integer.MAX_VALUE);
        int range = rangeHigh - rangeLow + 1;
        int myRandScaled = (int) ((myRand * range) + rangeLow);
        
        return myRandScaled;
    }
}
