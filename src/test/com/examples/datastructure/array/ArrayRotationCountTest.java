package com.examples.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRotationCountTest {

    /*
    Tests for findRotationCountMethod1 in ArrayRotationCount.java.
     */
    @Test
        // Test with inputArray = {15, 18, 2, 3, 6, 12}.
    void findRotationCountMethod1Test1() throws Exception{
        ArrayRotationCount a = new ArrayRotationCount();
        int[] inputArray = {15, 18, 2, 3, 6, 12};
        int output = a.findRotationCountMethod1(inputArray);
        assertEquals(2, output);
    }

    @Test
        // Test with inputArray = {7, 9, 11, 12, 15}.
    void findRotationCountMethod1Test2() throws Exception{
        ArrayRotationCount a = new ArrayRotationCount();
        int[] inputArray = {7, 9, 11, 12, 15};
        int output = a.findRotationCountMethod1(inputArray);
        assertEquals(0, output);
    }

    @Test
        // Test with an empty inputArray.
    void findRotationCountMethod1Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotationCount a = new ArrayRotationCount();
            int[] inputArray = {};
            a.findRotationCountMethod1(inputArray);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is empty!"));
    }

    @Test
        // Test with a null inputArray.
    void findRotationCountMethod1Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotationCount a = new ArrayRotationCount();
            a.findRotationCountMethod1(null);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is null!"));
    }

    /*
    Tests for findRotationCountMethod2 in ArrayRotationCount.java.
     */
    @Test
    // Test with inputArray = {15, 18, 2, 3, 6, 12}.
    void findRotationCountMethod2Test1() throws Exception{
        ArrayRotationCount a = new ArrayRotationCount();
        int[] inputArray = {15, 18, 2, 3, 6, 12};
        int output = a.findRotationCountMethod2(inputArray);
        assertEquals(2, output);
    }

    @Test
        // Test with inputArray = {7, 9, 11, 12, 15}.
    void findRotationCountMethod2Test2() throws Exception{
        ArrayRotationCount a = new ArrayRotationCount();
        int[] inputArray = {7, 9, 11, 12, 15};
        int output = a.findRotationCountMethod2(inputArray);
        assertEquals(0, output);
    }

    @Test
        // Test with an empty inputArray.
    void findRotationCountMethod2Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotationCount a = new ArrayRotationCount();
            int[] inputArray = {};
            a.findRotationCountMethod2(inputArray);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is empty!"));
    }

    @Test
        // Test with a null inputArray.
    void findRotationCountMethod2Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotationCount a = new ArrayRotationCount();
            a.findRotationCountMethod2(null);
        }, "Exception not thrown");

        assertTrue(e.getMessage().contains("Array is null!"));
    }
}