package height_of_tree;

import javax.swing.tree.TreeNode;

public class demo {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Integer.max(left,right);
    }
}
// TC = O(n) {each node is visited exactly once}
// SC = O(h) {recursion stack's height}
