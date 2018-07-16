class Solution {
    int n=0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> res=new HashMap<>();
        res.put(0,1);
        helper(root, 0, sum, res);
        return n;
    }
    
    private void helper(TreeNode root,int cnt,int sum,Map<Integer,Integer> res){
        if(root==null) return;
        cnt=cnt+root.val;
        
        if(res.containsKey(cnt-sum)) n=n+res.get(cnt-sum); // 注意这个判断要在前面
         
        res.put(cnt,res.getOrDefault(cnt,0)+1);
        helper(root.left,cnt,sum,res);
        helper(root.right,cnt,sum,res);
        res.put(cnt,res.get(cnt)-1);    
    }
    
}