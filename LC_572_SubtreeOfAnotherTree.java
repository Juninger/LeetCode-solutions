/**
 * Given the roots of two binary trees "root" and "subRoot", return true if there is a subtree of "root" with the same structure and node values of "subRoot" and false otherwise.
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 */
public class LC_572_SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return false;
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
