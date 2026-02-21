package search_a_Node;

import javax.swing.tree.TreeNode;

public class demo {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        
        return (val > root.val) ? searchBST(root.right, val) : searchBST(root.left, val);
    }
    // TC = O(h) [O(logN) : for balanced BST]
    // SC = O(h) [O(logN) : for balanced BST]

    while(root != null && root.val != val){
        root = (val > root.val) ? root.right : root.left; 
    }
    return root;
    // TC = O(h) [O(logN) : for balanced BST]
    // SC = O(1)
}
