package com.examples.datastructure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import java.util.Random;

class ArrayRotationTest {

    @org.junit.jupiter.api.Test
        // Test inputArray = null
    void rotateArrayMethod1_Test1() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {};
            a.rotateArrayMethod1(inputArray,2, 7);
        });
    }

    @Test
        // Test d is negative number
    void rotateArrayMethod1_Test2() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod1(inputArray,-5, 7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n is negative number
    void rotateArrayMethod1_Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod1(inputArray,2, -7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n != inputArray.length
    void rotateArrayMethod1_Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod1(inputArray,2, 5);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("n is not the correct size of inputArray"));
    }

    @Test
        // Test d < n
    void rotateArrayMethod1_Test5() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod1(inputArray,2, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d > n
    void rotateArrayMethod1_Test6() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod1(inputArray,9, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d = n
    void rotateArrayMethod1_Test7() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod1(inputArray,7, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test d = 0
    void rotateArrayMethod1_Test8() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod1(inputArray,0, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test n = 0
    void rotateArrayMethod1_Test9() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod1(inputArray,2, 0);
        });
    }

    @Test
        // Test n = 0
    void rotateArrayMethod1_Test10() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1};
        a.rotateArrayMethod1(inputArray,2, 1);
        assertEquals(1, inputArray[0]);
    }

    @org.junit.jupiter.api.Test
        // Test inputArray = null
    void rotateArrayMethod2_Test1() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {};
            a.rotateArrayMethod2(inputArray,2, 7);
        });
    }

    @Test
        // Test d is negative number
    void rotateArrayMethod2_Test2() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod2(inputArray,-5, 7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n is negative number
    void rotateArrayMethod2_Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod2(inputArray,2, -7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n != inputArray.length
    void rotateArrayMethod2_Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod2(inputArray,2, 5);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("n is not the correct size of inputArray"));
    }

    @Test
        // Test d < n
    void rotateArrayMethod2_Test5() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod2(inputArray,2, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d > n
    void rotateArrayMethod2_Test6() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod2(inputArray,9, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d = n
    void rotateArrayMethod2_Test7() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod2(inputArray,7, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test d = 0
    void rotateArrayMethod2_Test8() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod2(inputArray,0, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test n = 0
    void rotateArrayMethod2_Test9() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod2(inputArray,2, 0);
        });
    }

    @Test
        // Test n = 0
    void rotateArrayMethod2_Test10() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1};
        a.rotateArrayMethod2(inputArray,2, 1);
        assertEquals(1, inputArray[0]);
    }

    @org.junit.jupiter.api.Test
        // Test inputArray = null
    void rotateArrayMethod3_Test1() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {};
            a.rotateArrayMethod3(inputArray,2, 7);
        });
    }

    @Test
        // Test d is negative number
    void rotateArrayMethod3_Test2() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod3(inputArray,-5, 7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n is negative number
    void rotateArrayMethod3_Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod3(inputArray,2, -7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n != inputArray.length
    void rotateArrayMethod3_Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod3(inputArray,2, 5);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("n is not the correct size of inputArray"));
    }

    @Test
        // Test d < n
    void rotateArrayMethod3_Test5() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod3(inputArray,2, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d > n
    void rotateArrayMethod3_Test6() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod3(inputArray,9, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d = n
    void rotateArrayMethod3_Test7() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod3(inputArray,7, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test d = 0
    void rotateArrayMethod3_Test8() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod3(inputArray,0, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test n = 0
    void rotateArrayMethod3_Test9() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod3(inputArray,2, 0);
        });
    }

    @Test
        // Test n = 0
    void rotateArrayMethod3_Test10() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1};
        a.rotateArrayMethod3(inputArray,2, 1);
        assertEquals(1, inputArray[0]);
    }

    @org.junit.jupiter.api.Test
        // Test inputArray = null
    void rotateArrayMethod4_Test1() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {};
            a.rotateArrayMethod4(inputArray,2, 7);
        });
    }

    @Test
        // Test d is negative number
    void rotateArrayMethod4_Test2() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod4(inputArray,-5, 7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n is negative number
    void rotateArrayMethod4_Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod4(inputArray,2, -7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n != inputArray.length
    void rotateArrayMethod4_Test4() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod4(inputArray,2, 5);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("n is not the correct size of inputArray"));
    }

    @Test
        // Test d < n
    void rotateArrayMethod4_Test5() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod4(inputArray,2, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d > n
    void rotateArrayMethod4_Test6() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod4(inputArray,9, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d = n
    void rotateArrayMethod4_Test7() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod4(inputArray,7, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test d = 0
    void rotateArrayMethod4_Test8() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod4(inputArray,0, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test n = 0
    void rotateArrayMethod4_Test9() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod4(inputArray,2, 0);
        });
    }

    @Test
        // Test n = 1
    void rotateArrayMethod4_Test10() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1};
        a.rotateArrayMethod4(inputArray,2, 1);
        assertEquals(1, inputArray[0]);
    }

    /*
    Tests for swap method.
    */
    @Test
    // Test with an inputArray of n random elements.
    void swapTest1() {

        // Create inputArray with n random elements.
        int n = 100000000;
        int[] inputArray = new int[n];
        Random rand = new Random();
        for (int i = 0; i < inputArray.length; i++)
            inputArray[i] = rand.nextInt(1000);

        ArrayRotation a = new ArrayRotation();
        int d = rand.nextInt((n/2 -1) + 1);
        int firstElementOfFirstHalf = inputArray[0];
        int firstElementOfSecondHalf = inputArray[n - 1 -d];
        a.swap(inputArray, 0, n - 1 - d, d);

        assertEquals(firstElementOfFirstHalf, inputArray[n - 1 - d]);
        assertEquals(firstElementOfSecondHalf, inputArray[0]);
    }


    @org.junit.jupiter.api.Test
        // Test inputArray = null
    void rotateArrayMethod5_Test1() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {};
            a.rotateArrayMethod5(inputArray, 0, 2, 7);
        });
    }

    @Test
        // Test d is negative number
    void rotateArrayMethod5_Test2() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod5(inputArray, 0, -5, 7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test n is negative number
    void rotateArrayMethod5_Test3() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod5(inputArray, 0, 2, -7);
        }, "exception not thrown");

        assertTrue(e.getMessage().contains("input numbers cannot be negative"));
    }

    @Test
        // Test d < n
    void rotateArrayMethod5_Test5() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod5(inputArray, 0, 2, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d > n
    void rotateArrayMethod5_Test6() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod5(inputArray, 0, 9, 7);
        assertEquals(3, inputArray[0]);
        assertEquals(4, inputArray[1]);
        assertEquals(5, inputArray[2]);
        assertEquals(6, inputArray[3]);
        assertEquals(7, inputArray[4]);
        assertEquals(1, inputArray[5]);
        assertEquals(2, inputArray[6]);
    }

    @Test
        // Test d = n
    void rotateArrayMethod5_Test7() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod5(inputArray, 0, 7, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test d = 0
    void rotateArrayMethod5_Test8() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayMethod5(inputArray, 0, 0, 7);
        assertEquals(1, inputArray[0]);
        assertEquals(2, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(4, inputArray[3]);
        assertEquals(5, inputArray[4]);
        assertEquals(6, inputArray[5]);
        assertEquals(7, inputArray[6]);
    }

    @Test
        // Test n = 0
    void rotateArrayMethod5_Test9() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
            a.rotateArrayMethod5(inputArray, 0, 2, 0);
        });
    }

    @Test
        // Test n = 1
    void rotateArrayMethod5_Test10() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1};
        a.rotateArrayMethod5(inputArray, 0, 2, 1);
        assertEquals(1, inputArray[0]);
    }

    @Test
        // Test d = 1
    void rotateArrayMethod5_Test11() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 3, 5, 6, 2, 5};
        a.rotateArrayMethod5(inputArray, 0, 1, 8);
        assertEquals(2, inputArray[0]);
        assertEquals(3, inputArray[1]);
        assertEquals(3, inputArray[2]);
        assertEquals(5, inputArray[3]);
        assertEquals(6, inputArray[4]);
        assertEquals(2, inputArray[5]);
        assertEquals(5, inputArray[6]);
        assertEquals(1, inputArray[7]);
    }

    /*
    Tests for function rotateArrayByOne.
    */
    @org.junit.jupiter.api.Test
        // Test inputArray = null
    void rotateArrayByOne_Test1() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayRotation a = new ArrayRotation();
            int[] inputArray = {};
            a.rotateArrayByOne(inputArray);
        });
    }

    @Test
        // Test inputArray = {1, 2, 3, 4, 5, 6, 7}
    void rotateArrayByOne_Test2() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        a.rotateArrayByOne(inputArray);
        assertEquals(7, inputArray[0]);
        assertEquals(1, inputArray[1]);
        assertEquals(2, inputArray[2]);
        assertEquals(3, inputArray[3]);
        assertEquals(4, inputArray[4]);
        assertEquals(5, inputArray[5]);
        assertEquals(6, inputArray[6]);
    }

    @Test
        // Test inputArray = {15, 2, 37, 4, 45, 6, 78, 26}
    void rotateArrayByOne_Test3() throws Exception {
        ArrayRotation a = new ArrayRotation();
        int[] inputArray = {15, 2, 37, 4, 45, 6, 78, 26};
        a.rotateArrayByOne(inputArray);
        assertEquals(26, inputArray[0]);
        assertEquals(15, inputArray[1]);
        assertEquals(2, inputArray[2]);
        assertEquals(37, inputArray[3]);
        assertEquals(4, inputArray[4]);
        assertEquals(45, inputArray[5]);
        assertEquals(6, inputArray[6]);
        assertEquals(78, inputArray[7]);
    }
}