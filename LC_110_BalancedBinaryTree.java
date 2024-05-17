/**
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
class LC_110_BalancedBinaryTree {

    // driver method for solution --> DFSbalance()
    public boolean isBalanced(TreeNode root) {
        return DFSbalance(root)[0] == 1; // [0] : 1/0 --> true/false
    }

    // DFS solution: recursively checks if subtrees are balanced and computes their height
    // [0] --> balanced: 1/0 --> true/false
    // [1] --> height
    public int[] DFSbalance(TreeNode root) {

        // base case (empty subtree, balanced (1) with height 0)
        if (root == null) return new int[]{1, 0};

        // recursive call to check subtree balance and height --> int[]{balanced, height}
        int[] left = DFSbalance(root.left);
        int[] right = DFSbalance(root.right);

        // true if subtrees are balanced (not null & height diff <= 1)
        boolean balanced = (left[0] == 1 && right[0] == 1)
                && (Math.abs(left[1] - right[1]) <= 1);

        // max height of current subtrees in this recursion
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};
    }

//    // driver method for solution --> DFSbalance()
//    public boolean isBalanced(TreeNode root) {
//        return DFSbalance(root).getKey();
//    }
//
//    // DFS solution: recursively checks if subtrees are balanced and computes their height
//    public Pair<Boolean, Integer> DFSbalance(TreeNode root) {
//
//        // base case (empty subtree, balanced with height 0)
//        if (root == null) return new Pair<>(true, 0);
//
//        // recursive call to check subtree balance and height (< balanced, height >)
//        Pair<Boolean, Integer> left = DFSbalance(root.left);
//        Pair<Boolean, Integer> right = DFSbalance(root.right);
//
//        // true if subtrees are balanced (not null & height diff <= 1)
//        boolean balanced = (left.getKey() && right.getKey())
//                && (Math.abs(left.getValue() - right.getValue()) <= 1);
//
//        // max height of current subtrees in this recursion
//        int height = 1 + Math.max(left.getValue(), right.getValue());
//
//        return new Pair<Boolean, Integer>(balanced, height);
//    }

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