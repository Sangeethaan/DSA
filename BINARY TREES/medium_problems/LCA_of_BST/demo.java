import javax.swing.tree.TreeNode;

public class demo {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        if((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)){
            return root;
        }

        if(q.val < root.val && p.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if(q.val > root.val && p.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }
}
