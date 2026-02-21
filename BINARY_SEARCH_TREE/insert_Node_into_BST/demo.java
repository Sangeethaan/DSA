package insert_Node_into_BST;

import javax.swing.tree.TreeNode;

public class demo {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode head = root;
        while(true){
            if(root.val > val){
                if(root.left != null) {
                    root = root.left;
                }else{
                    break;
                }
            }else{
                if(root.right != null) {
                    root = root.right;
                }else{
                    break;
                }
            }
        }

        if(root.val > val){
            root.left = new TreeNode(val);
        }else{
            root.right = new TreeNode(val);
        }

        return head;
    }
    // TC = O(h)
    // SC = O(1)
}
