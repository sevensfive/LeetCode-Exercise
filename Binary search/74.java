class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=m*n-1;
        while(i<j){
            int mid=(i+j)/2;
            
            if(matrix[mid/n][mid%n]<target) i=mid+1;
            else if(matrix[mid/n][mid%n]>target) j=mid;
            else return true;
        }
        return matrix[i/n][i%n]==target;
    }
}