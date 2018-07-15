class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        int n=nums.length;
        return helper(nums,0,n-1);
    }
    
    private TreeNode helper(int[] nums,int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,start,mid-1);
        root.right=helper(nums,mid+1,end);
        return root;
        
    }
    
}