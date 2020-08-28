package com.examples.datastructure;

import com.examples.datastructure.array.ArrayRotation;
import com.examples.datastructure.array.ArraySearching;

public class CallFunction {
    public static void main(String[] args) throws Exception {

        ArrayRotation a = new ArrayRotation();
        ArraySearching b = new ArraySearching();
//
//        //Create input array
        int[] inputArray = {4, 5, 6, 7, 1, 2, 3};
//        a.rotateArrayByOne(inputArray);
//        // Run function ArrayRotation1
////        int[] array1 = a.rotateArrayMethod1(inputArray, d, 7);
////        for (int i = 0; i < array1.length; i++)
////            System.out.print(array1[i] + " ");
////
//        System.out.println();
        int outputNumber = b.searchInSorted_RotatedArrayMethod1(inputArray, 7, 12);
        System.out.println(outputNumber);
//        for (int i = 0; i < inputArray.length; i++)
//            System.out.print(inputArray[i] + " ");
//
//        System.out.println(c);
//        System.out.println(d);

    }
}
