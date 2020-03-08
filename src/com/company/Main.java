package com.company;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Maxi Agrippa
 */
public class Main
{
    /**
     * the number of keys
     */
    public static int numberOfKeys = 100000;

    /**
     * Using RandomKeysGenerator to Generate keys
     */
    public static RandomKeysGenerator randomKeysGenerator = new RandomKeysGenerator(numberOfKeys);

    /**
     * Storing random keys
     */
    public static Long[] randomKeys = null;

    /**
     * the number of keys
     */
    public static int numberOfStrings = 100000;

    /**
     * the length of strings
     */
    public static int lenghOfStrings = 4;


    /**
     * Using RandomStringsGenerator to Generate Strings
     */
    public static RandomStringsGenerator randomStringsGenerator = new RandomStringsGenerator(numberOfStrings, lenghOfStrings);

    /**
     * Storing random Strings
     */
    public static String[] randomStrings = null;

    /**
     * Using RandomPairsOfWords to Generate Pairs of Strings
     */
    public static RandomPairsOfWords randomPairsOfWords = new RandomPairsOfWords(numberOfStrings, lenghOfStrings);

    /**
     * Store the First Random String
     * NOTICE: Anytype need String to support instead string(embedded)
     */
    public static String[] firstRandomStrings = new String[numberOfStrings];

    /**
     * Store the Second Random String
     * NOTICE: Anytype need String to support instead string(embedded)
     */
    public static String[] secondRandomStrings = new String[numberOfStrings];

    /**
     * Main
     *
     * @param args
     */
    public static void main (String[] args)
    {
        randomKeys = randomKeysGenerator.GenerateRandomKeys(numberOfKeys);
        randomStrings = randomStringsGenerator.GenerateRandomStrings(numberOfStrings, lenghOfStrings);
        randomPairsOfWords = new RandomPairsOfWords(numberOfStrings, lenghOfStrings);
        firstRandomStrings = randomPairsOfWords.firstRandomStrings;
        secondRandomStrings = randomPairsOfWords.secondRandomStrings;

        ConsoleUI();
    }

    /**
     * Console user interface
     */
    private static void ConsoleUI ()
    {
        boolean AppOn = true;
        while (AppOn)
        {
            // Reduce the influence of CPU prediction and OS optimize
            MeaninglessLoop();

            System.out.println("Task 01");

            //Task 01
            OneLakhKeysSort();

            System.out.println("Task 02");

            //Task 02
            System.out.println("_________lenghOfStrings = 4______________________________");
            lenghOfStrings = 4;
            OneLakhStringSort();
            System.out.println("_________lenghOfStrings = 6______________________________");
            lenghOfStrings = 6;
            OneLakhStringSort();
            System.out.println("_________lenghOfStrings = 8______________________________");
            lenghOfStrings = 8;
            OneLakhStringSort();
            System.out.println("_________lenghOfStrings = 10_____________________________");
            lenghOfStrings = 10;
            OneLakhStringSort();

            System.out.println("Task 03");

            //Task 03
            System.out.println("_________lenghOfStrings = 10____numberOfStrings = 1000____");
            numberOfStrings = 1000;
            lenghOfStrings = 10;
            EditDistance();
            System.out.println("_________lenghOfStrings = 20____numberOfStrings = 1000____");
            lenghOfStrings = 20;
            EditDistance();
            System.out.println("_________lenghOfStrings = 50____numberOfStrings = 1000____");
            lenghOfStrings = 50;
            EditDistance();
            System.out.println("_________lenghOfStrings = 100___numberOfStrings = 1000____");
            lenghOfStrings = 100;
            EditDistance();


            AppOn = false;
        }
    }

