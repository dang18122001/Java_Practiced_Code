package com.examples.datastructure.array;

public class ArrayRotationCount {

    /*
    The findRotationCountMethod 1 and 2 do the following task:
        Consider an array of distinct numbers sorted in increasing order.
        The array has been rotated (clockwise) k number of times.
        Given such an array, find the value of k.
     Example:
        Input : arr[] = {15, 18, 2, 3, 6, 12}
        Output: 2
        Explanation : Initial array must be {2, 3, 6, 12, 15, 18}.
            We get the given array after rotating the initial array twice.
     */

    /*
    Method 1 is to find the index of the minimum element.
    The number of rotations is equal to index of the minimum element.
    The index of the minimum element is equal to the index of
        the maximum element + 1.
    If the index of the maximum element is equal to the maximum index
        of the array, then the index of the minimum element is 0.
    Because the time complexity of findPivot function is O(lg(n)) so the
        time complexity of this method is O(lg(n)).
    Space complexity: .
     */
    public int findRotationCountMethod1(int[] arr) throws Exception {

        // Check if the array is null or not.
        if (arr == null)
            throw new NullPointerException("Array is null!");

        // Check if the array is empty or not.
        int arrayLength = arr.length;
        if (arrayLength == 0)
            throw new Exception("Array is empty!");

        /*
        Call the findPivot method to find the index of
            biggest elements in the array.
         */
        ArraySearching obj = new ArraySearching();
        int indexOfMaxElement = obj.findPivot(arr, 0, arrayLength - 1);

        /*
        Check of the index of the maximum element is equal to
            the maximum index of the array.
         */
        // If it is true, return 0.
        if (indexOfMaxElement == arrayLength - 1)
            return 0;
        // If it is not true, return indexOfMaxElement + 1.
        else
            return indexOfMaxElement + 1;
    }

    /*
    Method 2 is to look for all elements in the array and find the index of the
        minimum element.
    The index of the minimum element is the number of rotations.
    Time complexity: O(n).
    Space complexity:
     */
    public int findRotationCountMethod2(int[] arr) throws Exception {

        // Check if the array is null or not.
        if (arr == null)
            throw new NullPointerException("Array is null!");

        // Check if the array is empty or not.
        int arrayLength = arr.length;
        if (arrayLength == 0)
            throw new Exception("Array is empty!");

        // Loop through the array and find the minimum element.
        int minimumValue = arr[0];
        int indexOfMinimumValue = 0;
        for (int i = 1; i < arrayLength; i++) {
            if (arr[i] < minimumValue) {
                minimumValue = arr[i];
                indexOfMinimumValue = i;
            }
        }

        // Return the index of the minimum element.
        return indexOfMinimumValue;
    }
}
