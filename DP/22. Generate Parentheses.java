class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new LinkedList();
        if(n<=0) return res;
        helper(res,"",n,0,0);
        return res;
    }
    private void helper(List<String> res,String build,int n,int left,int right){
       
        if(build.length()==2*n) {
            res.add(build);
            return;
        }
        
        if(left<n)
            helper(res,build+"(",n,left+1,right);
        if(right<left)
            helper(res,build+")",n,left,right+1);
        
    }
}