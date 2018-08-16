class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices==null || prices.length<2) return 0;
        int n=prices.length;
        int[] hold=new int[n];
        int[] unhold=new int[n];
        hold[0]=-prices[0];
        unhold[0]=0;
        
        for(int i=1;i<n;i++){
            hold[i]=Math.max(hold[i-1],unhold[i-1]-prices[i]);
            unhold[i]=Math.max(unhold[i-1],hold[i-1]+prices[i]-fee);
        }
        return Math.max(0,unhold[n-1]);
    }
}