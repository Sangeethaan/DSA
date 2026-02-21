public class demo {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> arr = new ArrayList<>();
        
        helper(root, arr);
        
        Node pre = null;
        Node post = null;
        for(Node node : arr){
            if(node.data > key){
                post = node;
                break;
            }
            if(node.data != key) pre = node;
        }
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(post);
        return ans;
    }
    
    public void helper(Node root, ArrayList<Node> arr){
        if(root == null) return;
        
        helper(root.left, arr);
        arr.add(root);
        helper(root.right, arr);
    }
    // TC = O(n){helper function} + O(n){for loop} + O(1){ans list} ~ O(n)
    // SC = O(n){arr list} + O(n){recussion stack space} ~ O(n)


    // Better solution
    Node pre = null;
    Node post = null;
    boolean postFound = false;
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        helper(root, key);
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(post);
        return ans;
    }
    
    public void helper(Node root, int key){
        if(root == null || postFound) return;
        
        helper(root.left, key);
        
        if(postFound) return;
        
        if(!postFound && root.data > key){
            post = root;
            postFound = true;
            return;
        }
        
        if(!postFound && root.data != key) pre = root;
        
        helper(root.right, key);
    }
    // TC = O(n)
    // SC = O(n){recurssion stack space}


    // optimal solution
    Node pre = null;
    Node post = null;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        
        findPre(root, key);
        findPost(root, key);
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(post);
        return ans;
    }  
    
    public void findPre(Node root, int key){
        while(root != null){
            if(root.data < key){
                pre = root;
                root = root.right;
            }else{
                root = root.left;
            }
        }
    }
    
    public void findPost(Node root, int key){
        while(root != null){
            if(root.data > key){
                post = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
    }

    // TC = O(h) + O(h) ~ O(h)
    // SC = O(1)
}
