import java.util.ArrayList;
import java.util.Collections;

import javax.swing.tree.TreeNode;

public class demo {
    // Brute solution
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        Collections.sort(list);
        int[] i = {0};
        swap(root, list, i);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public void swap(TreeNode root, ArrayList<Integer> list, int[] i){
        if(root == null) return;

        swap(root.left, list, i);
        if(list.get(i[0]) != root.val){
            if(first == null){
                first = root;
            }else{
                second = root;
            }
        }
        i[0]++;
        swap(root.right, list, i);
    }

    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    // TC = O(n){inorder function traversal} + O(n logn){sorting the list} + O(n){swap function traversal}
    // SC = O(n){list} + O(2h){recursion stack space}

    // Optimal Solution
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
    // TC = O(n){inorder function traversal}
    // SC = o(h){recursion stack space}
}
