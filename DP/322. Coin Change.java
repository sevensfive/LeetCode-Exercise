class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length && coins[j]<=i;j++){
                if(dp[i-coins[j]]!=-1) dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }              
            
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}