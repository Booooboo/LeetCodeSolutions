import java.util.List;

/**
 * Created by sunhongbo on 16/7/7.
 */
public class SortList {
    public static void main(String[] args) {

    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        int mid = count/2;
        ListNode l = head, r = null;
        ListNode p2 = head;
        int countHalf = 0;
        while (p2 != null) {
            countHalf++;
            ListNode next = p2.next;

            if (countHalf == mid) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }

        ListNode h1 = sortList(l);
        ListNode h2 = sortList(r);
        ListNode merge = merge(h1, h2);
        return merge;
    }

    public static ListNode merge(ListNode l, ListNode r) {
        ListNode h1 = l;
        ListNode h2 = r;
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                p.next = new ListNode(h2.val);
                h2 = h2.next;
                p = p.next;
            } else if (h2 == null) {
                p.next = new ListNode(h1.val);
                h1 = h1.next;
                p = p.next;
            } else {
                if (h1.val < h2.val) {
                    p.next = new ListNode(h1.val);
                    p = p.next;
                    h1 = h1.next;
                } else if (h1.val == h2.val) {
                    p.next = new ListNode(h1.val);
                    p.next.next = new ListNode(h1.val);
                    p = p.next.next;
                    h1 = h1.next;
                    h2 = h2.next;
                } else {
                    p.next = new ListNode(h2.val);
                    p = p.next;
                    h2 = h2.next;
                }
            }
        }
        return fakeHead.next;
    }


    public static ListNode mergeSortListInternet(ListNode head) {

        if (head == null || head.next == null)
            return head;

        // count total number of elements
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        // break up to two list
        int middle = count / 2;

        ListNode l = head, r = null;
        ListNode p2 = head;
        int countHalf = 0;
        while (p2 != null) { // 将链表分成两半
            countHalf++;
            ListNode next = p2.next;

            if (countHalf == middle) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }

        // now we have two parts l and r, recursively sort them
        ListNode h1 = mergeSortListInternet(l);
        ListNode h2 = mergeSortListInternet(r);

        // merge together
        ListNode merged = merge(h1, h2);

        return merged;
    }

    public static ListNode mergeInternet(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;

        ListNode fakeHead = new ListNode(100);
        ListNode pNew = fakeHead;

        while (p1 != null || p2 != null) {

            if (p1 == null) {
                pNew.next = new ListNode(p2.val);
                p2 = p2.next;
                pNew = pNew.next;
            } else if (p2 == null) {
                pNew.next = new ListNode(p1.val);
                p1 = p1.next;
                pNew = pNew.next;
            } else {
                if (p1.val < p2.val) {
                    // if(fakeHead)
                    pNew.next = new ListNode(p1.val);
                    p1 = p1.next;
                    pNew = pNew.next;
                } else if (p1.val == p2.val) {
                    pNew.next = new ListNode(p1.val);
                    pNew.next.next = new ListNode(p1.val);
                    pNew = pNew.next.next;
                    p1 = p1.next;
                    p2 = p2.next;

                } else {
                    pNew.next = new ListNode(p2.val);
                    p2 = p2.next;
                    pNew = pNew.next;
                }
            }
        }

        // printList(fakeHead.next);
        return fakeHead.next;
    }
}
