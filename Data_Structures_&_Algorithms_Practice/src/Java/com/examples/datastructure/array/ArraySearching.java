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
    public int findPivot(int a[], int low, int high) throws Exception {

        if (high >= a.length || low >= a.length || low < 0 || high < 0)
            throw new Exception("wrong index input");
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

    /*
    1) Find middle point mid = (l + h)/2
    2) If key is present at middle point, return mid.
    3) Else If arr[l..mid] is sorted
        a) If key to be searched lies in range from arr[l]
        to arr[mid], recur for arr[l..mid].
        b) Else recur for arr[mid+1..h]
    4) Else (arr[mid+1..h] must be sorted)
        a) If key to be searched lies in range from arr[mid+1]
        to arr[h], recur for arr[mid+1..h].
        b) Else recur for arr[l..mid]
    */
    public int searchInSorted_RotatedArrayMethod2(int a[], int l, int h, int key) throws Exception {

        if (h >= a.length || l >= a.length || l < 0 || h < 0)
            throw new Exception("wrong input index");

        // When key is not in arr[]
        if (l > h)
            return -1;

        // Find middle point
        int mid = (l + h)/2;

        // If key is present at middle point, return mid.
        if (a[mid] == key)
            return mid;

        // Else If a[l..mid] is sorted
        else if (a[l] <= a[mid]) {
            // If key to be searched lies in range from arr[l]
            //        to arr[mid], recur for arr[l..mid].
            if (a[l] <= key && key < a[mid])
                return searchInSorted_RotatedArrayMethod2(a, l, mid - 1, key);
            // Else recur for arr[mid+1..h]
            return searchInSorted_RotatedArrayMethod2(a, mid + 1, h, key);
        }

        // Else (arr[mid+1..h] must be sorted)
        else {
            // If key to be searched lies in range from arr[mid+1]
            //        to arr[h], recur for arr[mid+1..h].
            if (a[mid + 1] <= key && key <= a[h])
                return searchInSorted_RotatedArrayMethod2(a, mid + 1, h, key);
            // Else recur for arr[l..mid]
            return searchInSorted_RotatedArrayMethod2(a, l, mid - 1, key);
        }
    }
}