    /**
     * Running at the beginning of the program
     * Reduce the influence of CPU prediction and OS optimize
     */
    private static void MeaninglessLoop ()
    {
        int x1 = 1;
        int x2 = 1;
        int x3 = 0;
        ArrayList<Integer> fibo = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++)
        {
            x3 = x1 + x2;
            x1 = x2;
            x2 = x3;
            fibo.add(x3);
        }
    }

    /**
     * Compute the edit distance
     */
    private static void EditDistance ()
    {
        Sequences();
    }

    /**
     * Compute the edit distance
     */
    private static void Sequences ()
    {
        randomPairsOfWords = new RandomPairsOfWords(numberOfStrings, lenghOfStrings);
        firstRandomStrings = randomPairsOfWords.firstRandomStrings;
        secondRandomStrings = randomPairsOfWords.secondRandomStrings;
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        String firstWord = "";
        String secondWord = "";
        for (int i = 0; i < numberOfStrings; i++)
        {
            firstWord = firstRandomStrings[i];
            secondWord = secondRandomStrings[i];
            startTime = System.nanoTime();
            Sequences.editDistance(firstWord, secondWord);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 10;
        System.out.println(averageTime + "\t" + " Compute the edit distance Average Time");
    }

    /**
     * Sort 100000 random strings.
     */
    private static void OneLakhStringSort ()
    {
        MergeSortStrings();
        QuickSortStrings();
        HeapSortStrings();
        DualPivotQuickSortStrings();
        RadixSortStrings();
    }

    /**
     * MergeSortStrings
     */
    private static void MergeSortStrings ()
    {
        randomStrings = randomStringsGenerator.GenerateRandomStrings(numberOfStrings, lenghOfStrings);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 10; i++)
        {
            startTime = System.nanoTime();
            Sort.mergeSort(randomStrings);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 10;
        System.out.println(averageTime + "\t" + " MergeSortStrings Average Time");
    }

    /**
     * QuickSortStrings
     */
    private static void QuickSortStrings ()
    {
        randomStrings = randomStringsGenerator.GenerateRandomStrings(numberOfStrings, lenghOfStrings);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 10; i++)
        {
            startTime = System.nanoTime();
            Sort.quicksort(randomStrings);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 10;
        System.out.println(averageTime + "\t" + " QuickSortStrings Average Time");
    }

    /**
     * HeapSortStrings
     */
    private static void HeapSortStrings ()
    {
        randomStrings = randomStringsGenerator.GenerateRandomStrings(numberOfStrings, lenghOfStrings);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 10; i++)
        {
            startTime = System.nanoTime();
            Sort.heapsort(randomStrings);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 10;
        System.out.println(averageTime + "\t" + " HeapSortStrings Average Time");
    }

    /**
     * DualPivotQuickSortStrings
     */
    private static void DualPivotQuickSortStrings ()
    {
        randomStrings = randomStringsGenerator.GenerateRandomStrings(numberOfStrings, lenghOfStrings);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 10; i++)
        {
            startTime = System.nanoTime();
            Arrays.sort(randomStrings);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 10;
        System.out.println(averageTime + "\t" + " DualPivotQuickSortStrings Average Time");
    }

    /**
     * RadixSortStrings
     */
    private static void RadixSortStrings ()
    {
        randomStrings = randomStringsGenerator.GenerateRandomStrings(numberOfStrings, lenghOfStrings);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 10; i++)
        {
            startTime = System.nanoTime();
            RadixSort.radixSortA(randomStrings, lenghOfStrings);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 10;
        System.out.println(averageTime + "\t" + " RadixSortStrings Average Time");
    }


    /**
     * Sort 100000 random keys.
     */
    private static void OneLakhKeysSort ()
    {
        MergeSortKeys();
        QuickSortKeys();
        HeapSortKeys();
        DualPivotQuickSortKeys();
    }

    /**
     * MergeSortKeys
     */
    private static void MergeSortKeys ()
    {
        randomKeys = randomKeysGenerator.GenerateRandomKeys(numberOfKeys);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 100; i++)
        {
            startTime = System.nanoTime();
            Sort.mergeSort(randomKeys);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 100;
        System.out.println(averageTime + "\t" + " MergeSortKeys Average Time");
    }

    /**
     * QucikSort
     */
    private static void QuickSortKeys ()
    {
        randomKeys = randomKeysGenerator.GenerateRandomKeys(numberOfKeys);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 100; i++)
        {
            startTime = System.nanoTime();
            Sort.quicksort(randomKeys);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 100;
        System.out.println(averageTime + "\t" + " QuickSortKeys Average Time");
    }

    /**
     * HeapSortKeys
     */
    private static void HeapSortKeys ()
    {
        randomKeys = randomKeysGenerator.GenerateRandomKeys(numberOfKeys);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 100; i++)
        {
            startTime = System.nanoTime();
            Sort.heapsort(randomKeys);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 100;
        System.out.println(averageTime + "\t" + " HeapSortKeys Average Time");
    }

    /**
     * DualPivotQuickSortKeys
     */
    private static void DualPivotQuickSortKeys ()
    {
        randomKeys = randomKeysGenerator.GenerateRandomKeys(numberOfKeys);
        long startTime = 0;
        long endTime = 0;
        long averageTime = 0;
        for (int i = 0; i < 100; i++)
        {
            startTime = System.nanoTime();
            Arrays.sort(randomKeys);
            endTime = System.nanoTime();
            averageTime += (endTime - startTime);
        }
        averageTime /= 100;
        System.out.println(averageTime + "\t" + " DualPivotQuickSortKeys Average Time");
    }


}
