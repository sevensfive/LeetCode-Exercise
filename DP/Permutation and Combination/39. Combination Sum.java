class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new LinkedList();
        if(candidates==null || candidates.length==0) return res;
        helper(res,new LinkedList(),candidates,target,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int target,int start){
        if(target<0) return;
        if(target==0){
            res.add(new LinkedList(list));// add(new List(list))会报错，因为List is abstract and can't be initialized
            return;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,target-nums[i],i);
            list.remove(list.size()-1);
        }
        
    }
    
}