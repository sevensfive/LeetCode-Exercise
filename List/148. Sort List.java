/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        if(head.next.next==null){
            if(head.val<head.next.val) return head;
            else {
                ListNode tmp=head.next;
                tmp.next=head;
                head.next=null;
                return tmp;
            }
        }
        
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newstart=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(newstart);
        return merge(left,right);
    }
    
    private ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        while(left!=null && right!=null){
            if(right.val<left.val){
                node.next=right;
                right=right.next;            
            }else{
                node.next=left;
                left=left.next;              
            }    
             node=node.next;
        }
        if(left!=null) node.next=left;
        else if(right!=null) node.next=right;
        
        return dummy.next;
    }
  
}