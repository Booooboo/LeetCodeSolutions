/**
 * Created by sunhongbo on 17/8/28.
 */
public class ReverseNodeskGroup {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode head = reverseKGroup(l1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    // 012345  021345  032145
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode res = tmp;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int count = len/k;
        while (count != 0) {
            count--;
            int inner = 0;
            while (inner < k-1) {
                inner++;
                ListNode a = head.next.next;
                ListNode b = tmp.next;
                tmp.next = head.next;
                tmp.next.next = b;
                head.next = a;
            }
            tmp = head;
            head = head.next;
        }
        return res.next;
    }
}
