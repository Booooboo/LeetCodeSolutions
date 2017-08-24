import java.util.Arrays;

/**
 * Created by sunhongbo on 16/10/13.
 */

public class ArraySortFunc {


    public static void main(String[] args) {

        int[] array = {2, 0, 1, 4, 5, 8};
        Arrays.sort(array);//调用Arrays的静态方法Sort进行排序，升序排列
        for (int show : array) {
            System.out.println(show);
            }
        }
}
