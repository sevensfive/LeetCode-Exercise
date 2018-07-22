/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=0;i<m-1;i++)
            prev=prev.next;
        ListNode cur=prev.next;
        
        for(int i=m+1;i<=n;i++){
            ListNode then=cur.next;
            cur.next=then.next;
            then.next=prev.next;
            prev.next=then;
        }
        return dummy.next;
    }
}