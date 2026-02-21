class demo {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = inorder(root,k);
        return result.val;
    }

    public TreeNode inorder(TreeNode root, int k){
        if(root == null) return null;

        TreeNode left = inorder(root.left,k);
        if(left != null) return left;

        count++;
        if(count == k) return root;

        return inorder(root.right,k);
    }
}