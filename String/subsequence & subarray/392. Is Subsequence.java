class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null || s.length()==0) return true;
        if(t==null || t.length()==0 || t.length()<s.length()) return false;
        int m=s.length(),n=t.length();
        int j=0;
        for(int i=0;i<n;i++){
            if(s.charAt(j)==t.charAt(i)) j++;
            if(j==m) return true;
        }
        return j==m;
    }
}