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
    Map<String,Integer> mp;
    List<TreeNode> list;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        mp=new HashMap();
        list=new LinkedList();
        if(root==null) return list;
        helper(first(root));
        return list;
    }
    private TreeNode first(TreeNode root){
        if(root==null) return null;
        if(root.left!=null && root.right!=null) return root;
        if(root.left==null) return first(root.right);
        return first(root.left);
    }
    private String helper(TreeNode root){
        if(root==null) return "#";
        String st=root.val+helper(root.left)+helper(root.right);
        mp.put(st,mp.getOrDefault(st,0)+1);
        if(mp.get(st)==2) list.add(root);
        return st;
    }
    
    
}