class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new LinkedList();
        helper(res,new LinkedList(),k,n,1);
        return res;
    }
    private void helper(List<List<Integer>> res,LinkedList<Integer> list,int k,int target,int start){
        if(target<0) return;
        if(list.size()==k){
            if(target==0) res.add(new LinkedList(list));
            return;
        }
        for(int i=start;i<10;i++){
            list.add(i);
            helper(res,list,k,target-i,i+1);
            list.remove(list.size()-1);
        }
        
    }
}