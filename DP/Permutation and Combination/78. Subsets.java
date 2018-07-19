class Solution {
    //////////////BFS
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        List<Integer> list=new ArrayList();
        res.add(list);
        helper(res,nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,int[] nums,int index){
        if(index==nums.length) return;
        int len=res.size();
        for(int i=0;i<len;i++){
            List<Integer> tmp=new ArrayList(res.get(i)); 
            tmp.add(nums[index]);
            res.add(tmp);
        }
        helper(res,nums,index+1);
    }

    ////////////////DFS
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        List<Integer> list=new ArrayList();
        res.add(list);
        helper(res,list,nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int start){
        if(start>=nums.length) return;
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            res.add(new ArrayList(list));
            helper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
        
    }
}
