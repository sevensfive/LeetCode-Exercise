class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n=wall.size();
        Map<Integer,Integer> map=new HashMap();
        int max=0;
        for(List<Integer> row:wall){
            int cnt=0;
            for(int i=0;i<row.size()-1;i++){
                cnt+=row.get(i);
                int cur=map.getOrDefault(cnt,0)+1;
                map.put(cnt,cur);
                max=Math.max(max,cur);
            }     
        }
        return n-max;
    }
}