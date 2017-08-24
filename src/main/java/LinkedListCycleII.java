/**
 * Created by sunhongbo on 16/5/23.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode temp = head.next = new ListNode(2);
        temp.next = new ListNode(0);
        ListNode temp1 = temp.next.next = new ListNode(-4);
        temp1.next = temp;
        System.out.println(detectCycle(head).val);
    }

    //fast和slow相遇后,让slow从起点走,fast一次一步走,相遇点是环起始点.
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        //while (slow != fast) {
        //    if (fast.next == null || fast.next.next == null) return null;
        //    slow = slow.next;
        //    fast = fast.next.next;
        //}
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ) {
                break;
            }
        }
        while (temp != slow) {
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }
}
