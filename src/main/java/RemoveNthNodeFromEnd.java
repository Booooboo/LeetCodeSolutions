import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunhongbo on 16/6/1.
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
        }
    }
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if(n == 0 || head == null){
            return head;
        }
        if(n == 1 && head.next==null){
            return null;
        }
        ListNode p = head, q = head;
        // 让p先行q n个位置
        for(int i=0; i<n; i++){
            if(p != null){
                p = p.next;
            }else{
                return head;
            }
        }
        // 如果这个时候p已经是null，则说明删除的必定为head
        if(p == null){
            head = head.next;
            return head;
        }
        // p和q一起前进
        while(p.next != null){
            q = q.next;
            p = p.next;
        }
        // 删除元素
        q.next = q.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0 || head == null){
            return head;
        }
        if(n == 1 && head.next==null){
            return null;
        }
        //让p前进 n步先,然后让p和q一起前进,p到结尾,q距离结尾正好差n个
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            if (p != null) {
                p = p.next;
            } else {
                return head;
            }
        }

        if (p == null) {
            head = head.next;
            return head;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
