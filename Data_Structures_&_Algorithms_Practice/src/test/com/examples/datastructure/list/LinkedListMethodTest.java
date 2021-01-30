package com.examples.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListMethodTest {

    @Test
    void linkedListPushTest() {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with push method.
        testList.linkedListPush(testList, 3);
        testList.linkedListPush(testList, 2);
        testList.linkedListPush(testList, 1);
        testList.linkedListPush(testList, 0);

        // Store the head to the currNode.
        LinkedListMethod.Node currNode = testList.getHead();

        // Check the list.
        for (int i = 0; currNode != null; i++) {
            // Check the data of the currNode.
            assertEquals(i, currNode.data);

            // Move to the next node.
            currNode = currNode.next;
        }
    }

    @Test
    void linkedListInsertMiddleTest1() throws Exception {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with push method.
        testList.linkedListPush(testList, 3);
        testList.linkedListPush(testList, 2);
        testList.linkedListPush(testList, 1);
        testList.linkedListPush(testList, 0);

        // Insert 4 to index 1.
        testList.linkedListInsertMiddle(testList, 1, 4);

        // Insert 5 to index 3.
        testList.linkedListInsertMiddle(testList, 3, 5);

        // Store the head to the currNode.
        LinkedListMethod.Node currNode = testList.getHead();

        // Create index to store the index of currNode.
        int index = 0;

        // Check the testList.
        while (currNode != null) {
            // Check index 1.
            if (index == 1)
                assertEquals(4, currNode.data);

            // Check index = 3.
            if (index == 3)
                assertEquals(5, currNode.data);

            // Move to the next node.
            currNode = currNode.next;

            // Keep track of the index.
            index ++;
        }
    }

    @Test
    // Test the insert method with index out of range.
    void linkedListInsertMiddleTest2() {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with push method.
        testList.linkedListPush(testList, 3);
        testList.linkedListPush(testList, 2);
        testList.linkedListPush(testList, 1);
        testList.linkedListPush(testList, 0);

        Exception e = Assertions.assertThrows(Exception.class, () ->
                testList.linkedListInsertMiddle(testList, 4, 5), "Exception not thrown!");

        assertEquals("Index is out of range!", e.getMessage());
    }

    @Test
    void linkedListAppendTest() {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with append method.
        testList.linkedListAppend(0);
        testList.linkedListAppend(1);
        testList.linkedListAppend(2);
        testList.linkedListAppend(3);

        // Store the head to the currNode.
        LinkedListMethod.Node currNode = testList.getHead();

        // Check the list.
        for (int i = 0; currNode != null; i++) {
            // Check the data of the currNode.
            assertEquals(i, currNode.data);

            // Move to the next node.
            currNode = currNode.next;
        }
    }

    @Test
    void deleteByKeyTest1() throws Exception {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with append method.
        testList.linkedListAppend(0);
        testList.linkedListAppend(1);
        testList.linkedListAppend(2);
        testList.linkedListAppend(3);

        // Delete 1 and 3 in the list.
        testList.deleteByKey(testList, 1);
        testList.deleteByKey(testList, 3);

        // Store the head to the currNode.
        LinkedListMethod.Node currNode = testList.getHead();

        // Check the list.
        for (int i = 0; currNode != null; i += 2) {
            // Check the data of the currNode.
            assertEquals(i, currNode.data);

            // Move to the next node.
            currNode = currNode.next;
        }
    }

    @Test
    // Test the deleteByKey method with a key that cannot be found.
    void deleteByKeyTest2() {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with append method.
        testList.linkedListAppend(0);
        testList.linkedListAppend(1);
        testList.linkedListAppend(2);
        testList.linkedListAppend(3);

        // Delete 5 in the list.
        Exception e = Assertions.assertThrows(Exception.class, () ->
                testList.deleteByKey(testList, 5), "Exception not thrown!");

        assertEquals("The key cannot be found!", e.getMessage());
    }

    @Test
    void deleteAtPositionTest1() throws Exception {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with append method.
        testList.linkedListAppend(0);
        testList.linkedListAppend(1);
        testList.linkedListAppend(2);
        testList.linkedListAppend(3);

        // Delete the node at position 1.
        testList.deleteAtPosition(testList, 1);

        // The list is now {0, 2, 3}. Delete the node at position 2.
        testList.deleteAtPosition(testList, 2);

        // Store the head to the currNode.
        LinkedListMethod.Node currNode = testList.getHead();

        // Check the list.
        for (int i = 0; currNode != null; i += 2) {
            // Check the data of the currNode.
            assertEquals(i, currNode.data);

            // Move to the next node.
            currNode = currNode.next;
        }
    }

    @Test
    // Test the deleteAtPosition with an index out of range.
    void deleteAtPositionTest2() {
        // Create a list.
        LinkedListMethod testList = new LinkedListMethod();

        // Make the list become {0, 1, 2, 3} with append method.
        testList.linkedListAppend(0);
        testList.linkedListAppend(1);
        testList.linkedListAppend(2);
        testList.linkedListAppend(3);

        Exception e = Assertions.assertThrows(Exception.class, () ->
                testList.deleteAtPosition(testList, 4), "Exception not thrown!");

        assertEquals("Index is out of range!", e.getMessage());
    }
}