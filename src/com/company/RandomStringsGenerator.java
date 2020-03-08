package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Maxi Agrippa
 */
public class RandomStringsGenerator
{
    /**
     * Number of Strings
     */
    private int numberOfStrings = 100000;

    /**
     * Length of Strings
     */
    private int lengthOfStrings = 4;

    /**
     * Store Random String
     * NOTICE: Anytype need String to support instead string(embedded)
     */
    public String[] randomStrings = new String[numberOfStrings];

    /**
     * Alphabet string
     */
    private String alphabet = ("qwertyuiop" + "asdfghjkl" + "zxcvbnm" + "QWERTYUIOP" + "ASDFGHJKL" + "ZXCVBNM");

    /**
     * Length of Alphabet
     */
    private static int alphabetLength = 52;

    /**
     * Using Random to generate Keys(Long)
     */
    public Random random = new Random(System.currentTimeMillis());

    /**
     * Constructor that also Generate Strings
     *
     * @param numberOfStrings
     */
    public RandomStringsGenerator (int numberOfStrings, int lengthOfStrings)
    {
        if (IsValidNumber(numberOfStrings) && IsValidNumber(lengthOfStrings))
        {
            setNumberOfStrings(numberOfStrings);
            setLengthOfStrings(lengthOfStrings);
            this.randomStrings = new String[numberOfStrings];
        }
        GenerateRandomStrings(numberOfStrings, lengthOfStrings);
    }

    /**
     * Generate and return random Strings by using random.
     *
     * @param numberOfStrings the number of string(int)
     * @param lengthOfStrings the length of string(int)
     * @return randomStrings(String[])
     */
    public String[] GenerateRandomStrings (int numberOfStrings, int lengthOfStrings)
    {
        StringBuffer s = new StringBuffer();
        if (IsValidNumber(numberOfStrings) && IsValidNumber(lengthOfStrings))
        {
            setNumberOfStrings(numberOfStrings);
            setLengthOfStrings(lengthOfStrings);
            for (int i = 0; i < numberOfStrings; i++)
            {
                for (int j = 0; j < lengthOfStrings; j++)
                {
                    s.append(alphabet.charAt(random.nextInt(alphabetLength)));
                }
                randomStrings[i] = s.toString();
                s = new StringBuffer();
            }
        }
        return randomStrings;
    }


    /**
     * Getter for numberOfStrings
     *
     * @return numberOfStrings(int)
     */
    public int getNumberOfStrings ()
    {
        return numberOfStrings;
    }

    /**
     * Setter for numberOfStrings
     *
     * @param numberOfStrings
     */
    public void setNumberOfStrings (int numberOfStrings)
    {
        if (IsValidNumber(numberOfStrings))
        {
            this.numberOfStrings = numberOfStrings;
        }
    }

    /**
     * Getter of lengthOfStrings
     *
     * @return
     */
    public int getLengthOfStrings ()
    {
        return lengthOfStrings;
    }

    /**
     * Setter of lengthOfStrings
     *
     * @param lengthOfStrings
     */
    public void setLengthOfStrings (int lengthOfStrings)
    {
        if (IsValidNumber(lengthOfStrings))
        {
            this.lengthOfStrings = lengthOfStrings;
        }
    }

    private boolean IsValidNumber (int numberOfStrings)
    {
        if (numberOfStrings > 0)
        {
            return true;
        }
        return false;
    }
}
