public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode a=headA;
        ListNode b=headB;
        int cnta=0,cntb=0;
        while(a!=null){
            cnta++;
            a=a.next;
        }
        while(b!=null){
            cntb++;
            b=b.next;
        }
        
        if(cnta>cntb){
            for(int i=0;i<cnta-cntb ;i++) headA=headA.next;
        }
        else if(cnta<cntb){
            for(int i=0;i<cntb-cnta ;i++) headB=headB.next;
        }
        
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
        
    }
}