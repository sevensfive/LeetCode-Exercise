class Solution {
    public int scoreOfParentheses(String S) {
        int mul=0,ans=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(') mul+=mul==0?1:mul;
            else{
                if(S.charAt(i-1)=='(') ans+=mul;
                mul=mul/2;
            }
        }
        return ans;
    }
}