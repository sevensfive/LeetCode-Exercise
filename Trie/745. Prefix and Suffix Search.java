class WordFilter {
    class TrieNode{
        TrieNode[] next;
        List<Integer> list;
        TrieNode(){
            next=new TrieNode[26];
            list=new ArrayList();
        }
    }
    TrieNode pre;
    TrieNode suf;

    public WordFilter(String[] words) {
        pre=new TrieNode();
        suf=new TrieNode();
        
        for(int i=0;i<words.length;i++){
            addpre(pre,words[i],i);
            addsuf(suf,words[i],i);
        }      
    }
    private void addpre(TrieNode pre,String word,int index){
        TrieNode node=pre;
        node.list.add(index);
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(node.next[c-'a']==null) node.next[c-'a']=new TrieNode();
            node=node.next[c-'a'];
            node.list.add(index);
        }
    }
    private void addsuf(TrieNode suf,String word,int index){
        TrieNode node=suf;
        node.list.add(index);
        for(int i=word.length()-1;i>=0;i--){
            char c=word.charAt(i);
            if(node.next[c-'a']==null) node.next[c-'a']=new TrieNode();
            node=node.next[c-'a'];
            node.list.add(index);
        }
    }
    
    public int f(String prefix, String suffix) {
       TrieNode pp=pre;
        for(int i=0;i<prefix.length() && pp!=null;i++){
            char c=prefix.charAt(i);
            pp=pp.next[c-'a'];
        }
        TrieNode ss=suf;
       for(int i=suffix.length()-1;i>=0 && ss!=null;i--){
           char c=suffix.charAt(i);
           ss=ss.next[c-'a'];
       }
        if(pp==null || ss==null) return -1;
        int i=pp.list.size()-1,j=ss.list.size()-1;
        while(i>=0 && j>=0){
            if(pp.list.get(i)>ss.list.get(j)) i--;
            else if(pp.list.get(i)<ss.list.get(j)) j--;
            else return pp.list.get(i);
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */