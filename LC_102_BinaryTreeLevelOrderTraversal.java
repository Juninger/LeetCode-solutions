import java.util.*;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 */
public class LC_102_BinaryTreeLevelOrderTraversal {

    // BFS solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(); // empty tree

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root); // add root node to start initialize queue

        // iterate until all nodes have been processed
        while (!queue.isEmpty()) {

            // number of nodes to process in current level of tree
            int currentLevelNodes = queue.size();

            // nodes in current level
            List<Integer> levelNodes = new ArrayList<>();

            // process all nodes on this level
            for (int i = 0; i < currentLevelNodes; i++) {
                TreeNode node = queue.remove(); // pop from queue
                levelNodes.add(node.val); // add current node to this level's list

                // add children of current node to queue if they are not null
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(levelNodes); // add list of nodes from current level to result
        }
        return result;
    }

    // definition for a binary tree node.
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
