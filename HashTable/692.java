class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap();
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);
        
        int n=words.length;
        PriorityQueue<String>[] buckets=new PriorityQueue[n+1];
        for(String mapkey:map.keySet()){
            int freq=map.get(mapkey);
            if(buckets[freq]==null)
                buckets[freq]=new PriorityQueue();
            buckets[freq].add(mapkey);
        }
        
        List<String> res=new LinkedList();
        for(int i=n;i>=0;i--){
            if(buckets[i]!=null){
                int size=buckets[i].size()-1;
                for(int j=size;j>=0;j--){
                    res.add(buckets[i].remove());
                    if(res.size()==k) return res; 
                }
            }
        }
        return res;
    }
}