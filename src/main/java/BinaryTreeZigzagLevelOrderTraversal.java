import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sunhongbo on 16/6/13.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode exa = new TreeNode(3);
        exa.left = new TreeNode(9);
        exa.right = new TreeNode(20);
        exa.right.left = new TreeNode(15);
        exa.right.right = new TreeNode(7);
        List<List<Integer>> res = zigzagLevelOrder(exa);
        for (int i  = 0; i < res.size(); i++) {
            String a = "[";
            for (int j = 0; j < res.get(i).size(); j++) {
                if (j != res.get(i).size()-1) {
                    a += res.get(i).get(j) + ",";
                } else {
                    a += res.get(i).get(j) + "]";
                }
            }
            System.out.println(a);
        }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 使用队列和一个标志位
        //队列用与存储层次遍历到的各个节点, 标志位标志哪一层要反转

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = false;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int num = queue.size(); // 注意该处必须要在这里取,而不能在for循环中直接取,因为在循环体内会改变size
            temp.clear();
            for (int i = 0; i < num; i++) {
                TreeNode p = queue.poll();
                temp.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            if (flag) {
                Collections.reverse(temp); // 一次反转一次不反转
                flag = false;
            } else {
                flag = true;
            }
            res.add(new ArrayList<Integer>(temp)); // 不能直接使用 res.add(temp)
            // 因为上面的temp清空了,所以之前添加的就会变成最后一次temp中的值,相当于res中添加的是temp的引用
        }
        return res;
    }
}
