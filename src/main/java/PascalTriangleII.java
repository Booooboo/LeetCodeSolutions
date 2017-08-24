import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/5/18.
 */
public class PascalTriangleII {
    public static void main(String[] args) {

    }
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) return res;
        //下一行的 第2个元素等于上一行的第1个+第2个元素 ;
        //        第3个元素等于上一行的第2个+第3个元素 ;
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = res.size() - 2; j >= 0; j--) {
                res.set(j+1, res.get(j) + res.get(j+1));
            }
            res.add(1);
        }
        return res;
    }
}
