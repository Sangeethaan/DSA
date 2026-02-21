package top_view_of_BT;

class Pair {
    Node node;
    int col;
    
    Pair(Node node, int col){
        this.node = node;
        this.col = col;
    }
}

class demo {
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        int col = 0;
        q.offer(new Pair(root, col));
        
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                Pair p = q.poll();
                if(!map.containsKey(p.col)) map.put(p.col, p.node.data);
                if(p.node.left != null) q.offer(new Pair(p.node.left,p.col-1));
                if(p.node.right != null) q.offer(new Pair(p.node.right,p.col+1));
            }
        }
        
        for(int v : map.values()){
            list.add(v);
        }
        
        return list;
        
    }
}
