class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2) return false;
        Map<Integer,Integer> map=new HashMap();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int cur=k==0?sum:sum%k;
            if(map.containsKey(cur)){
                if(i-map.get(cur)>1) return true;
            }else{
                map.put(cur,i);
            }
        }
        return false;
    }
}