/**
 * Created by sunhongbo on 17/9/19.
 */
public class ReorderList {
    public static void main(String[] args) {
        // 1234567    1726354
        // 1723456   12345
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        ListNode result = reorderList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode slow = head; ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 拆分成两个链表
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);
        ListNode first = head;
        ListNode next;
        while (second != null) {
            next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
        }
        return head;
    }


    // 单链表逆置
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            // 下一次要摘头结点的链表
            next = head.next;
            // 摘出当前节点
            head.next = prev;
            // prev存储头结点
            prev = head;
            // head指向下一次要操作的链表
            head = next;
        }
        return prev;
    }
}
