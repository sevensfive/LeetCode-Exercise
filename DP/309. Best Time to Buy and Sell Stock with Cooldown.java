class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int n=prices.length;
        int[][] res=new int[n][3];
        res[0][0]=-prices[0];
        res[0][1]=0;
        res[0][2]=0;
        for(int i=1;i<n;i++){
            res[i][0]=Math.max(res[i-1][0],res[i-1][2]-prices[i]);
            res[i][1]=Math.max(res[i-1][1],res[i-1][0]+prices[i]);
            res[i][2]=Math.max(res[i-1][2],res[i-1][1]);
        }
        return Math.max(0,Math.max(res[n-1][2],res[n-1][1])) ;
    }
}