/**
 * Created by sunhongbo on 16/4/22.
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }



    //1->2->3->4
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head.next;
        ListNode q = head.next.next;
        p.next = head;
        head.next = swapPairs(q);
        return p;
    }

}