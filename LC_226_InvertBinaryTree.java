public class LC_226_InvertBinaryTree {

    // DFS solution
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        // Swapping left:right nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively inverts subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root; // Unchanged root value
    }

    //Definition for a binary tree node.
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
