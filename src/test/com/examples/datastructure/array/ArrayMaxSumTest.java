package com.examples.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayMaxSumTest {

    @Test
    // Test with inputArray = {1, 20, 2, 10}.
    void findMaxSumOfRotatedArrayMethod1Test1() throws Exception{
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {1, 20, 2, 10};
        long ouputNumber = a.findMaxSumOfRotatedArrayMethod1(inputArray);
        assertEquals(72, ouputNumber);
    }

    @Test
        // Test with inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
    void findMaxSumOfRotatedArrayMethod1Test2() throws Exception{
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long ouputNumber = a.findMaxSumOfRotatedArrayMethod1(inputArray);
        assertEquals(330, ouputNumber);
    }

    @Test
        // Test with inputArray = {}.
    void findMaxSumOfRotatedArrayMethod1Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayMaxSum a = new ArrayMaxSum();
            int[] inputArray = {};
            a.findMaxSumOfRotatedArrayMethod1(inputArray);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is empty."));
    }

    @Test
    // Test with input is an Array of 1000 random elements.
    void findMaxSumOfRotatedArrayMethod1And2Test5() throws Exception {

        // Create inputArray with 1000 random elements.
        int[] inputArray = new int[9000];
        Random rand = new Random();
        for (int i = 0; i < inputArray.length; i++)
            inputArray[i] = rand.nextInt(1000);

        ArrayMaxSum a = new ArrayMaxSum();

        long startTimeMethod1 = System.nanoTime();
        long outputMethod1 = a.findMaxSumOfRotatedArrayMethod1(inputArray);
        long endTimeMethod1 = System.nanoTime();
        long durationMethod1 = (endTimeMethod1 - startTimeMethod1);
        System.out.println(durationMethod1);

        long startTimeMethod2 = System.nanoTime();
        long outputMethod2 = a.findMaxSumOfRotatedArrayMethod2(inputArray);
        long endTimeMethod2 = System.nanoTime();
        long durationMethod2 = (endTimeMethod2 - startTimeMethod2);
        System.out.println(durationMethod2);

        assertTrue(durationMethod1 > durationMethod2);
        assertEquals(outputMethod2, outputMethod1);
    }

    @Test
        // Test with inputArray = {1, 20, 2, 10}.
    void findMaxSumOfRotatedArrayMethod2Test1() throws Exception {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {1, 20, 2, 10};
        long ouputNumber = a.findMaxSumOfRotatedArrayMethod2(inputArray);
        assertEquals(72, ouputNumber);
    }

    @Test
        // Test with inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
    void findMaxSumOfRotatedArrayMethod2Test2() throws Exception {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long ouputNumber = a.findMaxSumOfRotatedArrayMethod2(inputArray);
        assertEquals(330, ouputNumber);
    }

    @Test
        // Test with inputArray = {}.
    void findMaxSumOfRotatedArrayMethod2Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayMaxSum a = new ArrayMaxSum();
            int[] inputArray = {};
            a.findMaxSumOfRotatedArrayMethod2(inputArray);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is empty!"));
    }

    @Test
        // Test with inputArray = null.
    void findMaxSumOfRotatedArrayMethod2Test4() {
        Exception e = Assertions.assertThrows(NullPointerException.class, () -> {
            ArrayMaxSum a = new ArrayMaxSum();
            int[] inputArray = null;
            a.findMaxSumOfRotatedArrayMethod2(inputArray);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is null!"));
    }


    @Test
        // Test with inputArray = {2, 3, 4, 1}.
    void findPivotOfSortedRotatedArrayTest1() {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {2, 3, 4, 1};
        int ouputNumber = a.findPivotOfSortedRotatedArray(inputArray);
        assertEquals(2, ouputNumber);
    }

    @Test
        // Test with inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
    void findPivotOfSortedRotatedArrayTest2() {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int ouputNumber = a.findPivotOfSortedRotatedArray(inputArray);
        assertEquals(0, ouputNumber);
    }

    @Test
        // Test with inputArray = {}.
    void findPivotOfSortedRotatedArrayTest3() {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {};
        int ouputNumber = a.findPivotOfSortedRotatedArray(inputArray);
        assertEquals(0, ouputNumber);
    }

    @Test
        // Test with inputArray = {2, 3, 4, 1}.
    void findMaxSumOfSortedRotatedArrayTest1() {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {2, 3, 4, 1};
        int ouputNumber = a.findMaxSumOfSortedRotatedArray(inputArray);
        assertEquals(20, ouputNumber);
    }

    @Test
        // Test with inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
    void findMaxSumOfSortedRotatedArrayTest2() {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int ouputNumber = a.findMaxSumOfSortedRotatedArray(inputArray);
        assertEquals(330, ouputNumber);
    }

    @Test
        // Test with inputArray = {}.
    void findMaxSumOfSortedRotatedArrayTest3() {
        ArrayMaxSum a = new ArrayMaxSum();
        int[] inputArray = {};
        int ouputNumber = a.findMaxSumOfSortedRotatedArray(inputArray);
        assertEquals(0, ouputNumber);
    }
}