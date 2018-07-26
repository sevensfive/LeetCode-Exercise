/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder res=new StringBuilder();
        serialize(res,root);
        return new String(res);
    }
    private void serialize(StringBuilder res, TreeNode root){
        if(root==null) {res.append("#").append(" "); return;}
        res.append(root.val+" ");
        serialize(res,root.left);
        serialize(res,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0 || data.equals("")) return null;
        String[] stringdata=data.split(" ");
       index=0;
        return deserializeTree(stringdata);
       
    }
    
    private TreeNode deserializeTree(String[] data){
        if(index==data.length || data[index].equals("#")) return null;
        TreeNode root=new TreeNode(Integer.valueOf(data[index]));
        index++;
        root.left=deserializeTree(data);
        index++;
        root.right=deserializeTree(data);
        return root;
        
    }  
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));