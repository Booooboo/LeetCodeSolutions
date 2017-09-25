import java.util.HashMap;

/**
 * Created by sunhongbo on 17/9/25.
 */
public class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> mHashMap = new HashMap<Integer, Node>();
    private Node head = null;
    private Node end = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (mHashMap.containsKey(key)) {
            Node tmp = mHashMap.get(key);
            remove(tmp);
            setHead(tmp);
            return tmp.val;
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (mHashMap.containsKey(key)) {
            Node tmp = mHashMap.get(key);
            tmp.val = value;
            remove(tmp);
            setHead(tmp);
        } else {
            Node node = new Node(key, value);
            if (mHashMap.size() >= capacity) {
                // 要把hashMap中的元素也删除
                mHashMap.remove(end.key);
                remove(end);
            }
            setHead(node);
            mHashMap.put(key, node);
        }

    }
    // 保证node的指向正确
    public void remove(Node tmp) {
        if (tmp.pre != null) {
            tmp.pre.next = tmp.next;
        } else {
            head = tmp.next;
        }

        //双向链表 要保证两个方向的指向正常
        if (tmp.next != null) {
            tmp.next.pre = tmp.pre;
        } else {
            end = tmp.pre;
        }

    }
    // 保证node指向正确
    public void setHead(Node tmp) {
        tmp.next = head;
        tmp.pre = null;
        if (head != null) {
            head.pre = tmp;
        }
        head = tmp;
        if (end == null) {
            end = head;
        }
    }
    public static void main(String[] args) {

    }
}
