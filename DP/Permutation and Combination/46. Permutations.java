class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> res=new LinkedList();
        if(nums==null || nums.length==0) return res;       
        helper(res,new LinkedList<>(),nums);
        return res;
    }
    private void helper(List<List<Integer>> res,LinkedList<Integer> list,int[] nums){
        if(list.size()==nums.length){
            res.add(new LinkedList(list));
            return;
        }
      for(int i=0;i<nums.length;i++){
          if(list.contains(nums[i])) continue;
          list.add(nums[i]);
          helper(res,list,nums);
          list.remove(list.size()-1);
      }
    }
    
}