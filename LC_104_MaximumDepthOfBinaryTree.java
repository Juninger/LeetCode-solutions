import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class LC_104_MaximumDepthOfBinaryTree {

    // BFS solution: count the number of levels in tree
    public int maxDepth(TreeNode root) {

        // base case, reached leaf
        if (root == null) return 0;

        int level = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root); // adding first node

        int size = 1; // avoids ConcurrentModificationException

        while (size > 0) {

            // removes current node from queue and adds children if non-null
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.remove();
                if (node.left != null) dq.add(node.left);
                if (node.right != null) dq.add(node.right);
            }
            size = dq.size();
            level++; // increases for each iteration of new children
        }
        return level;
    }

    // "classic" DFS solution: recursively counts depth of each subtree
    public int maxDepth2(TreeNode root) {

        // base case, reached leaf
        if (root == null) return 0;

        // finds depth of each subtree
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // return the deepest subtree
        return left > right ? (left + 1) : (right + 1);
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
