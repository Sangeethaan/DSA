import java.util.*;

public class demo {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
           
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                subList.add(node.val);
            }

            list.add(subList);
        }

        return list;
    }
}
