public class demo {
    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;

        int leftH = helper(root.left);
        int rightH = helper(root.right);

        max = Math.max(max,leftH + rightH);

        return 1+Math.max(leftH,rightH);
    }

    // TC = O(n)
    // SC = O(n)
}
