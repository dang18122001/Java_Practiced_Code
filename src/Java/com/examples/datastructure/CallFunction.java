package com.examples.datastructure;

import com.examples.datastructure.list.LinkedListDuplicationRemove;
import com.examples.datastructure.list.LinkedListMethod;

public class CallFunction {
    public static void main(String[] args) throws Exception {
//        LinkedListSearch listSearcher = new LinkedListSearch();
//        LinkedListMethod list = listSearcher.createList(1000);

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Which method? ");
//        int methodNumber = scanner.nextInt();
//        long startTime, endTime;
//
//        while (methodNumber == 1 || methodNumber == 2) {
//            LinkedListMethod.Node head = list.getHead();
//            startTime = System.nanoTime();
//            System.out.println(startTime);
//            if (methodNumber == 1) {
//                System.out.println("Method 1: " + listSearcher.searchLinkedListMethod1(head, 101));
//            } else {
//                System.out.println("Method 1: " + listSearcher.searchLinkedListMethod2(head, 0, 101));
//            }
//            endTime = System.nanoTime();
//            System.out.println(endTime);
//            System.out.println("Run time: " + (endTime - startTime)/1000 + " Millisecond");
//
//            System.out.print("Which method? ");
//            methodNumber = scanner.nextInt();
//        }
//
//        LinkedListMethod.Node head = list.getHead();
//        System.out.println(listSearcher.searchNthNodeMethod2(head, 0, 1500));

//        LinkedListMethod.Node head = list.getHead();
//        System.out.println(listSearcher.searchNthNodeFromEndMethod1(head, 1));

        LinkedListMethod smallList = new LinkedListMethod();
        smallList.linkedListAppend(5);
        smallList.linkedListAppend(5);
        smallList.linkedListAppend(5);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(18);
        smallList.linkedListAppend(loopedNode);
        smallList.linkedListAppend(21);
        smallList.linkedListAppend(21);
        smallList.linkedListAppend(38);
        smallList.linkedListAppend(38);
        smallList.linkedListAppend(42);
        smallList.linkedListAppend(44);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(44);
        smallList.linkedListAppend(finalNode);
        LinkedListMethod.Node head = smallList.getHead();

        LinkedListDuplicationRemove duplicationRemover = new LinkedListDuplicationRemove();
        duplicationRemover.removeDuplicatesInSortedLinkedListMethod3(head);
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }
}
