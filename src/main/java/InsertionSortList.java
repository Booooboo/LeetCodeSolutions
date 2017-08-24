/**
 * Created by sunhongbo on 16/6/2.
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);

        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        insertionSortList(head);
    }

    public static ListNode insertionSortList1(ListNode head) {

        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) { //往node里面添加节点,包括直接添加到后面的节点和添加到合适位置的节点
                node = node.next;
            }
            //把head的next以及之后的节点暂存在temp
            ListNode temp = head.next;
            head.next = node.next; // 把node.next以及后面的节点摘出来,跟当前head节点拼接起来
            node.next = head; //把带上head当前节点和node后面节点到所有节点放在dummy里的最后位置
            head = temp; //head重新指向剩下的节点
        }

        return dummy.next;
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
