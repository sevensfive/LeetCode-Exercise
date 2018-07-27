class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] len=new int[nums.length];
        int[] cnt=new int[nums.length];     
        int res=0,maxlen=0;
        
        for(int i=0;i<nums.length;i++){
            len[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(len[j]+1==len[i]) cnt[i]+=cnt[j];
                    if(len[j]+1>len[i]) {cnt[i]=cnt[j];len[i]=len[j]+1;}
                }
            }
            if(maxlen<len[i]){
                maxlen=len[i];
                res=cnt[i];
            }
            else if(maxlen==len[i]){
                res+=cnt[i];
            }
        }
        return res;
    }
}