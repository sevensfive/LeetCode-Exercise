public class Solution {
    /////////////这个方法的空间复杂度不是O(1)!
    public void connect0(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> que=new LinkedList();
        que.add(root);
        
        while(!que.isEmpty()){
            int len=que.size();
            TreeLinkNode prev=null; // 一开始我写了TreeLinkNode prev。报错：may not be initialized
            for(int i=0;i<len;i++){
                TreeLinkNode tmp=que.poll();
                if(tmp.left!=null) que.add(tmp.left);
                if(tmp.right!=null) que.add(tmp.right);
                if(prev!=null) prev.next=tmp;
                prev=tmp;
            }
        }
        
    }
    //////////////////////方法2：
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    /////////////////////////space : O(1)
    public void connect2(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }


}}