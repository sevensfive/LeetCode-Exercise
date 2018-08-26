class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new LinkedList();
        if(s==null || s.length()==0 || p==null || p.length()==0 || s.length()<p.length()) return res;
       Map<Character,Integer> mp=new HashMap();
        for(char c:p.toCharArray())
            mp.put(c,mp.getOrDefault(c,0)+1);
        int i=0;
        int counter=mp.size();
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            if(mp.containsKey(c)){
                mp.put(c,mp.get(c)-1);
                if(mp.get(c)==0) counter--;
            }
            while(counter==0){
                if(j-i+1==p.length()) res.add(i);
                char a=s.charAt(i);
                if(mp.containsKey(a)){
                    mp.put(a,mp.get(a)+1);
                    if(mp.get(a)>0)  counter++;
                }                  
                i++;
            }
        }
        return res;
    }
}