class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) return lowestCommonAncestor(root, q,p);
        return helper(root,p.val,q.val);
    }
    private TreeNode helper(TreeNode root,int low,int hi){
        if(root.val>=low && root.val<=hi) return root;
        if(root.val<low) return helper(root.right,low,hi);
        else return helper(root.left,low,hi);
        
    }
}