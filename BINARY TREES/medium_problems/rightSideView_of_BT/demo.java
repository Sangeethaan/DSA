package rightSideView_of_BT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class demo {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            int lastNodeValue = 0;
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                lastNodeValue = node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            list.add(lastNodeValue);
        }
        return list;
    }
}
