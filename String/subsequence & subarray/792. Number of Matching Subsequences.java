class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if(S==null || S.length()==0 || words==null || words.length==0) return 0;
        int n=words.length;
        int res=0;
        Map<String,Boolean> mp=new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(mp.containsKey(words[i])) {if(mp.get(words[i])) res++;}
            else if(issub(words[i],S)) {res++;mp.put(words[i],true);}
            else mp.put(words[i],false);
        }
           
        return res;
    }
    private boolean issub(String word,String S){
        if(word.length()>S.length()) return false;
        int m=word.length(),n=S.length();
        int j=0;
        for(int i=0;i<n;i++){
            if(S.charAt(i)==word.charAt(j)) j++;
            if(j==m) return true;
        }
            return false;
        
    }
    
}