/**
 * Created by sunhongbo on 16/3/30.
 */
public class DelLinkNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(8);
        deleteNode(listNode.next);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
    public static void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        //ListNode tmp = new ListNode(0);
        //while (node.next != null) {
        //    tmp.val = node.val;
        //    node.val = node.next.val;
        //    node.next.val = tmp.val;
        //    node = node.next;
        //}
    }
}
