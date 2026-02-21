class demo {
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int leftSum = Math.max(0,helper(root.left));
        int rightSum = Math.max(0,helper(root.right));

        sum = Math.max(sum , root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
    // TC = O(n)
    // SC = O(n)
}