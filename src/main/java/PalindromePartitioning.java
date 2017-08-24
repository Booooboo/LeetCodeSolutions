import javax.swing.text.PlainDocument;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/20.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }

    // 找出一个字符串中的回文组合
    // 设置一个二维数组table[i][j]代表 s的第i个到第j个是回文的话,table[i][j] = 1, 否则等于0
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        int len = s.length();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.length() == 1) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(s);
            res.add(temp);
            return res;
        }
        ArrayList<String> Palin = new ArrayList<String>();
        int[][] table = new int[len][len];

        //
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int k = j + i - 1;
                if (k < len) {
                    if (s.charAt(j) == s.charAt(k)) {
                        if (i <= 2) {
                            table[j][k] = 1;
                        } else {
                            table[j][k] = table[j + 1][k - 1];
                        }
                    } else {
                        table[j][k] = 0;
                    }
                    if (table[j][k] == 1) {
                        Palin.add(s.substring(j, k + 1));
                    }
                }
            }
            res.add(new ArrayList<String>(Palin));
            Palin.clear();
        }
        return res;
    }
}
