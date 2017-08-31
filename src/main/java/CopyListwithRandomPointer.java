/**
 * Created by sunhongbo on 17/8/29.
 */
public class CopyListwithRandomPointer {

    public static void main(String[] args) {
        RandomListNode randomListNode = new RandomListNode(-1);
        randomListNode.next = null;
        randomListNode.random = null;
        RandomListNode head = copyRandomList(randomListNode);
        while (head != null) {
            System.out.println(head.label);
            if (head.random != null) {
                System.out.println("node random" + head.random.label);
            } else {
                System.out.println("node random is null");
            }
            head = head.next;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode tmp = head;
        RandomListNode p = head;
        RandomListNode q = head;
        //原地拷贝每个节点 使得 1234变成11223344
        while (tmp != null) {
            p = tmp.next;
            tmp.next = new RandomListNode(tmp.label);
            tmp.next.next = p;
            tmp = tmp.next.next;
        }
        //拷贝原每个节点的random的指针
        while (q != null) {
            if (q.random != null) {
                q.next.random = q.random.next;
            }
            q = q.next.next;
        }

        RandomListNode t = head;
        RandomListNode res = head.next;
        // 拆分原链表和目标链表
        while (t != null) { // 两个指针分别指向新旧链表
            tmp = t.next;
            t.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
            t = t.next;
        }
        return res;
    }
}
