class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n=A.length;
        if(n==0) return 0;
        Map<Integer,Integer> map1=new HashMap();
        Map<Integer,Integer> map2=new HashMap();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                map1.put(A[i]+B[j],map1.getOrDefault(A[i]+B[j],0)+1);
        
        int res=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(map1.containsKey(-C[i]-D[j])) res+=map1.get(-C[i]-D[j]);
        return res;
        
    }
}