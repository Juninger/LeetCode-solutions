/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class LC_100_SameTree {

    // helper method to initiate recursive comparison
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compareNodes(p, q);
    }

    // method to specify conditions for node comparison
    private boolean compareNodes(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // both trees are null : identical
        if (p == null || q == null) return false; // only one tree is null : not identical
        if (p.val != q.val) return false; // different values of nodes : not identical

        // recursively check both trees
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right; // true if nodes are identical
    }

    // definition for a tree node
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
