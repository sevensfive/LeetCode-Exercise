class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode premiddle=slow;
        ListNode precur=slow.next;
        while(precur.next!=null){
            ListNode cur=precur.next;
            precur.next=cur.next;
            cur.next=premiddle.next;
            premiddle.next=cur;
        }
        ListNode p1=head;
        ListNode p2=premiddle.next;
        while(p1!=premiddle){
            premiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=premiddle.next;
        }
        
    }
}