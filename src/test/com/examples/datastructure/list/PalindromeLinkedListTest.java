package com.examples.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    /*
    Test with a palindrome linked list.
    Expected output: true.
     */
    void checkPalindromeLinkedListMethod1Test1() throws Exception {
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(2);
        list.linkedListAppend(8);
        list.linkedListAppend(12);
        list.linkedListAppend(14);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(5);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        boolean result = palindromeChecker.checkPalindromeLinkedListMethod1(head);

        assertTrue(result);
    }

    @Test
    /*
    Test with a linked list that is not palindrome.
    Expected output: false.
     */
    void checkPalindromeLinkedListMethod1Test2() throws Exception {
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(11);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(2);
        list.linkedListAppend(8);
        list.linkedListAppend(12);
        list.linkedListAppend(14);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(5);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        boolean result = palindromeChecker.checkPalindromeLinkedListMethod1(head);

        assertFalse(result);
    }

    @Test
    /*
    Check with an empty list.
    Expected output: Error: The list is empty!
     */
    void checkPalindromeLinkedListMethod1Test3() {
        Exception e = Assertions.assertThrows(Exception.class, ()->{
            LinkedListMethod list = new LinkedListMethod();
            LinkedListMethod.Node head = list.getHead();
            PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
            palindromeChecker.checkPalindromeLinkedListMethod1(head);
        }, "Exception not thrown!");

        assertEquals("The list is empty!", e.getMessage());
    }

    @Test
    /*
    Test with a linked list: 1, 2, 3, 4, 5.
    Expected output: 5, 4, 3, 2, 1.
     */
    void reverseLinkedListTest1() throws Exception{
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(1);
        list.linkedListAppend(2);
        list.linkedListAppend(3);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(4);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(5);

        LinkedListMethod.Node head = list.getHead();
        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        LinkedListMethod.Node newHead = palindromeChecker.reverseLinkedList(head);

        int data = 5;
        while (newHead != null) {
            assertEquals(data, newHead.getData());
            newHead = newHead.getNext();
            data--;
        }
    }

    @Test
    /*
    Test with an empty list.
    Expected output: Error("The list is empty!")
     */
    void reverseLinkedListTest2() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            LinkedListMethod list = new LinkedListMethod();
            LinkedListMethod.Node head = list.getHead();
            PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
            palindromeChecker.reverseLinkedList(head);
        }, "Exception not thrown!");

        assertEquals("The list is empty!", e.getMessage());
    }

    @Test
    /*
    Test with a list that have only one element: {1}
    Expected output: {1}.
     */
    void reverseLinkedListTest3() throws Exception{
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(1);
        LinkedListMethod.Node head = list.getHead();
        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        LinkedListMethod.Node newHead = palindromeChecker.reverseLinkedList(head);

        assertEquals(1, newHead.getData());
        assertNull(newHead.getNext());
    }

    @Test
    /*
    Test with a palindrome linked list.
    Expected output: true.
     */
    void checkPalindromeLinkedListMethod2Test1() throws Exception {
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(12);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(2);
        list.linkedListAppend(8);
        list.linkedListAppend(12);
        list.linkedListAppend(14);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(5);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        boolean result = palindromeChecker.checkPalindromeLinkedListMethod2(head);

        assertTrue(result);
    }

    @Test
    /*
    Test with a linked list that is not palindrome.
    Expected output: false.
     */
    void checkPalindromeLinkedListMethod2Test2() throws Exception {
        LinkedListMethod list = new LinkedListMethod();
        list.linkedListAppend(5);
        list.linkedListAppend(14);
        list.linkedListAppend(11);
        LinkedListMethod.Node loopedNode = new LinkedListMethod.Node(8);
        list.linkedListAppend(loopedNode);
        list.linkedListAppend(2);
        list.linkedListAppend(2);
        list.linkedListAppend(8);
        list.linkedListAppend(12);
        list.linkedListAppend(14);
        LinkedListMethod.Node finalNode = new LinkedListMethod.Node(5);
        list.linkedListAppend(finalNode);

        LinkedListMethod.Node head = list.getHead();
        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        boolean result = palindromeChecker.checkPalindromeLinkedListMethod2(head);

        assertFalse(result);
    }

    @Test
    /*
    Check with an empty list.
    Expected output: Error: The list is empty!
     */
    void checkPalindromeLinkedListMethod2Test3() {
        Exception e = Assertions.assertThrows(Exception.class, ()->{
            LinkedListMethod list = new LinkedListMethod();
            LinkedListMethod.Node head = list.getHead();
            PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
            palindromeChecker.checkPalindromeLinkedListMethod1(head);
        }, "Exception not thrown!");

        assertEquals("The list is empty!", e.getMessage());
    }
}