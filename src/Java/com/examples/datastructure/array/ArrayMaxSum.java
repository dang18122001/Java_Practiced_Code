package com.examples.datastructure.array;

public class ArrayMaxSum {

    /*
    Method 1: Find all rotations one by one,
        check sum of every rotation and return the maximum sum.
    */
    public long findMaxSumOfRotatedArrayMethod1(int[] arr) throws Exception {

        int n = arr.length;
        if (n == 0)
            throw new Exception("Array is empty.");

        long maxSum = 0;
        ArrayRotation a = new ArrayRotation();

        for (int i = 0; i < n; i++) {
            a.rotateArrayMethod1(arr, 1, n);

            long sum = 0;
            for (int j = 0; j < n; j++)
                sum = sum + ((long) arr[j] * j);

            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;
    }

    /*
    Let us calculate initial value of i*arr[i] with no rotation
    R0 = 0*arr[0] + 1*arr[1] +...+ (n-1)*arr[n-1]

    After 1 rotation arr[n-1], becomes first element of array,
    arr[0] becomes second element, arr[1] becomes third element
    and so on.
    R1 = 0*arr[n-1] + 1*arr[0] +...+ (n-1)*arr[n-2]

    R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]

    After 2 rotations arr[n-2], becomes first element of array,
    arr[n-1] becomes second element, arr[0] becomes third element
    and so on.
    R2 = 0*arr[n-2] + 1*arr[n-1] +...+ (n-1)*arr[n-3]

    R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]

    If we take a closer look at above values, we can observe
    below pattern

    Rj - Rj-1 = arrSum - n * arr[n-j]

    Where arrSum is sum of all array elements, i.e.,

    arrSum = ∑ arr[i]
        0<=i<=n-1
     */
    public long findMaxSumOfRotatedArrayMethod2(int[] arr) throws Exception {

        if (arr == null)
            throw new NullPointerException("Array is null!");

        int n = arr.length;
        if (n == 0)
            throw new Exception("Array is empty!");

        int i;
        long sumOfElements = 0;
        long currVal = 0;
        for (i = 0; i < n; i++) {
            sumOfElements = sumOfElements + arr[i];
            currVal = currVal + ((long) arr[i] * i);
        }

        long maxSum = currVal;
        for (i = 1; i < n; i++) {
            currVal = ((long) arr[i - 1] * n) - sumOfElements + currVal;
            if (currVal > maxSum)
                maxSum = currVal;
        }

        return maxSum;
    }

    public int findMaxSumOfSortedRotatedArray(int[] arr) {
        int n = arr.length;

        int pivotIndex = findPivotOfSortedRotatedArray(arr);
        int diff = (n - 1) - pivotIndex;

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = maxSum + (((i + diff) % n) * arr[i]);
        }

        return maxSum;
    }

    public int findPivotOfSortedRotatedArray(int[] arr) {
        int n = arr.length;

        int pivotIndex = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] > arr[(i+1) % n]) {
                pivotIndex = i;
                break;
            }
        return pivotIndex;
    }

}
