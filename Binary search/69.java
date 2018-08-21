class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int left=1,right=x/2;
        if(left==right) return left;
        while(left<right){
            int mid=(right+left+1)/2;
            if(mid>x/mid) right=mid-1;
            else if(mid<x/mid) left=mid;
            else return mid;
        }
        return left;
    }
}