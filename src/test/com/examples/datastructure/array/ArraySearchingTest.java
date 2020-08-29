package com.examples.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySearchingTest {

    /*
    Tests for function binarySearch
    */
    @Test
    // Test with inputArray = {1, 2, 3, 4, 5, 6, 7}, low = 0, high = 6 and key = 5.
    void binarySearchTest1() {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        int outputIndex = a.binarySearch(inputArray, 0, 6, 5);
        assertEquals(4, outputIndex);
    }

    @Test
    // Test with inputArray = {1, 2, 3, 4, 5, 6, 7}, low = 0, high = 6 and key = 15.
    void binarySearchTest2() {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        int outputIndex = a.binarySearch(inputArray, 0, 6, 15);
        assertEquals(-1, outputIndex);
    }

    @Test
    // Test with inputArray = {1, 2, 3, 6, 9, 15, 48}, low = 4, high = 6 and key = 9.
    void binarySearchTest3() {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {1, 2, 3, 6, 9, 15, 48};
        int outputIndex = a.binarySearch(inputArray, 4, 6, 9);
        assertEquals(4, outputIndex);
    }

    /*
    Tests for function findPivot.
    */
    @Test
    // Test with inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3}, low = 0, high = 8.
    void findPivotTest1() throws Exception {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int outputIndex = a.findPivot(inputArray, 0, 8);
        assertEquals(5, outputIndex);
    }

    @Test
    // Test with inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3}, low = 0, high = 4.
    void findPivotTest2() throws Exception {
        ArraySearching a = new ArraySearching();
        int[] inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int outputIndex = a.findPivot(inputArray, 0, 4);
        assertEquals(-1, outputIndex);
    }

    @Test
    // Test with low < 0
    void findPivotTest3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArraySearching a = new ArraySearching();
            int[] inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3};
            int outputIndex = a.findPivot(inputArray, -5, 8);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("wrong index input"));
    }

    @Test
        // Test with low >= inputArray.length
    void findPivotTest4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArraySearching a = new ArraySearching();
            int[] inputArray = {5, 6, 7, 8, 9, 10, 1, 2, 3};
            int outputIndex = a.findPivot(inputArray, 10, 8);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("wrong index input"));
    }

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