public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> que=new LinkedList();
        que.add(root);
        StringBuilder res=new StringBuilder();
        
        while(!que.isEmpty()){
         
                TreeNode tmp=que.poll();
                if(tmp==null) res.append("null ");
                else{
                    res.append(tmp.val+" ");
                    que.add(tmp.left);
                    que.add(tmp.right);
                }                
            
        }
       return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] s=data.split(" ");       
        TreeNode root=new TreeNode(Integer.valueOf(s[0]));
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
       for(int i=1;i<s.length;i++){
           TreeNode tmp=que.poll();
           if(!s[i].equals("null")){
               tmp.left=new TreeNode(Integer.valueOf(s[i]));
               que.add(tmp.left);
           }
           i++;
           if(!s[i].equals("null")){
               tmp.right=new TreeNode(Integer.valueOf(s[i]));
               que.add(tmp.right);
           }
       }
      
        return root;
    }
}