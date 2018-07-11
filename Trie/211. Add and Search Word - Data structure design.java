class WordDictionary {
    class Node{
        Node[] next;
        boolean word;
        Node(){
            next=new Node[26];
            word=false;
        }
    }
    Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur=root;
        for(char c:word.toCharArray()){
            if(cur.next[c-'a']==null) cur.next[c-'a']=new Node();
            cur=cur.next[c-'a'];
        }
        cur.word=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Node cur=root;
        return search(word,0,root);       
    }
    private boolean search(String word,int i,Node node){
        if(i==word.length()){
            return node.word;
        } 
       if(word.charAt(i)=='.'){
            for(int j=0;j<26;j++){
                if(node.next[j]!=null && search(word,i+1,node.next[j])) return true; 
            }
            return false;
        }           
        if(node.next[word.charAt(i)-'a']==null) return false;
            return search(word,i+1,node.next[word.charAt(i)-'a']);
        
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */