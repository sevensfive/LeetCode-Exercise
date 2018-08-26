class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        int n=nums.length;
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        ArrayList<Integer>[] bucket=new ArrayList[n+1];
        
        for(int num:map.keySet()){
            int freq=map.get(num);
            if(bucket[freq]==null)
                bucket[freq]=new ArrayList();
            bucket[freq].add(num);
        }
        List<Integer> res=new ArrayList();
        for(int i=n;i>=0 && res.size()<k;i--){
            if(bucket[i]!=null)
                res.addAll(bucket[i]);
        }
        return res;
    }
}