
/////////////////https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
class Solution {
    ////////////////////SOLUTION 1: DFS
    String[] map;
    public List<String> letterCombinations(String digits) {
        List<String> res=new LinkedList();
        if(digits==null || digits.length()==0) return res;
        map=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(res,digits,"",0);
        return res;
    }
    
    private void helper(List<String> res,String digits,String tmp,int len){
        if(len==digits.length()){
            res.add(new String(tmp));
            return;
        }
        String a=map[digits.charAt(len)-'0'];
        for(char c:a.toCharArray()){
            helper(res,digits,tmp+c,len+1);
        }
        
    }

    ///////////////////////////////////solution 2:BFS
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res=new LinkedList();
        if(digits==null || digits.length()==0) return res;
        String[] map=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for(int i=0;i<digits.length();i++){
            String nowadd=map[digits.charAt(i)-'0'];
            while(res.peekFirst().length()==i){
                String tmp=res.pollFirst();
                for(int j=0;j<nowadd.length();j++)
                    res.add(tmp+nowadd.charAt(j));
            }
            
        }
         return res;          
    }
}