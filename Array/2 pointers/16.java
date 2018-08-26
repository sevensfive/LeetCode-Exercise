class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i]+nums[n-1]+nums[n-2]<target){
                res=nums[i]+nums[n-1]+nums[n-2];
                continue;
            }
            if(nums[i]*3>target){
                int tmp=nums[i]+nums[i+1]+nums[i+2];
                return Math.abs(tmp-target)<Math.abs(res-target)? tmp:res;
            }        
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target)
                    return sum;
                else if(sum<target){
                    if(Math.abs(sum-target)<Math.abs(res-target)) res=sum;
                    left++;
                }
                else{
                   if(Math.abs(sum-target)<Math.abs(res-target)) res=sum;
                    right--; 
                }
                
            }
        }
        return res;
    }
}


