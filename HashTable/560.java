class Solution {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        Map<Integer,Integer> map=new HashMap();
        map.put(0,1);
        int n=nums.length;
        int cnt=0;
        for(int num:nums){
            cnt+=num;
            if(map.containsKey(cnt-k)) res+=map.get(cnt-k);
            map.put(cnt,map.getOrDefault(cnt,0)+1);
        }
        return res;
        
    }
}