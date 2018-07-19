class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null || nums.length==0) return res;
       Arrays.sort(nums);
        boolean[] visited=new boolean[nums.length];
        helper(res,nums,new ArrayList(),visited);
        return res;
    }
    private void helper(List<List<Integer>> res,int[] nums,ArrayList<Integer> list,boolean[] visited){
        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i]=true;
            helper(res,nums,list,visited);
            visited[i]=false;
            list.remove(list.size()-1);
        }
    }
    
}