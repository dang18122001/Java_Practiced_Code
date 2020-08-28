package com.examples.datastructure.array;

public class ArraySearching {
    /*
    Searches an element key in a pivoted sorted array a[] of size n
    */
    public int searchInSorted_RotatedArrayMethod1(int a[], int n, int key) throws Exception {

        // Check if n is different from a.length
        if (n != a.length)
            throw new Exception("n is not the correct size of inputArray");

        int pivot = findPivot(a, 0, n - 1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(a, 0, n - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two sub_arrays around pivot
        if (a[pivot] == key)
            return pivot;
        if (a[0] <= key)
            return binarySearch(a, 0, pivot - 1, key);
        return binarySearch(a, pivot + 1, n - 1, key);
    }

    /*
    Function to get pivot.
    */
    public int findPivot(int a[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && a[mid] > a[mid + 1])
            return mid;
        if (mid > low && a[mid] < a[mid - 1])
            return (mid - 1);
        if (a[low] >= a[mid])
            return findPivot(a, low, mid - 1);
        return findPivot(a, mid + 1, high);
    }

    /* Standard Binary Search function */
    public int binarySearch(int a[], int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == a[mid])
            return mid;
        if (key > a[mid])
            return binarySearch(a, (mid + 1), high, key);
        return binarySearch(a, low, (mid - 1), key);
    }

    public int searchInSorted_RotatedArrayMethod2(int a[], int l, int h, int key) throws Exception {

        // Find middle point
        int mid = (l + h)/2;

        // If key is present at middle point, return mid.
        if (a[mid] == key)
            return mid;
    }
}
