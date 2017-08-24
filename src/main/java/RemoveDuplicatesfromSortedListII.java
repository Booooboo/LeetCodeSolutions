/**
 * Created by sunhongbo on 16/6/22.
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        //deleteDuplicates(null);
        ListNode exa = new ListNode(1);
        exa.next = new ListNode(2);
        exa.next.next = new ListNode(3);
        exa.next.next.next = new ListNode(3);
        exa.next.next.next.next = new ListNode(4);
        exa.next.next.next.next.next = new ListNode(4);
        exa.next.next.next.next.next.next = new ListNode(5);
        ListNode res = deleteDuplicatesW(exa);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        //ListNode exa = new ListNode(1);
        //exa.next = new ListNode(1);
        //ListNode res = deleteDuplicates(exa);
        //while (res != null) {
        //    System.out.println(res.val);
        //    res = res.next;
        //}



    }
    //011123 1233445
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = head;
        ListNode pre = res;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                pre = p;
                p = p.next;
            } else {
                p = p.next;
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                pre.next = p.next;
                p = pre.next;
            }
        }
        return res.next;
    }

    // 标准解法
    public static ListNode deleteDuplicatesW(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){ // 删除遇见的duplicate,从第一个开始删除
                    p.next = p.next.next;
                }
            }else{
                p=p.next; //向后移动p,p指向不是duplicate的点
            }

        }

        return t.next;
    }
}
