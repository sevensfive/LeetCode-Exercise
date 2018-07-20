public class Solution {
    ///////////////////////////DFS O(4^n)
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        
        Arrays.sort(nums);
        reverse(nums);
        
        return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }


    ///////////////////////////// backtracking + memorization
    public boolean makesquare2(int[] nums) {
        int n=nums.length;
        if(n<4) return false;
        int sum=0;
        for(int in:nums) {
            sum+=in;
        }
        if(sum%4!=0) return false;
        int target=sum/4;
        boolean visited[] =new boolean[n];
        int count=0;
        Arrays.sort(nums);
        reverse(nums);
        return canfind(target,target,visited,nums,0,count);
    }
    public boolean canfind(int target,int left,boolean [] visited,int[] nums,int start,int count) {
        if(left<0) return false;
        if(left==0) {
            count++;
            if(count==3) return true;
            else {
                return canfind(target,target,visited,nums,0,count);
            }
        }
        for(int i=start;i<nums.length;i++) {
            if(visited[i]) continue;
            if(i>start && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i]=true;
            if(canfind(target,left-nums[i],visited,nums,i+1,count))
                return true;
            visited[i]=false;
        }
        return false;
    }
    private void reverse2(int[] nums){
        int i=0,j=nums.length-1;
        while(i<j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }




}