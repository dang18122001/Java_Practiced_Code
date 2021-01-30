package com.examples.datastructure.array;

public class LeftRotationsFind {
//    /*
//    Given an array of size n and multiple values around which we need to left rotate the array.
//    How to quickly find multiple left rotations?
//     */
//    public int[][] findLeftRotations(int[] arr, int[] rotateTimes) {
//        /*
//        To solve the problem:
//        Step 1: Create a temp array which is a clone of two times of the given array.
//        Step 2: Find the startingIndex of the rotated array = rotateTime % arr.length.
//        Step 3: Look for the rotated array from the temp array with the known startingIndex.
//         */
//        // Create temp array.
//        int[] temp = new int[arr.length * 2];
//        for (int i = 0; i <= (2 * arr.length - 1); i++) {
//            temp[i] = arr[i];
//            temp[i + arr.length] = arr[i];
//        }
//
//        // Find the startingIndexes.
//        int[] startingIndexes = new int[rotateTimes.length];
//        for (int i = 0; i <= rotateTimes.length - 1; i++) {
//            startingIndexes[i] = rotateTimes[i] % arr.length;
//        }
//
//        // Find the rotated arrays.
//        int[][] rotatedArrays = new int[arr.length][rotateTimes.length];
//        for (int i = 0; i <= rotateTimes.length - 1; i++) {
//            for (int j = 0; j <= arr.length - 1; j++) {
//
//            }
//        }
//    }
}
