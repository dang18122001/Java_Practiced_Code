package com.examples.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySearchingTest {

    @Test
    // Test with inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3} and key = 3
    void searchInSorted_RotatedArrayMethod1Test1() throws Exception {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int outputIndex = a.searchInSorted_RotatedArrayMethod1(inputArray, 9, key);
        assertEquals(8, outputIndex);
    }

    @Test
    // Test with inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3} and key = 30
    void searchInSorted_RotatedArrayMethod1Test2() throws Exception {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 30;
        int outputIndex = a.searchInSorted_RotatedArrayMethod1(inputArray, 9, key);
        assertEquals(-1, outputIndex);
    }

    @Test
    // Test with inputArray = {30, 40, 50, 10, 20} and key = 10
    void searchInSorted_RotatedArrayMethod1Test3() throws Exception {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {30, 40, 50, 10, 20};
        int key = 10;
        int outputIndex = a.searchInSorted_RotatedArrayMethod1(inputArray, 5, key);
        assertEquals(3, outputIndex);
    }

    @Test
    // Test n != inputArray.length
    void searchInSorted_RotatedArrayMethod1Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArraySearching a = new ArraySearching();
            int[] inputArray = {30, 40, 50, 10, 20};
            int key = 10;
            a.searchInSorted_RotatedArrayMethod1(inputArray, 8, key);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("n is not the correct size of inputArray"));
    }
}