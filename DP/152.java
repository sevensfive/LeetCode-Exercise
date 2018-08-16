class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=nums[0];
        int curmin=nums[0],curmax=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int tmp=curmin;
                curmin=curmax;
                curmax=tmp;
            }
            curmin=Math.min(curmin*nums[i],nums[i]);
            curmax=Math.max(curmax*nums[i],nums[i]);
            max=Math.max(max,curmax);
        }
        return max;
    }
}