class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] pa=pattern.toCharArray();
        String[] st=str.split(" ");
        if(pa.length!=st.length) return false;
        Map<Character,String> map=new HashMap();
        for(int i=0;i<pa.length;i++){
            char p=pa[i];
            String s=st[i];
            if(map.containsKey(p)){
                 if(!map.get(p).equals(s)) return false;
            }         
            else{
                if(map.containsValue(s)) return false;
                map.put(p,s);
            }
                
        }
        return true;
    }
}