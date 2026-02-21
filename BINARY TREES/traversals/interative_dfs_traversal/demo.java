import java.util.*;

import javax.swing.tree.TreeNode;

public class demo {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;
        s.push(root);

        while(!s.isEmpty()){
            TreeNode node = s.pop();
            list.add(node.val);
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();

        while(true){
            if(node != null){
                s.push(node);
                node = node.left;
            }else{
                if(s.isEmpty()) break;
                node = s.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
