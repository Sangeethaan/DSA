class demo {
    
    boolean isLeafNode(Node root){
        if(root == null) return false;
        return (root.left == null && root.right == null) ? true : false;
    }
    
    void leftBoundary(Node root, ArrayList<Integer> list){
        if(root != null && !isLeafNode(root)){
            list.add(root.data);
            if(root.left != null){
                leftBoundary(root.left,list);
            }else if(root.right != null){
                leftBoundary(root.right,list);
            }
        }else{
            return;
        }
    }
    
    void addLeafNode(Node root, ArrayList<Integer> list){
        
        if (root == null) return;
        
        if(isLeafNode(root)){
            list.add(root.data);
            return;
        }
        addLeafNode(root.left, list);
        addLeafNode(root.right, list);
    }
    
    void rightBoundary(Node root, ArrayList<Integer> tempList){
        if(root != null && !isLeafNode(root)){
            tempList.add(root.data);
            if(root.right != null){
                rightBoundary(root.right,tempList);
            }else if(root.left != null){
                rightBoundary(root.left,tempList);
            }
        }else{
            return;
        }
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        if(root == null) return list;
        
        list.add(root.data);
        
        leftBoundary(root.left,list);
        if(!isLeafNode(root)) addLeafNode(root, list);
        rightBoundary(root.right, tempList);
        
        for(int i=tempList.size()-1; i>=0; i--){
            list.add(tempList.get(i));
        }
        
        return list;
    }
    // TC = O(n)
    // SC = O(h) where h is the height of the tree ~ O(n){in the worst case for skewed tree}
}