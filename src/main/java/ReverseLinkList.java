import java.util.List;

/**
 * Created by sunhongbo on 16/4/7.
 */
public class ReverseLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode exa = reverseListi(head);
        while (exa != null) {
            System.out.println(exa.val);
            exa = exa.next;
        }
    }
    //递归
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode n = reverseList(p);
        p.next = head;
        return n;
    }
    //迭代 1 -> 2 - > 3 变成 1 <- 2 <- 3
    public static ListNode reverseListi(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        ListNode nxt;
        while (p != null) {
            nxt = p.next;
            p.next = pre;
            pre = p;
            p = nxt;
        }
        return pre;
    }
}
