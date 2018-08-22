class Solution {
    public int findMin(int[] nums) {
        int start=0,end=nums.length-1;
        int l=start,r=end;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<nums[end]) r=mid;
            else if(nums[mid]>nums[end]) l=mid+1;
            else r--;
        }
        return nums[l];
    }
}