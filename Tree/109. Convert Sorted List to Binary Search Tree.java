class Solution {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode rec=head;
        int cnt=0;
        while(rec!=null){
            cnt++;
            rec=rec.next;
        }
        cur=head;
        return helper(0,cnt-1);
    }
    
    private TreeNode helper (int start,int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode left=helper(start,mid-1);
        TreeNode root=new TreeNode(cur.val);
       cur=cur.next;
        root.left=left;
        root.right=helper(mid+1,end);
        return root;
    }
}