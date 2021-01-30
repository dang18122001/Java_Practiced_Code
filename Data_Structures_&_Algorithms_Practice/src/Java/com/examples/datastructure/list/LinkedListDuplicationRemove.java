package com.examples.datastructure.list;

import javax.management.NotificationEmitter;

public class LinkedListDuplicationRemove {
    /*
    This function takes a list sorted in non-decreasing order and
        deletes any duplicate nodes from the list.
    Algorithm:
    Traverse through the list from the head and compare each node to its next node.
    If they are equal, delete the next node.
    Time complexity: O(n).
    Auxiliary space: O(1).
     */
    public void removeDuplicatesInSortedLinkedListMethod1(LinkedListMethod.Node head) throws Exception {
        // If the head is null, the list is empty => return error.
        if (head == null) {
            throw new Exception("The list is empty!");
        }

        LinkedListMethod.Node currNode = head;
        while (currNode.getNext() != null) {
            if (currNode.getData() == currNode.getNext().getData()) {
                LinkedListMethod.Node deletedNode = currNode.getNext();
                LinkedListMethod.Node newNextNode = currNode.getNext().getNext();
                /*
                 To delete the deletedNode, we set currNode point to newNextNode,
                    and set deletedNode point to null.
                 */
                currNode.setNext(newNextNode);
                deletedNode.setNext(null);
            } else {
                // Move to the next node.
                currNode = currNode.getNext();
            }
        }
    }

    /*
    This function takes a list sorted in non-decreasing order and
        deletes any duplicate nodes from the list.
    Algorithm:
    Traverse through the list using recursion from the head and
        compare each node to its next node.
    If they are equal, delete the next node.
    Time complexity: O(n).
    Auxiliary space: O(1).
     */
    public void removeDuplicatesInSortedLinkedListMethod2(LinkedListMethod.Node currNode) throws Exception {
        // If the head is null, the list is empty => return error.
        if (currNode == null) {
            throw new Exception("The list is empty!");
        }

        // Base case: the next node of currNode is null.
        if (currNode.getNext() == null) {
            return;
        }

        // Recursive case:
        if (currNode.getData() == currNode.getNext().getData()) {
            LinkedListMethod.Node deletedNode = currNode.getNext();
            LinkedListMethod.Node newNextNode = currNode.getNext().getNext();
                /*
                 To delete the deletedNode, we set currNode point to newNextNode,
                    and set deletedNode point to null.
                 */
            currNode.setNext(newNextNode);
            deletedNode.setNext(null);
        } else {
            // Move currNode to the next node.
            currNode = currNode.getNext();
        }

        removeDuplicatesInSortedLinkedListMethod2(currNode);
    }

    /*
    This function takes a list sorted in non-decreasing order and
        deletes any duplicate nodes from the list.
    Algorithm:
    Create a pointer that will point towards the first occurrence of every element
        and another pointer temp which will iterate to every element and
        when the value of the previous pointer is not equal to the temp pointer,
        we will set the pointer of the previous pointer to the first occurrence
        of another node.
     */
    public void removeDuplicatesInSortedLinkedListMethod3(LinkedListMethod.Node head) throws Exception {
        // If the head is null, the list is empty => return error.
        if (head == null) {
            throw new Exception("The list is empty!");
        }

        // Create the pointer that points towards  the first occurrence of every element.
        LinkedListMethod.Node firstOccurrence = head;

        // Create the temp pointer.
        LinkedListMethod.Node tempNode = head;

        // Traverse through the list using tempNode.
        while (true) {
            tempNode = tempNode.getNext();

            /*
             If the next node of temp node is null, tempNode is currently the end of
                the list.
             If tempNode's value != firstOccurrence's value, break the loop.
             If tempNode's value == firstOccurrence's value, set firstOccurrence
                point to null and break the loop.
             */
            if (tempNode.getNext() == null) {
                if (tempNode.getData() != firstOccurrence.getData()) {
                    break;
                } else {
                    firstOccurrence.setNext(null);
                    break;
                }
            }

            if (tempNode.getData() != firstOccurrence.getData()) {
                // Set firstOccurrence point to tempNode.
                firstOccurrence.setNext(tempNode);

                /*
                 Move firstOccurrence to the first occurrence of another element,
                    which is the next node.
                 */
                firstOccurrence = firstOccurrence.getNext();
            }
        }
    }
}
