import javax.swing.tree.TreeNode;

public class demo {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return (p == null && q == null) ? true : false;
        }

        if(p.val != q.val) return false;

        boolean part1 = helper(p.left, q.right);
        boolean part2 = helper(p.right, q.left);

        return part1 && part2;
    }
    // TC = O(n)
    // SC = O(h)
}
