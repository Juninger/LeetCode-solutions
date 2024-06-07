/**
 * Given the roots of two binary trees "root" and "subRoot", return true if there is a subtree of "root" with the same structure and node values of "subRoot" and false otherwise.
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 */
public class LC_572_SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; // no subtree (considered a subtree of ANY tree in this case)
        if (root == null) return false; // no main tree
        if (sameTree(root, subRoot)) return true; // full trees are identical

        // recursively check if subRoot is a subtree of the left or right subtrees of root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // helper method, partly borrowed from LC_100_SameTree
    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true; // both trees are null : identical

        // if trees are not null and values are the same, recursively check if subtrees are identical
        if (root != null && subRoot != null && root.val == subRoot.val) {

            // recursively check if left and right subtrees are identical
            boolean left = sameTree(root.left, subRoot.left);
            boolean right = sameTree(root.right, subRoot.right);

            return left && right; // true if nodes are identical
        }
        return false; // trees are not identical
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
