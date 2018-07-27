class Solution {
    public int findLength(int[] A, int[] B) {
        if(A==null || B==null || A.length==0 || B.length==0) return 0;
        int m=A.length,n=B.length;
        int[] dp=new int[n+1];
        int res=0;
        for(int i=1;i<=m;i++)
            for(int j=n;j>0;j--){
                if(A[i-1]==B[j-1]) {dp[j]=1+dp[j-1];res=Math.max(res,dp[j]);}
                else dp[j]=0;
            }
        return res;
                
    }
}