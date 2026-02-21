import javax.swing.tree.TreeNode;

public class demo {
    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftH = height(root.left);
        int rightH = height(root.right);

        if(Math.abs(leftH-rightH) > 1) return false;

        Boolean leftSubTree = isBalanced(root.left);
        Boolean rightSubTree = isBalanced(root.right);

        return (!leftSubTree || !rightSubTree) ? false : true;
    }

    // TC = O(n^2) {for each and every node, we are going to find left node's height and right node's height which is O(n)+O(n) ~ O(n)}
    // SC = O(n) recursion stack space


    public boolean isBalanced(TreeNode root) {
        int ans = helper(root);
        return ans == -1 ? false : true; 
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int leftH = helper(root.left);
        if(leftH == -1) return -1;
        int rightH = helper(root.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;

        return 1 + Math.max(leftH, rightH);

    }

    // TC = O(n)
    // SC = O(n)
}
