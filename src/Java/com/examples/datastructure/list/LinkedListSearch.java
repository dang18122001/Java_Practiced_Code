package com.examples.datastructure.list;

import java.util.Random;

public class LinkedListSearch {
    /*
    Write a function that searches a given key ‘x’ in a given singly linked list.
    The function should return true if x is present in linked list and false otherwise.
     */

    /*
     This function creates a linked list of integers between 1-100
        with n elements, and the last element is 101.
     */
    public LinkedListMethod createList(int n) {
        // Create a linked list.
        LinkedListMethod list = new LinkedListMethod();

        // Create random variable.
        Random random = new Random();

        // Fill in the list.
        for (int i = 0; i < n - 1; i++) {
            int newElement = random.nextInt(100) + 1;
            list.linkedListAppend(newElement);
        }

        // End the list with 101.
        list.linkedListAppend(101);

        return list;
    }

    /*
     This function searches for an element in a given linked list
        by iterating through each element in the list.
     */
    public int searchLinkedListMethod1(LinkedListMethod.Node head, int key) {
        // If head = null, the list is empty => return false.
        if (head == null) {
            return -1;
        } else {
            // Store the head node to currNode.
            LinkedListMethod.Node currNode = head;

            // Iterate through each element to find the key.
            // Create a count variable for index.
            int index = 0;
            while (currNode != null) {
                if (currNode.data == key) {
                    return index;
                } else {
                    currNode = currNode.next;
                    index++;
                }
            }
        }

        // If the key can't be found, return false;
        return -1;
    }

    /*
    This function searches for a key in a linked list by going through each element
        in the list using recursive method
     */
    public int searchLinkedListMethod2(LinkedListMethod.Node currNode, int currIndex, int key) {
        // If currNode = null, return -1;
        if (currNode == null) {
            return -1;
        } else {
            // If currNode's value = key, return currIndex.
            if (currNode.data == key) {
                return currIndex;
            } else { // If currNode's value != key, move to next element by recursive method.
                return searchLinkedListMethod2(currNode.next, currIndex + 1, key);
            }
        }
    }

    /*
    This function find a node from a given linked list through given index by
        iterating through each element in the list.
     */
    public int searchNthNodeMethod1(LinkedListMethod.Node head, int givenIndex) {
        // If head is null, the list is empty => return -1.
        if (head == null) {
            return -1;
        } else {
            // Store head to variable currNode.
            LinkedListMethod.Node currNode = head;

            // Iterate through each node and end at the node whose index = givenIndex.
            int currIndex = 0;
            while (currNode != null) {
                if (currIndex != givenIndex) {
                    currNode = currNode.next;
                    currIndex++;
                } else {
                    return currNode.getData();
                }
            }

            // If the method end the while without returning the value, the Node in the givenIndex is not exist.
            return -1;
        }
    }

    /*
    This function find a node from a given linked list through given index by
        iterating through each element in the list using recursion.
     */
    public int searchNthNodeMethod2(LinkedListMethod.Node currNode, int currIndex, int givenIndex) {
        // If currNode is null, we cannot find the node through the given index => return -1.
        if (currNode == null) {
            return -1;
        } else {
            // If currIndex != givenIndex, move to the next node and increase currIndex.
            if (currIndex != givenIndex) {
                currNode = currNode.next;
                currIndex++;
                return searchNthNodeMethod2(currNode, currIndex, givenIndex);
            } else { // If currNode == currIndex, return the value of currNode.
                return currNode.getData();
            }
        }
    }

    /*
    This function find the Nth node from the end of a given linked list.
    The function finds the length of the list, then find the node at
        index (length - N) which is also the Nth node from the end.
     */
    public int searchNthNodeFromEndMethod1(LinkedListMethod.Node head, int orderFromEnd) {
        // If the head is null, the list is empty => return -1.
        if (head == null) {
            return -1;
        } else {
            // Store the second element of the list to variable currNode.
            LinkedListMethod.Node currNode = head.next;

            // Find the length of the list.
            int listLength = 1;
            while (currNode != null) {
                listLength++;
                currNode = currNode.next;
            }

            // If the orderFromEnd > listLength, the node cannot be found => return -1.
            if (orderFromEnd > listLength) {
                return -1;
            } else {
                // Restore currNode.
                currNode = head;

                // The node we need to find is at index (listLength - orderFromEnd).
                for (int i = 0; i < (listLength - orderFromEnd); i++) {
                    currNode = currNode.next;
                }

                // Return the value of currNode.
                return currNode.getData();
            }
        }
    }

    /*
    This function find the Nth node from the end of a given linked list.
    Use two-pointer method in this function. The first is reference pointer,
        and the second is main pointer.
    Step 1: Move both pointers to the head of the list.
    Step 2: Move the reference pointer to the Nth node from the head.
    Step 3: Move both pointers until the reference pointer meets the last node,
        then the main pointer now points at the Nth node from the end.
     */
    public int searchNthNodeFromEndMethod2(LinkedListMethod.Node head, int orderFromEnd) {
        // If head is null, the list is empty => return -1.
        if (head == null) {
            return -1;
        } else {
            // Create two pointers and set at head.
            LinkedListMethod.Node reference = head;
            LinkedListMethod.Node main = head;

            // Move reference to Nth node from the beginning.
            int count = 1;
            while (reference != null) {
                if (count == orderFromEnd) {
                    break;
                }
                reference = reference.next;
                count++;
            }

            // If count < orderFromEnd, the orderFromEnd > the length of the list => return -1.
            if (count < orderFromEnd) {
                return -1;
            } else {
                // Move both pointers until reference reach the final element.
                while (reference.next != null) {
                    main = main.next;
                    reference = reference.next;
                }

                // Return the value of the node at the main pointer.
                return main.getData();
            }
        }
    }
}
