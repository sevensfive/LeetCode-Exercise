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
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<>();
        return helper(1,n);
    }
    private List<TreeNode> helper(int left,int right){   
        List<TreeNode> res=new ArrayList<>();
        if(left>right) {res.add(null);return res;}
        if(left==right){
           res.add(new TreeNode(left));
            return res;
        }
        for(int i=left;i<=right;i++){         
            List<TreeNode> leftlist=helper(left,i-1);
            List<TreeNode> rightlist=helper(i+1,right);
            for(TreeNode l:leftlist){              
                 for(TreeNode r:rightlist){
                    TreeNode root=new TreeNode(i);       
                    root.left=l;             
                    root.right=r;
                    res.add(root);
                }               
            }          
        }
        return res;
    }
}