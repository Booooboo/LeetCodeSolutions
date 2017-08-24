/**
 * Created by sunhongbo on 16/6/8.
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(2);
        example.next.next.next = new ListNode(1);
        //example.next.next.next.next = new ListNode(1);
        ListNode res = removeElements(example, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode result = new ListNode(0);
        while (head != null && head.val == val) {
            head = head.next;
        }
        result.next = head;
        ListNode pre = head;
        while (head != null && pre != null) {
            head = head.next;
            if (head != null && head.val == val) {
                ListNode temp = head.next;
                pre.next = temp;
            }
            if (pre.next != null && pre.next.val != val) {
                pre = pre.next;
            }
        }
        return result.next;
    }

    public static ListNode removeElements1(ListNode head, int val) {
        ListNode result = new ListNode(0); //用于返回用
        result.next = head;
        ListNode p = result; // 用于操作链表用
        while (p.next != null) {
            if (p.next.val == val) {
                ListNode next = p.next; // 定义一个临时链表用于存储 目标节点后面的链表
                p.next = next.next;
            } else {
                p = p.next; // 直接查询下一个链表节点
            }
        }
        return result.next;
    }
}
