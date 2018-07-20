class Solution {
    //////////////DFS
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length<k) return false;
        int sum=0;
        for(int num:nums)
            sum+=num;
        if(sum%k!=0) return false;
        Arrays.sort(nums);
        if(nums[0]>sum/k) return false;
        return helper(nums,new int[k],sum/k,sum/k,nums.length-1);
    }
    
    private boolean helper(int[] nums,int[] sums,int target,int left,int idx){
        if(idx==-1){
            for(int sum:sums)
                if(sum!=target) return false;
            return true;
        }
        for(int i=0;i<sums.length;i++){
            if(nums[idx]+sums[i]>target) continue;
            sums[i]+=nums[idx];
            if(helper(nums,sums,target,left-nums[idx],idx-1)) return true;
            sums[i]-=nums[idx];
        }
        return false;
    }
   ///////////////////// backtracking + memorization
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        if(nums==null || nums.length<k) return false;
        int sum=0;
        for(int num:nums)
            sum+=num;
        if(sum%k!=0) return false;
        Arrays.sort(nums);
        if(nums[0]>sum/k) return false;
        boolean[] mark=new boolean[nums.length];
        return helper(nums,mark,0,sum/k,sum/k,nums.length-1,k);
    }
    private boolean helper(int[] nums, boolean[] mark,int cnt,int target,int left,int idx,int k){
        if(left<0) return false;
        if(left==0){
            cnt++;
            if(cnt==k) return true;
            return helper(nums,mark,cnt,target,target,nums.length-1,k);
        }
        for(int i=idx;i>=0;i--){
            if(mark[i]) continue;
            if(i<idx && nums[i]==nums[i+1] && !mark[i+1]) continue;
            mark[i]=true;
            if(helper(nums,mark,cnt,target,left-nums[i],idx-1,k)) return true;
            mark[i]=false;
        }
        return false;
    }



}