class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2)
        return 0;
    Arrays.sort(envelopes,new Comparator<int[]>(){
        public int compare(int[] a,int[] b){
            return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];
        }
    });
        int m=envelopes.length;
        int[] dp=new int[m];
        dp[0]=envelopes[0][1];
        int most=1;
        for(int i=1;i<m;i++){
            int left=0,right=most;
            while(left<right){
                int mid=(left+right)/2;
                if(dp[mid]<envelopes[i][1]) left=mid+1;
                else right=mid;
            }
            dp[left]=envelopes[i][1];
            if(left==most) most++;
        }
        return most;
}}

