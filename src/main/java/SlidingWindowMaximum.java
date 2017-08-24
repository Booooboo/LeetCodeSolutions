import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunhongbo on 16/6/17.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] exa = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(exa, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        //int[] exa1 = {};
        //maxSlidingWindow(exa1, 0);
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
    //双向队列来解决
    //
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int num = nums.length - k + 1;
        int[] res = new int[num];
        for (int i = 0; i < nums.length; i++) {
            // 队列头部的下标如果 是窗口最左边数的下标，则扔掉
            // 也就是判断 当前队列里的头是不是上一个窗口中的值
            if (!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.poll();
            }
            // 如果当前要插入的节点 大于 队列里的最后一个节点,则把队列最后一个节点出队列, 保证对队列是降序的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            // 保存的是数组的下标
            deque.offerLast(i);
            // 加入结果数组
            if ((i+1) >= k) res[i+1 - k] = nums[deque.peek()];
        }
        return res;
    }

    //Time Out
    public static int[] maxSlidingWindowOutTime(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> target = new LinkedList<Integer>();
        int num = nums.length - k + 1;
        int[] res = new int[num];
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int index = 0;
        while (num > 0) {
            for (int j = 0; j < k; j++) {
                    target.add(nums[index++]);
            }
            num--;
            int max = target.poll();
            while (!target.isEmpty()) {
                if (max < target.peek()) {
                    max = target.poll();
                } else {
                    target.poll();
                }
            }
            index = index - k + 1;
            res[index - 1] = max;
        }
        return res;
    }
}
