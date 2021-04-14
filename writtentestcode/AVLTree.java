/**
 * 
 * 
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
 */


public class AVLTree {
    Node root;

    public AVLTree() {
        this.root = null;
    }

    /**
     * This function is to check whether the given BST tree is an AVL tree. The main idea is checking the properties of
     * AVL tree.
     * hint: you can use the helper function "getBalance()"
     *
     * @param root root node of the given BST tree
     * @return boolean value
     * **/
    boolean isBalanced(Node root){
        // TODO: Complete this method
        // START YOUR CODE
        if (root != null) {
            boolean current_layer = Math.abs(getBalance(root)) <= 1;
            boolean left = isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return current_layer && left && right;
        } else {
            return true;
        }
        // END YOUR CODE
    }
    /**
     * This helper function is to obtain each node's height.
     *
     * @param node node of the given BST tree
     * @return int the height of the input node
     * **/
    public int getHeight(Node node){
        // TODO: Complete this method
        // START YOUR CODE
        if (node == null) {
            return 0;
        } else {
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            return 1 + Math.max(left, right);
        }
        // END YOUR CODE
    }

    /**
     * This function is to find the balance factor of each node.
     * hint: you can implement the helper function "getHieght()".
     *
     * @param node node of the given BST tree
     * @return int the balance of the node
     * **/
    public int getBalance(Node node){
        // TODO: Complete this method
        // START YOUR CODE
        return (node == null) ? 0 : (getHeight(node.right) - getHeight(node.left));
        // END YOUR CODE
    }

    /**
     * This implementation of BST insertion follows the pseudo code in the lecture slide.
     * Node that we do not use recursion or insertion fixup to fix the balance of AVL tree.
     *
     * @param key key of inserted node
     * @return inserted node (not the entire tree)
     */
    public Node insert(Integer key) {
        Node parent = null;
        Node current = this.root;
        while (current != null) {
            if(current.key.compareTo(key) < 0) {
                parent = current;
                current = current.right;
            }else if (current.key.compareTo(key) > 0){
                parent = current;
                current = current.left;
            }
        }

        if (parent == null && current == null) {
            this.root = new Node(key);  // no parent = root is empty
            return root;
        }else {
            Node newNode = new Node(key);

            if(parent.key.compareTo(key) < 0) {
                parent.right = newNode;
                newNode.parent = parent;
            }else if(parent.key.compareTo(key) > 0) {
                parent.left = newNode;
                newNode.parent = parent;
            }
            return newNode;
        }
    }

    public class Node {
        Integer key;
        Node parent;
        Node left;
        Node right;

        public Node(Integer key) {
            this.key = key;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }
}
