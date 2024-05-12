/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class LC_226_InvertBinaryTree {

    // DFS solution: post-order traversal --> better space complexity: O(1)
    public TreeNode invertTree(TreeNode root) {

        // base case: end of branch, nothing more to invert
        if (root == null) return null;

        // recursively inverts subtrees until base case
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        // swaps left:right subtrees
        root.left = rightInverted;
        root.right = leftInverted;

        return root; // unchanged root value
    }

    // DFS solution: pre-order traversal --> worse space complexity: O(h) (h = height of tree)
    public TreeNode invertTree2(TreeNode root) {

        // base case: end of branch, nothing more to invert
        if (root == null) return null;

        // swaps left:right child nodes of root
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recursively inverts subtrees until base case
        invertTree2(root.left);
        invertTree2(root.right);

        return root; // unchanged root value
    }

    // definition for a binary tree node
    public static class TreeNode {
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
