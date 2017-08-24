import java.util.Stack;

/**
 * Created by sunhongbo on 16/6/12.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode exa = new ListNode(1);
        exa.next = new ListNode(2);
        exa.next.next = new ListNode(2);
        //exa.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(exa));
    }
    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int mid = len/2;
        boolean flag = false;
        if (len % 2 != 0) {
            flag = true;
        }
        Stack<Integer> temp = new Stack<Integer>();
        while (mid != 0) {
            temp.add(q.val);
            q = q.next;
            mid--;
        }
        if (flag) q = q.next;
        while (q != null) {
            if (q.val == temp.pop()) {
                q = q.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
