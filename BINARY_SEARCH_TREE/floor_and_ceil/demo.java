import org.w3c.dom.Node;

public class demo {
    public static int floor(Node root, int x) {
        // code here
        int ans = -1;
        while(root != null){
            if(x > root.data){
                ans = root.data;
                root = root.right;
            }else if(x < root.data){
                root = root.left;
            }else{
                ans = root.data;
                break;
            }
        }
        return ans;
    }


    int findCeil(Node root, int x) {
        // code here
        int ans = -1;
        while(root != null){
            if(x > root.data){
                root = root.right;
            }else if(x < root.data){
                ans = root.data;
                root = root.left;
            }else{
                ans = root.data;
                break;
            }
        }
        return ans;
    }


    // TC = O(h)
    // SC = O(1)
}
