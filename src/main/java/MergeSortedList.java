import java.util.List;

/**
 * Created by sunhongbo on 16/4/22.
 */
public class MergeSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(8);
        l2.next.next.next = new ListNode(13);
        ListNode res = MergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    //3->5->6->9
    //1->7->8->13
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                p.next = temp1;
                temp1 = temp1.next;
            }else {
                p.next = temp2;
                temp2 = temp2.next;
            }
            p = p.next;
        }
        if (temp1 != null) p.next = temp1;
        if (temp2 != null) p.next = temp2;
        return res.next;
    }

    public static ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0); //这两行是重点
        ListNode res = p; //
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val >= temp2.val) {
                res.next = temp2;
                temp2 = temp2.next;
            } else {
                res.next = temp1;
                temp1 = temp1.next;
            }
            res = res.next;
        }
        if (temp2 != null) res.next = temp2;
        if (temp1 != null) res.next = temp1;
        return p.next;
    }
}
