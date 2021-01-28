package com.examples.datastructure.array;

/*
Given an array that is sorted and then rotated around an unknown point.
Find if the array has a pair with a given sum ‘x’.
It may be assumed that all elements in the array are distinct.
 */
public class RotatedArraySumPair {
    /*
    To solve the problem:
        Step 1: Find the index of the smallest and biggest element in the array.
        Step 2: Use two-pointer technique to find the pair of element.
     */
    public int[] checkSumPair(int[] arr, int givenSum) throws Exception {
        boolean arrayHasPair = false;
        int[] foundElementPair = {-1, -1};

        // If arr has fewer than two elements, return [-1, -1]
        if (arr.length < 2) {
            return foundElementPair;
        }

        // Find indexes of biggest and smallest element of the array.
        ArraySearching arraySearching = new ArraySearching();
        int maxElementIndex = arraySearching.findPivot(arr, 0, arr.length - 1);
        int minElementIndex = 0;
        if (maxElementIndex != arr.length - 1) {
            minElementIndex = maxElementIndex + 1;
        }

        // If the givenSum <= the smallest element in the array, return [-1, -1].
        if (givenSum <= arr[minElementIndex]) {
            return foundElementPair;
        }

        /*
         If the givenSum > the sum of the biggest and the second biggest element in the array,
         return [-1, -1]
         */
        if (maxElementIndex == 0) {
            if (givenSum > (arr[maxElementIndex] + arr[arr.length - 1])) {
                return foundElementPair;
            }
        } else {
            if (givenSum > (arr[maxElementIndex] + arr[maxElementIndex - 1])) {
                return foundElementPair;
            }
        }

        // Start two-pointer technique at two min and max indexes.
        while (minElementIndex != maxElementIndex) {
            // If givenSum = the sum of current pair, break the loop.
            if (givenSum == (arr[minElementIndex] + arr[maxElementIndex])) {
                arrayHasPair = true;
                break;
            }

            /*
             If the sum is smaller than the sum of the current pair element,
             move maxElementIndex pointer to the left to decrease the current sum.
             */
            else if (givenSum < (arr[minElementIndex] + arr[maxElementIndex])) {
                if (maxElementIndex == 0) {
                    maxElementIndex = arr.length - 1;
                } else {
                    maxElementIndex -= 1;
                }
            }

            /*
             If the sum is greater than the sum of the current pair element,
             move minElementIndex to the right to increase the current sum.
             */
            else {
                if (minElementIndex == arr.length - 1) {
                    minElementIndex = 0;
                } else {
                    minElementIndex += 1;
                }
            }
        }

        // Print the result;
        if (arrayHasPair) {
            foundElementPair[0] = arr[minElementIndex];
            foundElementPair[1] = arr[maxElementIndex];
        }

        return foundElementPair;
    }
}
