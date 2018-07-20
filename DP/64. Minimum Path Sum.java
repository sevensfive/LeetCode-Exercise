class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[] dp=new int[n];
        dp[0]=grid[0][0];
        for(int i=1;i<n;i++)
            dp[i]=grid[0][i]+dp[i-1];
        for(int i=1;i<m;i++)
            for(int j=0;j<n;j++){
                if(j==0) dp[j]=grid[i][j]+dp[j];
                else dp[j]=Math.min(dp[j],dp[j-1])+grid[i][j];
            }
        return dp[n-1];
    }
}