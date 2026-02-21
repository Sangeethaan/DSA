import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class demo{

    // InOrder
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode node,List<Integer> list){
        if(node == null) return;

        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

    // PreOrder
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorder(root,list);
        return list;
    }
    public static void preorder(TreeNode node,List<Integer> list){
        if(node == null) return;

        
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }

    // PostOrder
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorder(root,list);
        return list;
    }
    public static void postorder(TreeNode node,List<Integer> list){
        if(node == null) return;

        postorder(node.left,list);
        postorder(node.right,list);
        list.add(node.val);
    }


    // TC = O(n)
    // SC = O(h)
    public static void main(String[] args) {

    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right.right = new TreeNode(8);

    root.left.right.left = new TreeNode(6);
    root.left.right.right = new TreeNode(7);

    root.right.right.left = new TreeNode(9);

    List<Integer> result = postorderTraversal(root);
    System.out.println(result);
}

}