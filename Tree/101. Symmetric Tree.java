public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {

    if (root == null) return true;
    return helper(root.left, root.right);
}

public static boolean helper(TreeNode p, TreeNode q) {

    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;

    return helper(p.left, q.right) && helper(p.right, q.left);
}

////////////////////////////////////////////////////////////////////////方法2：
public boolean isSymmetric2(TreeNode root) {
    if(root==null) return true;
     Queue<TreeNode> que=new LinkedList();
     que.add(root);
     que.add(root);
     
     while(!que.isEmpty()){
         TreeNode t1=que.poll();
         TreeNode t2=que.poll();
         if(t1==null && t2==null) continue;
         if(t1==null || t2==null) return false;
         if(t1.val!=t2.val) return false;
         que.add(t1.left);
         que.add(t2.right);
         que.add(t1.right);
         que.add(t2.left);
     }
     return true;
 }
 
 private boolean helper(TreeNode t1,TreeNode t2){
     if(t1==null && t2==null) return true;
     if(t1==null || t2==null) return false;
     if(t1.val!=t2.val) return false;
     return helper(t1.left,t2.right) && helper(t1.right,t2.left);
 }


}