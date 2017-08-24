/**
 * Created by sunhongbo on 16/4/15.
 */
public class RemoveDulplicateSortl {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(1);
        //head.next.next = new ListNode(1);
        head = deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }//1->1->2->3
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
