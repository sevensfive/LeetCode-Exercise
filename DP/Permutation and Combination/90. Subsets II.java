class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> res=new LinkedList();
       List<Integer> list=new LinkedList();
        res.add(list);
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
       
        helper(res,list,nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int start){
        if(start>=nums.length) return;
        
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);            
            res.add(new ArrayList(list));
            helper(res,list,nums,i+1);    
            list.remove(list.size()-1);
        }
        
    }
}