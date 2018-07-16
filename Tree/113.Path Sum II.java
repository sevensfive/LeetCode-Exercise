class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res=new LinkedList();
        if(root==null) return res;
        LinkedList<Integer> list=new LinkedList();
        helper(list,root,sum);
        return res;
    }
    
    private void helper(LinkedList<Integer> list,TreeNode root,int sum){
        if(root==null) return;
        list.add(root.val);
        if(sum==root.val && root.left==null && root.right==null){         
            res.add(new LinkedList(list));            
        }else{
            helper(list,root.left,sum-root.val);
            helper(list,root.right,sum-root.val);
        }       
        list.remove(list.size()-1);
    }
    
}