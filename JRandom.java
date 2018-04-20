package dominosprojectcs380;

import java.util.Random;


public class JRandom
{
    Random rand = new Random();

    /**
     * Calls the getRandomPrivate method
     * @param rangeLow  the low end of the range to be sent
     * @param rangeHigh the high end of the range to be sent
     * @return  the "random" number we generated in getRandomPrivate
     */
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
}
