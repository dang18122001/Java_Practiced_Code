package com.examples.datastructure.list;

import java.util.LinkedList;
import java.util.Stack;

public class PalindromeLinkedList {
    /*
    This function checks if a linked list is palindrome or not.
    In this function, a stack is used to store the value of nodes when
        traversing through the list.
    After that, we traverse through the list and compare each node with the
        corresponding node popped from the stack.
    If there is a pair of node that has different values, the list is not
        palindrome.
    Time complexity: O(n).
    Auxiliary space: O(1).
     */
    public boolean checkPalindromeLinkedListMethod1(LinkedListMethod.Node head) throws Exception {
        // If the head is null, the list is empty => return false.
        if (head == null) {
            throw new Exception("The list is empty!");
        }

        // Create a stack to store the nodes.
        Stack<Integer> nodesValue = new Stack<>();

        // Traverse through the list and store the values of nodes to the stack.
        LinkedListMethod.Node currNode = head;
        while (currNode != null) {
            nodesValue.push(currNode.getData());
            currNode = currNode.getNext();
        }

        /*
         Traverse through the list again and compare the nodes' values with
            the values in the stack.
         */
        currNode = head;
        while (currNode != null) {
            int currValue = nodesValue.pop();
            // If the value of currNode != the currValue, the list is not palindrome.
            if (currNode.getData() != currValue) {
                return false;
            }
            currNode = currNode.next;
        }

        return true;
    }

    /*
    This function checks if a linked list is palindrome or not.
    In this method:
    1) Get the middle of the linked list.
    2) Reverse the second half of the linked list.
    3) Check if the first half and second half are identical.
    4) Construct the original linked list by reversing the second half again
        and attaching it back to the first half.
     */
    public boolean checkPalindromeLinkedListMethod2(LinkedListMethod.Node head) throws Exception {
        // If the head is null, the list is empty => return false.
        if (head == null) {
            throw new Exception("The list is empty!");
        }

        // Create two pointers slow and fast to find the middle of the list.
        LinkedListMethod.Node slow = head;
        LinkedListMethod.Node fast = head;

        /*
         Traverse through the list through the two pointers with the fast pointer
            move 2 times quicker than the slow pointer.
         */
        while (true) {
            // If the next node from fast is null, break out of the loop.
            if (fast.getNext() == null) {
                break;
            }
            // Move fast to the next node.
            fast = fast.getNext();

            /*
             If the next node of the current node at fast is null, break the loop.
             */
            if (fast.getNext() == null) {
                break;
            }
            // Move fast to the next node.
            fast = fast.getNext();

            // Move slow to the next node.
            slow = slow.getNext();
        }

        /*
         Now, the slow pointer is at the middle of the list. Create the
            secondHalfHeadNode which point to the starting node of the second half.
         */
        LinkedListMethod.Node secondHalfStartNode = slow.getNext();

        // Reverse the second half of the list.
        secondHalfStartNode = reverseLinkedList(secondHalfStartNode);

        // Check if first half and second half are identical or not.
        LinkedListMethod.Node currNodeFirstHalf = head;
        LinkedListMethod.Node currNodeSecondHalf = secondHalfStartNode;
        do {
            if (currNodeFirstHalf.getData() != currNodeSecondHalf.getData()) {
                return false;
            }

            currNodeFirstHalf = currNodeFirstHalf.getNext();
            currNodeSecondHalf = currNodeSecondHalf.getNext();
        } while (currNodeSecondHalf != null);

        // Reverse the second half of the list again.
        secondHalfStartNode = reverseLinkedList(secondHalfStartNode);

        // Construct the original list.
        slow.setNext(secondHalfStartNode);

        return true;
    }

    /*
    This function reverse the linked list and return the new head.
    In this function, we use three pointers: prev, curr, and next.
    Each time, we set currNode (Node at curr) to point to prevNode, and then
        move prev to curr, curr to next.
     */

    public LinkedListMethod.Node reverseLinkedList(LinkedListMethod.Node head) throws Exception {
        // If the head is null, the list is empty => return false.
        if (head == null) {
            throw new Exception("The list is empty!");
        }

        // Create three pointers.
        LinkedListMethod.Node prevNode = null;
        LinkedListMethod.Node currNode = head;
        LinkedListMethod.Node nextNode = currNode.getNext();

        while (nextNode != null) {
            // Set currNode point to prevNode.
            currNode.setNext(prevNode);

            // Move prevNode to currNode.
            prevNode = currNode;

            // Move currNode to nextNode.
            currNode = nextNode;

            // Move nextNode to the next node.
            nextNode = nextNode.getNext();
        }

        // Set currNode point to prevNode.
        currNode.setNext(prevNode);

        // Now the new head of the list is currNode.
        return currNode;
    }
}
