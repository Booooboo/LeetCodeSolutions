import java.util.Locale;

/**
 * Created by sunhongbo on 16/4/11.
 */
public class OddEvenLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        oddEvenListB(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    //1->2->3->4->5->6
    //1->3->2->4->5->6
    //
    //1->3->5->2->4->6
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next.next;
        ListNode s;
        while (q != null) {
            s = q.next;
            //交换
            ListNode temp = p.next;
            while (temp.next != q) {
                temp = temp.next;
            }
            temp.next = q.next;
            q.next = p.next;
            p.next = q;

            p = q;
            if (s == null) {
                q = null;
            } else {
                q = s.next;
            }
        }
        return head;
    }

    //leetcode标准答案
    public static ListNode oddEvenListB(ListNode head) {
        if (head == null) return head;
        ListNode odd = head;
        ListNode Even = head.next;
        ListNode EvenHead = Even;
        while (Even != null && Even.next != null) {
            odd.next = Even.next;
            odd = odd.next;
            Even.next = odd.next;
            Even = Even.next;
        }
        odd.next = EvenHead;
        return head;
    }

    //将奇偶链表区分
    public static ListNode oddEvenList1(ListNode head) {
        //输入合法性判断
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode odd = new ListNode(0);  //奇数链表：仅存放奇数位置节点
        ListNode oddCurr = odd;          //奇数链表的链表尾节点
        ListNode even = new ListNode(0); //偶数链表：仅存放偶数位置节点
        ListNode evenCurr = even;        //偶数链表的链表尾节点
        //分别生成奇数链表和偶数链表
        ListNode tmp = head;
        int counter = 0;
        while (tmp != null) {
            counter++;
            if (counter % 2 != 0) {
                oddCurr.next = new ListNode(tmp.val);
                oddCurr = oddCurr.next;
            } else {
                evenCurr.next = new ListNode(tmp.val);
                evenCurr = evenCurr.next;
            }
            tmp = tmp.next;
        }
        oddCurr.next = even.next; //偶数链表接在奇数链表后面
        return odd.next;
    }
}


