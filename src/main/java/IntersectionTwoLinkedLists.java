/**
 * Created by sunhongbo on 16/5/30.
 */
public class IntersectionTwoLinkedLists {
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int countp = 0;
        int countq = 0;
        while (p != null) {
            countp++;
            p = p.next;
        }
        while(q != null) {
            countq++;
            q = q.next;
        }
        if (q != q) {
            return null;
        } else {
            int step = 0;
            if (countp > countq) {
                p = headA;
                q = headB;
                step = countp - countq;
            } else {
                p = headB;
                q = headA;
                step = countq - countp;
            }
            while (step != 0) {
                step--;
                p = p.next;
            }
            while (p != null && q != null && p != q) {
                p = p.next;
                q = q.next;
            }
        }
        return p;
    }
}
