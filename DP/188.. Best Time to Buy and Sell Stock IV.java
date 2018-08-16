class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k<=0 || prices==null || prices.length<2) return 0;
        int n=prices.length;
        if(k>=n/2) return quickres(prices);
        
        int[] T0=new int[k+1];
        int[] T1=new int[k+1];
        Arrays.fill(T1,Integer.MIN_VALUE);
        for(int price:prices){
            for(int j=k;j>0;j--){
                T0[j]=Math.max(T0[j],T1[j]+price);
                T1[j]=Math.max(T1[j],T0[j-1]-price);
            }
        }
        return T0[k];
    }
    private int quickres(int[] prices){
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) res+=prices[i]-prices[i-1];
        }
        return res;
    }
}