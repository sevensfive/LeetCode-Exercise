class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String a,String b){
                return b.length()-a.length();
            }
        });
       
        Set<String> dup=getdup(strs);         
        for(int i=0;i<strs.length;i++){          
           if(!dup.contains(strs[i])){
                if(i == 0) return strs[0].length();
               for(int j=0;j<i;j++){
                   if(issub(strs[j],strs[i])) break;
                   if(j==i-1) return strs[i].length();
               }
                   
           }

            
        }
      return -1;
    }
    
    private Set<String> getdup(String[] strs){
        Set<String> dup=new HashSet();
        Set<String> st=new HashSet();
        for(String str:strs){
            if(st.contains(str)) dup.add(str);
            st.add(str);
        }
        return dup;
    }
    
    private boolean issub(String a,String b){
        int idx=-1;
        for(char c:b.toCharArray()){
            idx=a.indexOf(c,idx+1);
            if(idx<0) return false;
        }
        return true;
    }
}