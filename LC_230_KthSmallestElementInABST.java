import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Examples:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 */
public class LC_230_KthSmallestElementInABST {

    private int index = 0; // counter for nodes visited until k
    private int res = 0; // stores the kth smallest value once found

    // driver method for the recursive solution
    public int kthSmallest(TreeNode root, int k) {
        traverseBST(root, k);
        return res; // holds result after recursion
    }

    // in-order BST traversal
    public void traverseBST(TreeNode node, int k) {
        if (node == null) return; // base case

        // traverse left subtree
        traverseBST(node.left, k);

        index++; // increment number of nodes visited
        if (index == k) { // Kth node reached, solution found
            res = node.val; // store result
            return;
        }
        // traverse right subtree
        traverseBST(node.right, k);
    }

    // uses in-order traversal to process nodes in ascending order
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; // current node being processed
        int index = 0; // counter for nodes visited until k

        // traverse all nodes
        while (!stack.isEmpty() || curr != null) {
            // traverse the left side to the final node
            while (curr != null) {
                stack.push(curr); // keep adding nodes to stack
                curr = curr.left; // move current pointer
            }

            curr = stack.pop();
            index++; // increment number of nodes visited
            if (index == k) return curr.val; // Kth node reached, solution found

            curr = curr.right; // process right subtree
        }
        return -1; // technically not reachable
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
