class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++){
            TreeNode node = root;
            TreeNode parentNode = root;

            while(node != null){
                parentNode = node;
                if(preorder[i] < node.val){
                    node = node.left;
                }else{
                    node = node.right;
                }
            }

            if(preorder[i] < parentNode.val){
                parentNode.left = new TreeNode(preorder[i]);
            }else{
                parentNode.right = new TreeNode(preorder[i]);
            }
        }

        return root;
    }
    // TC = O(n^2)
    // SC = O(1)

    //Better Solution
    class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        int n = preorder.length;

        int[] inorder = new int[n];
        for(int i=0;i<n;i++){
            inorder[i] = preorder[i];
        }

        Arrays.sort(inorder);

        HashMap<Integer,Integer> inMap = new HashMap<>();

        for(int i=0;i<n;i++){
            inMap.put(inorder[i],i);
        }

        return helper(preorder,0,n-1,inorder,0,n-1,inMap);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper(preorder, preStart+1, preStart + numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = helper(preorder, preStart+1+numsLeft, preEnd, inorder, inRoot+1,inEnd, inMap);

        return root;
    }
    // TC: O(n){copy preorder to inorder} + O(nlogn){sorting inorder} + O(n){inorder to hashmap} + O(n){helper function} ~ O(n logn)
    // SC: O(n){inorder array} + O(n){hashmap} +O(h){recursion stack} ~ O(n)


    // optimal Solution
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = {0};
        return helper(preorder,Integer.MAX_VALUE,i);
    }

    public TreeNode helper(int[] arr, int upBound, int[] i){
        if( i[0] >= arr.length || arr[i[0]] > upBound) return null;

        TreeNode root = new TreeNode(arr[i[0]]);
        i[0]++;
        root.left = helper(arr, root.val, i);
        root.right = helper(arr, upBound, i);
        return root;
    }
}
}