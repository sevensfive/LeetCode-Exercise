class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;        
        int i=0;
        for(int j=1;j<nums.length;j++){
            while(j<nums.length && nums[j]==nums[j-1]) j++;
            if(j<nums.length) nums[++i]=nums[j];
        }
        return i+1;
    }
}