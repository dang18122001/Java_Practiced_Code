package com.examples.datastructure.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListLoopTest {

    @Test
    /*
    Test with a linked list that has one loop.
    Expected output: true;
     */
    void detectLoopInLinkedListMethod1Test1() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(7);
        list.linkedListAppend(9);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(11);
        list.linkedListAppend(finalNode);
        finalNode.setNext(loopedNode);

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        boolean result = loopDetector.detectLoopInLinkedListMethod1(head);

        assertTrue(result);
    }

    @Test
    /*
    Test with a linked list that has no loop.
    Expected output: false;
     */
    void detectLoopInLinkedListMethod1Test2() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(7);
        list.linkedListAppend(9);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(11);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        boolean result = loopDetector.detectLoopInLinkedListMethod1(head);

        assertFalse(result);
    }

    @Test
    /*
    Test with an empty linked list
    Expected output: false;
     */
    void detectLoopInLinkedListMethod1Test3() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        boolean result = loopDetector.detectLoopInLinkedListMethod1(head);

        assertFalse(result);
    }

    @Test
    /*
    Test with a linked list that has one loop.
    Expected output: true;
     */
    void detectLoopInLinkedListMethod2Test1() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(7);
        list.linkedListAppend(9);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(11);
        list.linkedListAppend(finalNode);
        finalNode.setNext(loopedNode);

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        boolean result = loopDetector.detectLoopInLinkedListMethod2(head);

        assertTrue(result);
    }

    @Test
    /*
    Test with a linked list that has no loop.
    Expected output: false;
     */
    void detectLoopInLinkedListMethod2Test2() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(7);
        list.linkedListAppend(9);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(11);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        boolean result = loopDetector.detectLoopInLinkedListMethod2(head);

        assertFalse(result);
    }

    @Test
    /*
    Test with an empty linked list
    Expected output: false;
     */
    void detectLoopInLinkedListMethod2Test3() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        boolean result = loopDetector.detectLoopInLinkedListMethod2(head);

        assertFalse(result);
    }

    @Test
    /*
    Test with a linked list that has one loop.
    Expected output: 7;
     */
    void detectAndCountLoopTest1() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(7);
        list.linkedListAppend(9);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(11);
        list.linkedListAppend(finalNode);
        finalNode.setNext(loopedNode);

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        int result = loopDetector.detectAndCountLoop(head);

        assertEquals(7, result);
    }

    @Test
    /*
    Test with a linked list that has no loop.
    Expected output: -1;
     */
    void detectAndCountLoopTest2() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(7);
        list.linkedListAppend(9);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(11);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        int result = loopDetector.detectAndCountLoop(head);

        assertEquals(-1, result);
    }

    @Test
    /*
    Test with an empty linked list
    Expected output: -1;
     */
    void detectAndCountLoopTest3() {
        // Create a linked list with a loop.
        LinkedListMethod list = new LinkedListMethod();

        LinkedListMethod.Node head = list.getHead();
        LinkedListLoop loopDetector = new LinkedListLoop();
        int result = loopDetector.detectAndCountLoop(head);

        assertEquals(-1, result);
    }
}