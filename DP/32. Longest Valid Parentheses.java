class Solution { 
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0) return 0;
        int start=0,val=0,ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') val++;
            else val--;
            if(val<0){
                start=i+1;
                val=0;
            }
            else if(val==0){
                ans=Math.max(ans,i-start+1);
            }
        }
        
        val=0;
        start=n-1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')') val++;
            else val--;
            if(val<0){
                start=i-1;
                val=0;
            }
            else if(val==0){
                ans=Math.max(ans,start+1-i);
            }
        }
        
        return ans;
    }
    
}