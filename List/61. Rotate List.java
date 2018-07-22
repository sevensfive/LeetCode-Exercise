/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode p=head;
        int cnt=0;
        while(p!=null){
            cnt++;
            p=p.next;
        }
         k=k%cnt;
        if(k==0) return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        
        for(int i=0;i<k;i++)
            fast=fast.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
      
        ListNode res=slow.next;
        slow.next=null;
        fast.next=dummy.next;
        return res;
        
    }
}