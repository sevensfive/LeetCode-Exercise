// 单调栈
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        Stack<Integer> st=new Stack();
        int res=0;
        int i=0;
        for(;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int a=st.pop();
                if(st.isEmpty()) 
                    res=Math.max(res,heights[a]*i);
                else
                    res=Math.max(res,heights[a]*(i-st.peek()-1));
            }
            st.add(i);
        }
        
        while(!st.isEmpty()){
                int a=st.pop();
                if(st.isEmpty()) 
                    res=Math.max(res,heights[a]*i);
                else
                    res=Math.max(res,heights[a]*(i-st.peek()-1));
            }
        
        return res;
    }
}