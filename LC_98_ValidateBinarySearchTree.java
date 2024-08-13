import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
public class LC_98_ValidateBinarySearchTree {

    // driver-method for recursive solution
    public boolean isValidBST(TreeNode root) {
        // initialize recursion with the entire range of possible values
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true; // empty tree should be a valid BST

        // check if BST is still valid by comparing current node to current min and max values
        if (node.val <= min || node.val >= max) return false;

        // validate left and right subtrees recursively with new min-max values
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }

    // DFS solution with in-order traversal
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true; // empty tree should be a valid BST

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; // current node being processed
        Integer prev = null; // value of last node visited

        while (!stack.isEmpty() || curr != null) {
            // traverse the left side to the final node
            while (curr != null) {
                stack.push(curr); // keep adding nodes to stack
                curr = curr.left;
            }

            curr = stack.pop();

            // check if BST is still valid by comparing the current node to the previous
            if (prev != null && curr.val <= prev) return false;
            prev = curr.val; // updated pointer value for last visited node

            curr = curr.right; // process right subtree
        }
        return true; // valid tree
    }

    // definition for a binary tree node
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
