/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        while(head!=null){
            ListNode next=head.next;
            ListNode p=dummy;
            while(p.next!=null && p.next.val<=head.val) p=p.next;
            
            head.next=p.next;
            p.next=head;
            head=next;
        }
        return dummy.next;
    }
}