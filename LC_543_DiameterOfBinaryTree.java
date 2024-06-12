/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class LC_543_DiameterOfBinaryTree {

    int max = 0; // stores the current max diameter of the tree

    public int diameterOfBinaryTree(TreeNode root) {
        depthOfSubtree(root); // starts recursive call
        return max;
    }

    public int depthOfSubtree(TreeNode node) {
        // base case, leaf or null tree
        if (node == null) return 0;

        // finds depth of each subtree
        int left = depthOfSubtree(node.left);
        int right = depthOfSubtree(node.right);

        // diameter of subtrees from current node
        int diameter = left + right;

        // update global max diameter if current is larger
        max = Math.max(diameter, max);

        // return the max height from the current root (+1 to account for current node)
        return 1 + Math.max(left, right);
    }

    // Definition for a binary tree node.
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
