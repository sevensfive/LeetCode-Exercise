public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode cur=head;
        while(cur!=null){       
            RandomListNode then=cur.next;
            RandomListNode copy=new RandomListNode(cur.label);          
            copy.next=then;
            cur.next=copy;
            cur=then;
        }
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        
        cur=head;
        RandomListNode dummy=new RandomListNode(0);
        dummy.next=head;
        RandomListNode pre=dummy;
        while(cur!=null){
            RandomListNode next=cur.next.next;
            pre.next=cur.next;
            pre=pre.next;
            cur.next=next;
            cur=cur.next;
        }
        return dummy.next;
        
    }
}