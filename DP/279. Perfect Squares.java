class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int tmp=i;
            for(int j=1;j*j<=i;j++)
                tmp=Math.min(tmp,dp[i-j*j]);
            dp[i]=1+tmp;
        }
        return dp[n];
    }
}