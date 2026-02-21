package two_sum;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class demo {
    // Brute force
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();

        inorder(root, list);

        int i = 0;
        int j = list.size()-1;

        while(i < j){
            if(list.get(i).val + list.get(j).val == k){
                return true;
            }else if(list.get(i).val + list.get(j).val < k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    // TC = O(n){while loop} + O(n){inorder function} ~ O(n)
    // SC = O(n){list space} + O(h){recursive stack space} ~ O(n)
}
