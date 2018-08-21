class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=-1;
        res[1]=-1;
        if(nums==null || nums.length==0 || target<nums[0] || target>nums[nums.length-1]) return res;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>=target) right=mid;
            else left=mid+1;
        }
        if(nums[left]!=target) return res;
        res[0]=left;
        
        right=nums.length-1;
        while(left<right){
            int mid=(left+right+1)/2;
            if(nums[mid]<=target) left=mid;
            else right=mid-1;
        }
        res[1]=right;
        return res;
        
    }
}