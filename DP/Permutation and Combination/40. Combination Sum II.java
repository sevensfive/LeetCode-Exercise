class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new LinkedList();
        if(candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        helper(res,new LinkedList(),candidates,target,0);
        return res;
    }
    private void helper(List<List<Integer>> res,LinkedList<Integer> list,int[] candidates,int target,int start){
       if(target<0) return;
        if(target==0) {
            res.add(new LinkedList(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(res,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
    
}