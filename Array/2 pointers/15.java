class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> res=new LinkedList();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        int n=nums.length;
        int left,right,sum;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            left=i+1;right=n-1;
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum<0) left++;
                else right--;
            }
        }
        return res;
    }
}