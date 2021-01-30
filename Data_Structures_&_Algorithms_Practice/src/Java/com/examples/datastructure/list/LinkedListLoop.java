package com.examples.datastructure.list;

public class LinkedListLoop {
    /*
    This function checked if a given linked list has a loop or not.
    This function use Floyd's Cycle Finding Algorithm:
        Step 1: Create two pointers, slow and fast, and set at head.
        Step 2: Travel through the list by the two pointers: the slow pointer move one by one, while
            the fast one move through two elements in one time.
        Step 3: If the two pointer meets at one point, the list has a loop.
    Complexity: O(n).
    Auxiliary Space: O(1).
     */
    public boolean detectLoopInLinkedListMethod1(LinkedListMethod.Node head) {
        // If the head is null, the list is empty => return false.
        if (head == null) {
            return false;
        }

        // Create two pointers and set at head.
        LinkedListMethod.Node slowPointer = head;
        LinkedListMethod.Node fastPointer = head;

        // Travel through the list through two pointers.
        do {
            // Move fast pointer two times
            // If the next node of the current fastPointer is null, the list has no loop => return false.
            if (fastPointer.next == null) {
                return false;
            }
            fastPointer = fastPointer.next;

            // If the next node of the current fastPointer is null, the list has no loop => return false.
            if (fastPointer.next == null) {
                return false;
            }
            fastPointer = fastPointer.next;

            // Move slow pointer one time.
            slowPointer = slowPointer.next;
        } while (slowPointer != fastPointer);

        // If the function reaches this line of code, the list has a loop => return true.
        return true;
    }

    /*
    This function checked if a given linked list has a loop or not.
    Algorithm:
    Create a temp node.
    Traverse through each node of the loop and set that node point to
        the temp node.
    Each time we met a node, if the pointer of that node point to the temp node,
        then it has been visited before => loop exists.
        If the pointer point to null => loop does not exist.
    Time complexity: O(n).
    Auxiliary space: O(1).
     */
    public boolean detectLoopInLinkedListMethod2(LinkedListMethod.Node head) {
        // If the head is null, the list is empty => return false.
        if (head == null) {
            return false;
        }

        // Create a tempNode node.
        LinkedListMethod.Node tempNode = new LinkedListMethod.Node(0);

        // Store head to currNode.
        LinkedListMethod.Node currNode = head;

        // Traverse through the list.
        while (currNode.getNext() != null) {
            // If currNode points to tempNode node, return true.
            if (currNode.getNext() == tempNode) {
                return true;
            }

            // Store the current next node of the currNode to tempNextNode.
            LinkedListMethod.Node tempNextNode = currNode.getNext();

            // Set currNode to point to tempNode node.
            currNode.setNext(tempNode);

            // Move to the next node
            currNode = tempNextNode;
        }

        // The traverse reach null, the list has no loop.
        return false;
    }

    /*
    This function checked if a linked list contains loop and return the length
        of the loop.
    This function applies the Floyd's Cycle Finding Algorithm to check whether
        the given linked list contains loop, similar to
        function detectLoopInLinkedListMethod1
    When the fast and slow pointer met at a node, that node must be a node in the
        loop. From that node, we traverse through the loop to find the length
        of the loop.
    Time complexity: O(n).
    Auxiliary space: O(1).
     */
    public int detectAndCountLoop(LinkedListMethod.Node head) {
        // If the head is null, the list is empty => return -1.
        if (head == null) {
            return -1;
        }

        // Create two pointers and set at head.
        LinkedListMethod.Node slowPointer = head;
        LinkedListMethod.Node fastPointer = head;

        // Travel through the list through two pointers.
        do {
            // Move fast pointer two times
            // If the next node of the current fastPointer is null, the list has no loop => return false.
            if (fastPointer.next == null) {
                return -1;
            }
            fastPointer = fastPointer.next;

            // If the next node of the current fastPointer is null, the list has no loop => return false.
            if (fastPointer.next == null) {
                return -1;
            }
            fastPointer = fastPointer.next;

            // Move slow pointer one time.
            slowPointer = slowPointer.next;
        } while (slowPointer != fastPointer);

        // If the function reaches this line of code, the list has a loop.
        // Now we find the length of the loop.
        /*
         The fast and slow pointer is now at one point in the loop, we keep
            using them to calculate the length.
         */
        int loopLength = 1;
        while (fastPointer.next != slowPointer) {
            /*
             Each time we traverse through a node in the loop, increase loop
                length by 1.
             */
            loopLength++;

            // Move to the next node.
            fastPointer = fastPointer.next;
        }

        return loopLength;
    }
}
