
// 这个方法要比我最开始的要好。而且注意str是""时候的Corner case。
// 我一开始的方法就是以第一个为基准，一个个比下去。

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)       return null;
        if (strs.length == 0)   return "";
        
        String first = strs[0], last = strs[0];
        
        for (String str : strs) {
            if(str.equals("")) return "";
            if (str.compareTo(first) < 0)
                first = str;
            if (str.compareTo(last) > 0)
                last = str;
            if(first.charAt(0)!=last.charAt(0)) return "";
        }
       // System.out.println(first + " " + last);
        
        int i = 0, len = Math.min(first.length(), last.length());
        
        while (i < len && first.charAt(i) == last.charAt(i))
            i++;
        
        return first.substring(0, i);
    }
} 

