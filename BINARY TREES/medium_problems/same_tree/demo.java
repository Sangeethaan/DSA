import javax.swing.tree.TreeNode;

public class demo {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return (p == null && q == null) ? true : false;
        }

        if(p.val != q.val) return false;

        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);

        return left && right;

    }
    // TC = O(n)
    // SC = O(n)
}
