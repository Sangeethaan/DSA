import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class demo {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                
                if(level%2 == 0){
                    subList.addLast(node.val);
                }else{
                    subList.addFirst(node.val);
                }
            }
            level++;
            list.add(subList);
        }

        return list;

    }
    // TC = O(n)
    // SC = O(n)
}
