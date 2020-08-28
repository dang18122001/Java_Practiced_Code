package com.examples.datastructure.array;

public class ArrayRotation {

    /*
        Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
    */
    public void rotateArrayMethod1(int[] a, int d , int n) throws Exception {

        // Check if d, or n is negative number
        if (d < 0 | n < 0)
            throw new Exception("input numbers cannot be negative");

        // Check if n is different from a.length
        if (n != a.length)
            throw new Exception("n is not the correct size of inputArray");

        if (d != n)
            d = d % n;
        else
            return;

        int[] temp = new int[d];

        // Store first d elements of array into temp.
        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        // Change value of elements from 0 to n-d-1.
        for (int i = 0; i < (n-d); i++) {
            a[i] = a[i + d];
        }

        // Change the value of other elements.
        for (int i = 0; i < d; i++) {
            a[n - d + i] = temp[i];
        }
    }

    public void rotateArrayMethod2(int[] a, int d , int n) throws Exception {
        // Check if d, or n is negative number
        if (d < 0 || n < 0)
            throw new Exception("input numbers cannot be negative");

        // Check if n is different from a.length
        if (n != a.length)
            throw new Exception("n is not the correct size of inputArray");

        if (d != n)
            d = d % n;
        else
            return;

        for (int i = 0; i < d; i++)
            leftRotateByOne(a, n);
    }

    public void leftRotateByOne(int a[], int n) {
        int i, temp;
        temp = a[0];
        for (i = 0; i < n - 1; i++)
            a[i] = a[i + 1];
        a[i] = temp;
    }

    public void rotateArrayMethod3(int[] a, int d , int n) throws Exception {
        // Check if d, or n is negative number
        if (d < 0 || n < 0)
            throw new Exception("input numbers cannot be negative");

        // Check if n is different from a.length
        if (n != a.length)
            throw new Exception("n is not the correct size of inputArray");

        if (d != n)
            d = d % n;
        else
            return;

        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = a[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                a[j] = a[k];
                j = k;
            }
            a[j] = temp;
            for (int m = 0; m < a.length; m++) {
                System.out.print(a[m] + " ");
            }
            System.out.println();
        }
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public void rotateArrayMethod4(int[] a, int d , int n) throws Exception {
        // Check if d, or n is negative number
        if (d < 0 || n < 0)
            throw new Exception("input numbers cannot be negative");

        // Check if n is different from a.length
        if (n != a.length)
            throw new Exception("n is not the correct size of inputArray");

        if (d != n)
            d = d % n;
        else
            return;

        if (d == 0)
            return;

        reverseArray(a, 0, d - 1);
        reverseArray(a, d, n - 1);
        reverseArray(a, 0, n - 1);
    }

    /*Function to reverse arr[] from index start to end*/
    public void reverseArray(int a[], int start, int end) {
        int temp;
        while (start < end) {
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateArrayMethod5(int[] a, int index, int d , int n) throws Exception {
        // Check if d, or n is negative number
        if (d < 0 || n < 0)
            throw new Exception("input numbers cannot be negative");

        if (d != n)
            d = d % n;
        else
            return;

        if (d == 0 )
            return;

        if (d < n - d) {
            swap(a, index, n - d + index, d);
            rotateArrayMethod5(a, index, d, n-d);
        }
        else if (d > n - d) {
            swap(a, index, d, n - d);
            rotateArrayMethod5(a, n - d + index, 2 * d - n, d);
        }
        else
            swap(a, index, n - d + index, d);
        // Create A : a[0,d-1], B: a[d,n-1]
        // Case: A is shorter than B:
        // if d < n-d then
            // B: Bl: a[d,n-d-1] and Br: a[n-d,n-1]
            // Swap A with Br: swap(a, index, n-d+index, d)
            // Recur on B: BrBl  method5(a, index, d, n-d)
        // Case: A is longer than B:
        // else if d > n-d then
            // A: Al: a[0,n-d-1] and Ar: a[n-d,d-1]
            // Swap B with Al: swap(a, index, d, n-d)
            // Recur on A: ArAl  method5(a[n-d,n-1], n-d+index, 2 * d - n, d)
        // Case A = B
        //else
            // swap A with B: swap(a, index, n-d+index, d)

    }

    //This function swaps d elements starting at index fi with d elements starting at index si.
    public void swap(int a[], int fi, int si, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[fi + i];
            a[fi + i] = a[si + i];
            a[si + i] = temp;
        }
    }

    // This function is used to cyclically rotate an array by one
    public void rotateArrayByOne(int[] a) {
        // Store last element in a variable say x.
        int x = a[a.length - 1], i;
        // Shift all elements one position ahead.
        for (i = a.length - 1; i > 0; i--)
            a[i] = a[i - 1];
        // Replace first element of array with x.
        a[0] = x;
    }

}


