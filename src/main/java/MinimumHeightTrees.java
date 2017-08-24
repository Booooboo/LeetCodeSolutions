import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/24.
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][] exa = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> res = findMinHeightTreesW(6, exa);
        for (int i = 0 ; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

        //n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
    }


    public static List<Integer> findMinHeightTreesCopy(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
        int[] degree = new int[n];
        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            List<Integer> list;
            if (!maps.containsKey(edges[i][0])) { // 算每个点的出度
                list = new ArrayList<Integer>();
            } else {
                list = maps.get(edges[i][0]);
            }
            list.add(edges[i][1]);
            maps.put(edges[i][0], list);

            if (!maps.containsKey(edges[i][1])) { // 算每个点的入度
                list = new ArrayList<Integer>();
            } else {
                list = maps.get(edges[i][1]);
            }
            list.add(edges[i][0]);
            maps.put(edges[i][1], list);
        }

        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) { // 叶子节点存到链表里
                leaves.add(i);
            }
        }
        List<Integer> tmp ;
        while (n > 2) {
            tmp = new ArrayList<Integer>();
            for (int leave : leaves) {
                n--;
                degree[leave] = 0; // 清除叶节点,把与叶节点邻接的点度减一
                List<Integer> connectedLeaves = maps.get(leave);
                for (int connectedLeave : connectedLeaves) {
                    degree[connectedLeave]--;
                    if (degree[connectedLeave] == 1) { // 变叶节点 入叶节点链表
                        tmp.add(connectedLeave);
                    }
                }
            }
            leaves = tmp;
        }
        return leaves;
    }


    //[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]
    public static List<Integer> findMinHeightTreesW(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        HashMap<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
        int[] degree = new int[n];// 出入度
        // 记录图的拓扑
        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            List<Integer> list;

            if (!maps.containsKey(edges[i][0])) {
                list = new ArrayList<Integer>();
            } else {
                list = maps.get(edges[i][0]); // 获取相同键的 值list
            }
            list.add(edges[i][1]); // 当前键 添加一个值
            maps.put(edges[i][0], list);

            if (!maps.containsKey(edges[i][1])) {
                list = new ArrayList<Integer>();
            } else {
                list = maps.get(edges[i][1]);
            }
            list.add(edges[i][0]);
            maps.put(edges[i][1], list); // 存入相同值的 键
        }
        //map里存的是 各个点出度加入度之和

        //获取度为1的点 即叶子节点
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                leaves.add(i);
        }
        int num = n;// 图中剩余结点
        List<Integer> tmp;// 记录遍历过程中新产生的叶结点
        // 沿着叶结点一圈圈剥开图
        while (num > 2) {
            tmp = new ArrayList<Integer>();
            for (int leave : leaves) {
                num--;
                degree[leave] = 0; // 将叶节点度数设置成0
                List<Integer> connectedLeave = maps.get(leave);
                for (int c : connectedLeave) {
                    degree[c]--;//删除跟叶结点相邻的边 并将邻结点度数减一
                    if (degree[c] == 1)
                        tmp.add(c);
                }
            }
            leaves = tmp;
        }
        return leaves;
    }




    public static List<Integer> findMinHeightTreesWWWrong(int n, int[][] edges) {
        int len = edges.length;
        if (len == 0 || n == 0) return null;
        int[] degree = new int[n];
        for (int i = 0; i < len; i++) {
            degree[edges[i][0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i  = 0; i < len; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int size = queue.size();
        n -= size;
        while (n > 2) {
            int temp = queue.peek();
            for (int j = 0; j < len; j++) {
                if (edges[j][1] == temp) {
                    degree[edges[j][0]]--;
                    if (degree[edges[j][0]] == 0) {
                        n--;
                        queue.add(edges[j][0]);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            res.add(i);
        }
        for (int i = 0; i < queue.size(); i++) {
            res.remove(queue.poll());
        }
        return res;
    }
}
