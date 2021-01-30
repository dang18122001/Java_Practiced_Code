package com.examples.datastructure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatedArraySumPairTest {

    @Test
    /*
    Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
    Output: [6, 16]
     */
    void checkSumPairTest1() throws Exception {
        int[] arr = {11, 15, 6, 8, 9, 10};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 16);
        assertEquals(6, result[0]);
        assertEquals(10, result[1]);
    }

    @Test
    /*
    Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
    Output: [9, 29]
     */
    void checkSumPairTest2() throws Exception {
        int[] arr = {11, 15, 26, 38, 9, 10};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 35);
        assertEquals(9, result[0]);
        assertEquals(26, result[1]);
    }

    @Test
    /*
    Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
    Output: [-1, -1]
     */
    void checkSumPairTest3() throws Exception {
        int[] arr = {11, 15, 26, 38, 9, 10};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 45);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

    @Test
    /*
    Input: arr[] = {10, 11, 15, 26, 38, 9}, x = 35
    Output: [9, 26]
     */
    void checkSumPairTest4() throws Exception {
        int[] arr = {10, 11, 15, 26, 38, 9};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 35);
        assertEquals(9, result[0]);
        assertEquals(26, result[1]);
    }

    @Test
    /*
    Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 8
    Output: [-1, -1]
     */
    void checkSumPairTest5() throws Exception {
        int[] arr = {11, 15, 26, 38, 9, 10};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 8);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

    @Test
    /*
    Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 65
    Output: [-1, -1]
     */
    void checkSumPairTest6() throws Exception {
        int[] arr = {11, 15, 26, 38, 9, 10};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 65);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

    @Test
    /*
    Input: arr[] = {38, 9, 10, 11, 15, 26}, x = 65
    Output: [-1, -1]
     */
    void checkSumPairTest7() throws Exception {
        int[] arr = {38, 9, 10, 11, 15, 26};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 65);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

    @Test
    /*
    Input: arr[] = {38}, x = 38
    Output: [-1, -1]
     */
    void checkSumPairTest8() throws Exception {
        int[] arr = {38};
        RotatedArraySumPair sumPairChecker = new RotatedArraySumPair();
        int[] result = sumPairChecker.checkSumPair(arr, 38);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }
}