package com.examples.datastructure.list;

public class LinkedListMethod {

    // This is the head of the linked list.
    private Node head;

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    // Declare a class for linked list nodes that store integers.
    public static class Node {
        int data;
        Node next;

        // Constructor to create a new node.
        public Node (int d) {
            data = d;
            next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /*
    This function is to print elements of linked list.
     */
    public void linkedListPrint(LinkedListMethod list) {
        // Store the head of the list to n.
        Node n = list.head;

        // Loop through each node in the lists.
        while (n != null) {
            // print the data of that node.
            System.out.print(n.data + " ");

            // Move to the next node.
            n = n.next;
        }
    }

    /*
    This function is to insert a new node to the beginning of the list.
     */
    public void linkedListPush(LinkedListMethod list, int newData) {
        // Allocate the new node.
        Node newNode = new Node(newData);

        // Connect the new node to the current head.
        newNode.next = list.head;

        // Connect head to the new node.
        list.head = newNode;

    }

    /*
    This function is to insert a new node after a given node.
     */
    public void linkedListInsertMiddle(LinkedListMethod list, int position, int newData) throws Exception {
        // Store the head to the currNode.
        Node currNode = list.head;

        // Allocate the new node.
        Node newNode = new Node(newData);

        // Create the prevNode to store the node that has the index = position - 1.
        Node prevNode = null;

        // If the position is 0.
        if (position == 0 && currNode != null) {
            // Change the head to the newNode.
            list.head = newNode;

            // Set the newNode to point to the currNode.
            newNode.next = currNode;
        }

        // If the position is not 0.
        // Create the index to keep track of the position of currNode.
        int index = 0;

        // Search for node that is currently at the chosen position.
        while (currNode != null) {
            // If the currNode is at the chosen position.
            if (index == position) {
                // Add newNode to that position.
                assert prevNode != null;
                prevNode.next = newNode;
                newNode.next = currNode;

                // Stop the loop.
                break;
            }

            // If the currNode is not yet at the chosen position.
            else {
                // Keep track of prevNode.
                prevNode = currNode;

                // Move to the next node.
                currNode = currNode.next;

                // Keep track of the index.
                index++;
            }
        }

        // If the position is out of the list.
        if (currNode == null)
            throw new Exception("Index is out of range!");
    }

    /*
    This function is to insert a new node to the end of a list.
     */
    public void linkedListAppend(int newData) {
        // Allocate the new node.
        Node newNode = new Node(newData);

        // Connect the new node to null, as it will be the last node.
        newNode.next = null;

        // If head = null (the list is empty), the new node will be the head.
        if (this.head == null) {
            this.head = newNode;
        }

        // If the list is not empty.
        else {

            // Store the head of the list to last.
            Node last = this.head;

            // Go to the current last node of the list.
            while (last.next != null)
                last = last.next;

            // Connect the current last node to the new node.
            last.next = newNode;
        }
    }

    public void linkedListAppend(Node newNode) {
        // Connect the new node to null, as it will be the last node.
        newNode.next = null;

        // If head = null (the list is empty), the new node will be the head.
        if (this.head == null) {
            this.head = newNode;
        }

        // If the list is not empty.
        else {

            // Store the head of the list to last.
            Node last = this.head;

            // Go to the current last node of the list.
            while (last.next != null)
                last = last.next;

            // Connect the current last node to the new node.
            last.next = newNode;
        }
    }

    /*
    Deletion By KEY:
    Search the key for its first occurrence in the list
    Now, Any of the 3 conditions can be there:
        Case 1: The key is found at head
            In this case, Change the head of the node to the next node of current head.
            Free the memory of replaced head node.
        Case 2: The key is found at in the middle or last, except at head
            In this case, Find previous node of the node to be deleted.
            Change the next of previous node to the next node of current node.
            Free the memory of replaced node.
        Case 3: The key is not found in the list
            In this case, No operation needs to be done.
     */
    public void deleteByKey(LinkedListMethod list, int key) throws Exception {
        // Store the head node to currNode.
        Node currNode = list.head;

        // If the key is found at head.
        if (currNode != null && currNode.data == key)
            // Change the head to the node after currNode.
            list.head = currNode.next;

        // If the key is found in the middle or last.
        // Go through each node to find the key.
        // Keep the previous node as it is needed in deletion.
        Node prevNode = null;
        while (currNode != null && currNode.data != key) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        // If the key is found, it belonged to the currNode.
        if (currNode != null) {
            // Set the pointer of the previous node to point to the node after currNode.
            assert prevNode != null;
            prevNode.next = currNode.next;
        }

        // If the key is not found, currNode = null.
        else
            throw new Exception("The key cannot be found!");
    }

    /*
    Deletion At Position:
    Traverse the list by counting the index of the nodes
    For each index, match the index to be same as position
    Now, Any of the 3 conditions can be there:
        Case 1: The position is 0, i.e. the head is to be deleted
            In this case, Change the head of the node to the next node of current head.
            Free the memory of replaced head node.
        Case 2: The position is greater than 0 but less than the size of the list, i.e. in the middle or last, except at head
            In this case, Find previous node of the node to be deleted.
            Change the next of previous node to the next node of current node.
            Free the memory of replaced node.
        Case 3: The position is greater than the size of the list, i.e. position not found in the list
            In this case, No operation needs to be done.
     */
    public void deleteAtPosition(LinkedListMethod list, int position) throws Exception {
        // Store the head to currNode.
        Node currNode = list.head;

        // Create prevNode to store the previous node of the node that will be deleted.
        Node prevNode = null;

        // Create index to keep track of the position of the currNode.
        int index = 0;

        // If the position is 0.
        if (index == position && currNode != null)
            // Change the head to point to the node after the currNode.
            list.head = currNode.next;

        // If the node to be deleted is found in the middle or at last.
        while (currNode != null) {
            // If the node is found.
            if (index == position) {
                // Set the pointer of the previous node to point to the node after the deleted node.
                assert prevNode != null;
                prevNode.next = currNode.next;

                // Stop the while loop.
                break;
            }

            // If the node is not yet found.
            else {
                // Keep track of the previous node.
                prevNode = currNode;

                // Move to the next node.
                currNode = currNode.next;

                // Keep track of the index.
                index ++;
            }
        }

        // If the position is not in the list.
        if (currNode == null)
            throw new Exception("Index is out of range!");
    }

    public static void main(String[] args) throws Exception {
        /* Start with the empty list. */
        LinkedListMethod list = new LinkedListMethod();

        //
        // ******INSERTION******
        //

        // Insert the values
        list.linkedListAppend(1);
        list.linkedListAppend(2);
        list.linkedListAppend(3);
        list.linkedListAppend(4);
        list.linkedListAppend(5);
        list.linkedListAppend(6);
        list.linkedListAppend(7);
        list.linkedListAppend(8);

        list.linkedListPush(list, 9);

        list.deleteByKey(list, 6);

        list.deleteAtPosition(list, 1);

        list.linkedListInsertMiddle(list, 1, 1);

        // Print the LinkedList
        list.linkedListPrint(list);

//        System.out.println();

//        List<Integer> list2 = new LinkedList<Integer>();
//        list2.add(1);
//        list2.add(2);
//        list2.add(0, 3);
//
//        for (Integer element: list2) {
//            System.out.print(element + " ");
//        }
//
//        System.out.println();
//        System.out.println(list2.get(list2.size() - 1));
    }

}
