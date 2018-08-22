class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int up=0,down=m-1,left=0,right=n-1;
        int newup,newdown,newleft,newright;
        while(up<down || left<right){
            int l=left,r=right;
            while(l<r){
                int mid=(l+r+1)/2;
                if(matrix[up][mid]<=target) l=mid;
                else r=mid-1;
            }
            newright=l;
            
            l=left;r=right;
            while(l<r){
                int mid=(l+r)/2;
                if(matrix[down][mid]>=target) r=mid;
                else l=mid+1;
            }
            newleft=l;
            
            int u=up,d=down;
            while(u<d){
                int mid=(u+d)/2;
                if(matrix[mid][newright]>=target) d=mid;
                else u=mid+1;
            }
            newup=u;
            
             u=up;d=down;
            while(u<d){
                int mid=(u+d+1)/2;
                if(matrix[mid][newleft]<=target) u=mid;
                else d=mid-1;
            }
            newdown=u;
            
            if(up==newup && down==newdown && left==newleft && right==newright) return true;
            up=newup;
            down=newdown;
            left=newleft;
            right=newright;
        }
        return matrix[up][left]==target;
        
    }
}