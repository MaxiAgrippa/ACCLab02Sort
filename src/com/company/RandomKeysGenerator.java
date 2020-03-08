package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @author Maxi Agrippa
 */
public class RandomKeysGenerator
{
    /**
     * Number of Keys
     */
    private int numberOfKeys = 100000;

    /**
     * Store Random Keys
     * NOTICE: Anytype need Long to support instead long(embedded)
     */
    public Long[] randomKeys = new Long[numberOfKeys];

    /**
     * Using Random to generate Keys(Long)
     */
    public Random random = new Random(System.currentTimeMillis());

    /**
     * Constructor that also Generate Keys
     *
     * @param numberOfKeys The number of keys you want to generate
     */
    public RandomKeysGenerator (int numberOfKeys)
    {
        if (IsValidNumber(numberOfKeys))
        {
            this.randomKeys = new Long[numberOfKeys];
        }
        GenerateRandomKeys(numberOfKeys);
    }

    /**
     * Generate and return random keys by using random.
     * @param numberOfKeys
     * @return
     */
    public Long[] GenerateRandomKeys (int numberOfKeys)
    {
        if (IsValidNumber(numberOfKeys))
        {
            for (int i = 0; i < numberOfKeys; i++)
            {
                randomKeys[i] = random.nextLong();
            }
        }
        return randomKeys;
    }

    /**
     * Getter for numberOfKeys
     *
     * @return numberOfKeys(int)
     */
    public int getNumberOfKeys ()
    {
        return numberOfKeys;
    }

    /**
     * Setter for numberOfKeys
     *
     * @param numberOfKeys
     */
    public void setNumberOfKeys (int numberOfKeys)
    {
        if (IsValidNumber(numberOfKeys))
        {
            this.numberOfKeys = numberOfKeys;
        }
    }

    /**
     * Check if the numberOfKeys is valid or not
     * @param numberOfKeys
     * @return
     */
    private boolean IsValidNumber (int numberOfKeys)
    {
        if (numberOfKeys > 0)
        {
            return true;
        }
        return false;
    }
}
