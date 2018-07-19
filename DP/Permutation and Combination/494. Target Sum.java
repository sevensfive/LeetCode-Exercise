class Solution {
    ///////////////////////recursion: toooooo slow!
    int cnt;
    public int findTargetSumWays(int[] nums, int S) {
        cnt=0;
        helper(nums,S,0,0);
        return cnt;
    }
    private void helper(int[] nums,int target,int cursum,int idx){
        if(idx==nums.length){
            if(cursum==target) cnt++;
            return;
        }   
            helper(nums,target,cursum+nums[idx],idx+1);
            helper(nums,target,cursum-nums[idx],idx+1);       
    }
    /////////////////////////
        //     The original problem statement is equivalent to:
        // Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
        // Let P be the positive subset and N be the negative subset
        // For example:
        // Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
        // Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
        // Then let's see how this can be converted to a subset sum problem:

        // sum(P) - sum(N) = target
        // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        // 2 * sum(P) = target + sum(nums)
        // So the original problem has been converted to a subset sum problem as follows:
        // Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

        
   
            public int findTargetSumWays2(int[] nums, int S) {
                int sum=0;
                for(int num:nums)
                    sum+=num;
                if(sum<S || (sum+S)%2!=0) return 0;
                int target=(sum+S)/2;
                int[] dp=new int[target+1];
                dp[0]=1;
                for(int num:nums){
                    for(int i=target;i>=num;i--)
                        dp[i]+=dp[i-num];
                }
                return dp[target];
            }
        
}