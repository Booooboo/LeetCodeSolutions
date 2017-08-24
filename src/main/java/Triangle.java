import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/5/30.
 */
public class Triangle {
    public static void main(String[] args) {

        List<ArrayList<Integer>> exa = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        exa.add(temp);
        ArrayList<Integer> temp1 = new ArrayList<Integer>();
        temp1.add(3);
        temp1.add(4);
        exa.add(temp1);
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(6);
        temp2.add(5);
        temp2.add(7);
        exa.add(temp2);
        ArrayList<Integer> temp3 = new ArrayList<Integer>();
        temp3.add(4); temp3.add(1); temp3.add(8); temp3.add(3);
        exa.add(temp3);
        System.out.println(minimumTotal(exa));
    }

    //从下往上算, 下面两个中的最小值 加上层的一个值
    //public static int minimumTotal(List<ArrayList<Integer>> triangle) {
    //    int[] total = new int[triangle.size()];
    //    int l = triangle.size() - 1;
    //
    //    for (int i = 0; i < triangle.get(l).size(); i++) {
    //        total[i] = triangle.get(l).get(i);
    //    }
    //
    //    // iterate from last second row
    //    for (int i = triangle.size() - 2; i >= 0; i--) {
    //        for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
    //            total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
    //        }
    //    }
    //
    //    return total[0];
    //}

    //从下往上算, 下面两个中的最小值 加上层的一个值
    public static int minimumTotal(List<ArrayList<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            total[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i+1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+1]);
            }
        }

        return total[0];
    }
}
