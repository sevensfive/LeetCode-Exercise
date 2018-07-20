class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;     
        for(int i : nums)
            sum += i;
              
        if(sum % 2 != 0) 
            return false;
                
        return helper(nums, nums.length-1, sum/2);
    }
    
    private boolean helper(int[] nums, int i, int sum) {
        if(sum == 0) 
            return true;
        
        if(i < 0 || sum < 0 || sum < nums[i]) 
            return false;
       
        return helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
    }
}