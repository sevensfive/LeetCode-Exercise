class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        if(word1==null || word1.length()==0) return word2.length();
        if(word2==null || word2.length()==0) return word1.length();
        int m=word1.length(),n=word2.length();
        int[] dp=new int[n+1];
        int pre=-1,tmp=-1;
        
        for(int i=1;i<=n;i++) dp[i]=i;
        
        for(int i=1;i<=m;i++){
            pre=dp[0];
            dp[0]=i;
            for(int j=1;j<=n;j++){
                tmp=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[j]=pre;
                else dp[j]=Math.min(pre,Math.min(dp[j-1],dp[j]))+1;
                pre=tmp;
            }
        }
        return dp[n];
    }
}