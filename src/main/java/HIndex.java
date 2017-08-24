import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sunhongbo on 16/5/18.
 */
public class HIndex {
    public static void main(String[] args) {
        int[] exa = {3, 0, 6, 1, 5};//01356
        int[] exa1 = {1, 1};
        System.out.println(hIndex(exa1));
    }
    //H-Index的核心计算方法如下：
    //
    //        1、将某作者的所有文章的引用频次按照从大到小的位置排列
    //
    //2、从前到后，找到最后一个满足条件的位置，其条件为：
    //
    //此位置是数组的第x个，其值为y，必须满足 y >= x;
    //
    //至此，思路已经形成。即先排序，然后从前向后遍历即可。
    public static int hIndex1(int[] citations) {
        int n = citations.length;
        if (n == 0) return n;
        int res = 0;
        Arrays.sort(citations);
        for (int i = n-1; i >= 0; i--) {
            if (citations[i] >= n-i) {
                //if (citations[i] == 0) break;
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    //II
    public static int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return n;
        int low = 0;
        int high = n-1;
        int mid;
        while (low <= high) {
            mid  = low + (high-low)/2;
            if(citations[mid] == n-mid) return n-mid;
            else if(citations[mid] < n-mid) low = mid+1;
            else high = mid-1;
        }
        return n-low;
    }
}
