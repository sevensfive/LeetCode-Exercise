/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) return true;
        if(s==null) return false;
        if(s.val==t.val && match(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean match(TreeNode s,TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val) return false;
        return match(s.left,t.left) && match(s.right,t.right);
    }
}