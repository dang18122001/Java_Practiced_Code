public class BinaryTreePractice {
    // Class for tree node which store integer.
    static class Node {
        int key;
        Node left, right;

        public Node (int data) {
            key = data;
            left = right = null;
        }
    }

    // Class for binary tree.
    static class BinaryTree {
        // Root of Binary Tree
        Node root;

        // Constructors
        BinaryTree(int key) {
            root = new Node(key);
        }

        BinaryTree() {
            root = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Create a binary tree with 4 nodes.
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

        /*create root*/
        tree.root = new Node(1);

        // Children of root.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        // Add left child of node(2).
        tree.root.left.left = new Node(4);
    }
}
