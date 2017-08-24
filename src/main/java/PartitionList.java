/**
 * Created by sunhongbo on 16/6/1.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partition(head, 3);
    }
    //1->4->3->2->5->2
    public static ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1; //prev存储小于x的链表
        ListNode p2 = fakeHead2; //p2存储大于x的链表

        while(p != null){
            if(p.val < x){
                p = p.next;
                prev = prev.next;
            }else{
                p2.next = p;
                prev.next = p.next;

                p = prev.next;
                p2 = p2.next;
            }
        }

        // close the list
        p2.next = null;

        prev.next = fakeHead2.next;

        return fakeHead1.next;
    }
}
