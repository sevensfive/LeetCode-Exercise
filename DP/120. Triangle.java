class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[] dp=new int[m];
        for(int i=0;i<m;i++)
            dp[i]=triangle.get(m-1).get(i);
        
        for(int j=m-2;j>=0;j--)
            for(int i=0;i<=j;i++)
                dp[i]=triangle.get(j).get(i)+Math.min(dp[i],dp[i+1]);
        return dp[0];          
        
    }
}