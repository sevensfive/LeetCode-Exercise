class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] st=preorder.split(",");
        int inorder=0,outorder=1;
        for(String s:st){
            if(outorder-inorder<1) return false;
            if(!s.equals("#")) outorder+=2;
            inorder++;           
        }
        return inorder==outorder;
    }
}