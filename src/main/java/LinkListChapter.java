import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sunhongbo on 17/7/19.
 */
public class LinkListChapter {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        //ListNode l2 = reverseBetween(l1, 2, 4);
        //while (l2 != null) {
        //    System.out.println(l2.val);
        //    l2 = l2.next;
        //}

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        //l2.next.next = new ListNode(3);
        //l2.next.next.next = new ListNode(4);
        //l2.next.next.next.next = new ListNode(5);
        //l2.next.next.next.next.next = new ListNode(6);
        //l2.next.next.next.next.next.next = new ListNode(7);

        ListNode head = swapPairs(l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        //ListNode l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        //
        //ListNode la = new ListNode(3);
        //la.next = new ListNode(7);
        ////la.next.next = new ListNode(3);
        //ListNode lb = new ListNode(9);
        //lb.next = new ListNode(2);
        //ListNode l3 = addTwoNumbers(la, lb);
        ////ListNode l3 = addTwoNumbers(l1, l2);
        //while (l3 != null) {
        //    System.out.println(l3.val);
        //    l3 = l3.next;
        //}

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0); // 返回链表
        ListNode p = l3; //操作链表
        int carry = 0;
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + carry >= 10) {
                p.next = new ListNode((l1.val + l2.val + carry) % 10);
                p = p.next;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                p.next = new ListNode(l1.val + l2.val + carry);
                carry = 0; // 注意恢复进位值
                p = p.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        while (l2 != null) {
            if (carry != 0) {
                p.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                p = p.next;
                l2 = l2.next;
            } else {
                p.next = l2;
                break;
            }
        }
        while (l1 != null) {
            if (carry != 0) {
                p.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l1;
                break;
            }
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return l3.next;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        int index = 1;
        while (index < m && preNode.next != null) {
            preNode = preNode.next;
            index++;
        }
        ListNode mNode = preNode.next;
        ListNode cur = mNode.next;
        while (cur != null && index < n) {
            ListNode next = cur.next;
            cur.next = preNode.next; // 不能是 cur.next = mNode
            mNode.next = next;
            preNode.next = cur;
            cur = next;
            index++;
        }
        return dummy.next;
    }

    //Given 1->4->3->2->5->2 and x = 3,
    //return 1->2->2->4->3->5.
    // 1-2-4-3-5-2
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode des = new ListNode(0);
        ListNode desPre = new ListNode(0);
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        head = dumy;
        while (head != null && head.val < x) {
            pre = head;
            head = head.next;
        }
        while (head != null && head.next != null) {
            desPre = head;
            des = head.next;
            if (des.val < x) {
                // 1pre 3desPre 2des
                desPre.next = des.next;
                des.next = pre.next;
                pre.next = des;
                pre = des;
            } else {
                head = head.next;
            }
        }
        return dumy.next;
    }


    public static ListNode partitionB(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
        // 143252
        while (p != null) {
            if (p.val < x) { //维护指针
                p = p.next;
                prev = prev.next;
            } else { // 操作

                p2.next = p;
                prev.next = p.next; // 存储小于目标值的链表

                p = prev.next;  // 比对下一节点
                p2 = p2.next; // 维护一个链表,按顺序存储比目标值大的值
            }
        }

        // close the list
        p2.next = null; // 大于目标值的值 封尾

        prev.next = fakeHead2.next;

        return fakeHead1.next;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode p = head;
        ListNode q = head.next;
        while (p != null && q != null) {
            if (p.val == q.val) {
                p.next = q.next;
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }

        }
        return temp.next;
    }


    public static ListNode deleteDuplicatesII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        LinkedHashMap<Integer, Boolean> hashMap = new LinkedHashMap<Integer, Boolean>();
        while (head != null) {
            if (hashMap.containsKey(head.val)) {
                hashMap.put(head.val, true);
            } else {
                hashMap.put(head.val, false);
            }
            head = head.next;
        }

        Iterator<Map.Entry<Integer, Boolean>> iterator = hashMap.entrySet().iterator();
        Map.Entry<Integer, Boolean> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (!hashMap.get(entry.getKey())) {
                tmp.next = new ListNode(entry.getKey());
                tmp = tmp.next;
            }
        }
        tmp.next = null;

        return res.next;
    }

    public static ListNode deleteDuplicatesIN(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int dup = p.next.val;
                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next; // 去除当前连续重复的元素,比如01112235 -> 02235 -> 035
                }
            } else {
                p = p.next; // p所指向的元素一定是只出现一次的元素
            }

        }

        return t.next;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode p = temp;
        ListNode q = head;
        // 01234  02134  03214
        while (head != null && head.next != null) {
            q = temp.next;
            p = head.next;
            head.next = p.next;
            temp.next = p;
            p.next = q;
        }
        return temp.next;
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode p = head;
        ListNode q = p;
        int len = 0;
        while (p != null) {
            len++;
            q = p;
            p = p.next;
        }
        k = k % len;
        q.next = head;
        while ((len - k) != 0) {
            k++;
            q = head;
            head = head.next;
        }
        q.next = null;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode p = tmp; // 避免 输入 [1] 1 ; [1, 2] 2这种情况出问题
        head = tmp;
        while (n != 0 && head != null) {
            n--;
            head = head.next;
        }
        while (head != null && head.next != null) {
            p = p.next;
            head = head.next;
        }
        p.next = p.next.next;
        return tmp.next;
    }

    // 1234   2134
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode p = head.next;
        head = tmp;
        while (p != null) {
            head.next.next = p.next;
            p.next = head.next;
            head.next = p;
            head = p.next;
            if (head.next == null) {
                break;
            } else {
                p = head.next.next;
            }
        }
        return tmp.next;
        // 递归解法
        // if (head == null || head.next == null) return head;
        // ListNode p = head.next;
        // ListNode q = head.next.next;
        // p.next = head;
        // head.next = swapPairs(q);
        // return p;
    }







}
