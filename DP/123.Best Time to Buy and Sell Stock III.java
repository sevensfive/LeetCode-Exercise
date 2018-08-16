class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int T20=0,T21=Integer.MIN_VALUE;
        int T10=0,T11=Integer.MIN_VALUE;
        for(int price:prices){
            T20=Math.max(T20,T21+price);
            T21=Math.max(T21,T10-price);
            T10=Math.max(T10,T11+price);
            T11=Math.max(T11,-price);
        }
        return T20;
    }
}