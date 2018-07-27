class Solution {
    public int lengthOfLongestSubstring(String s) {
         boolean[] set = new boolean[256];
        int len = 0;
        int h = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            while(set[c]) {
                set[s.charAt(h)] = false;
                h++;
            }
            len = Math.max(len, i - h + 1);
            set[c] = true;
        }
        return len;
    }
}