/**
 * Created by sunhongbo on 16/6/16.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode exa = new ListNode(1);
        exa.next = new ListNode(2);
        exa.next.next = new ListNode(3);
        exa.next.next.next = new ListNode(4);
        ListNode res = reverseBetween(exa, 2, 4);
    }

    // 把从第m个 节点开始 依次插入到当前节点中
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        int i = 1;
        while (preNode.next != null && i < m) {
            preNode = preNode.next;
            i++;
        }
        if (i < m)
            return head;
        ListNode mNode = preNode.next;//2
        ListNode cur = mNode.next;//3
        while (cur != null && i < n) {
            ListNode next = cur.next;///4 // 先把 当前要被插入节点的 后面节点保存
            cur.next = preNode.next; // 把 当前要被插入节点的 后面节点 设置成 从m节点到当前节点的所有节点
            preNode.next = cur; // 把当前待插入节点插入要 第m-1节点后面
            mNode.next = next; //把 从m节点到当前节点的所有节点 中 第m节点后的 节点替换成 第一步保存的后续结点
            cur = next; // 当前节点 指向被插入节点的下一个节点
            i++;
        }
        return dummy.next;
    }
}
