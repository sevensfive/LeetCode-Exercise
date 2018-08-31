class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n<=0 || primes==null ||primes.length==0) return 0;
        int k=primes.length;
        int[] roll=new int[n];
        roll[0]=1;
        int[] idx=new int[k];
        
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<k;j++)
                if(min>primes[j]*roll[idx[j]]) min=primes[j]*roll[idx[j]];
            roll[i]=min;
            for(int j=0;j<k;j++)
                if(primes[j]*roll[idx[j]]==min) idx[j]++;
        }
        return roll[n-1];
    }
}