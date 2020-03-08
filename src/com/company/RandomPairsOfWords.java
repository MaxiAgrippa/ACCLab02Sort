package com.company;

import java.util.Random;

/**
 * @author Maxi Agrippa
 */
public class RandomPairsOfWords
{
    /**
     * Number of Strings
     */
    private int numberOfStrings = 1000;

    /**
     * Length of Strings
     */
    private int lengthOfStrings = 10;

    /**
     * Store the First Random String
     * NOTICE: Anytype need String to support instead string(embedded)
     */
    public String[] firstRandomStrings = new String[numberOfStrings];

    /**
     * Store the Second Random String
     * NOTICE: Anytype need String to support instead string(embedded)
     */
    public String[] secondRandomStrings = new String[numberOfStrings];

    /**
     * Alphabet string
     */
    private String alphabet = ("qwertyuiop" + "asdfghjkl" + "zxcvbnm");

    /**
     * Length of Alphabet
     */
    private static int alphabetLength = 26;

    /**
     * Using Random to generate Keys(Long)
     */
    public Random random = new Random(System.currentTimeMillis());

    /**
     * Constructor that also Generate Pairs of Strings
     *
     * @param numberOfStrings
     */
    public RandomPairsOfWords (int numberOfStrings, int lengthOfStrings)
    {
        if (IsValidNumber(numberOfStrings) && IsValidNumber(lengthOfStrings))
        {
            setNumberOfStrings(numberOfStrings);
            setLengthOfStrings(lengthOfStrings);
            this.firstRandomStrings = new String[numberOfStrings];
            this.secondRandomStrings = new String[numberOfStrings];
        }
        GenerateRandomPairsOfWords(numberOfStrings, lengthOfStrings);
    }

    /**
     * Generate two random Strings by using random.
     *
     * @param numberOfStrings the number of string(int)
     * @param lengthOfStrings the length of string(int)
     * @return randomStrings(String[])
     */
    public void GenerateRandomPairsOfWords (int numberOfStrings, int lengthOfStrings)
    {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        if (IsValidNumber(numberOfStrings) && IsValidNumber(lengthOfStrings))
        {
            setNumberOfStrings(numberOfStrings);
            setLengthOfStrings(lengthOfStrings);
            for (int i = 0; i < numberOfStrings; i++)
            {
                for (int j = 0; j < lengthOfStrings; j++)
                {
                    s1.append(alphabet.charAt(random.nextInt(alphabetLength)));
                    s2.append(alphabet.charAt(random.nextInt(alphabetLength)));
                }
                firstRandomStrings[i] = s1.toString();
                secondRandomStrings[i] = s2.toString();
                s1 = new StringBuffer();
                s2 = new StringBuffer();
            }
        }
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
