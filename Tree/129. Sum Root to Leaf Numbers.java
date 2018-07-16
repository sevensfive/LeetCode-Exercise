class Solution {
    int res=0;
    public int sumNumbers(TreeNode root) {    
        helper(root,0);
        return res;
    }
    private void helper(TreeNode root,int curnum){
        if(root==null) return;
        int tmp=curnum;
        curnum=curnum*10+root.val;
        if(root.left==null && root.right==null) {
            res+=curnum;
        }else{
            helper(root.left,curnum);
            helper(root.right,curnum);
        }
        curnum=tmp;
        
    }    
}