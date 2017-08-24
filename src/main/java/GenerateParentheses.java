import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/4/15.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> s = new ArrayList<String>();
        s = generateParenthesis(2);
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    //
    //For example, given n = 3, a MaximumGap set is:
    //
    //        "((()))", "(()())", "(())()", "()(())", "()()()"
    // (()) ()()
    public static List<String> generateParenthesis(int n) {
        String s = "";
        List<String> ret= new ArrayList<String>();
        List<String> res = generate(n, n, s, ret);
        return res;
    }
    //使用递归, 左括号大于0,则下一个可以是左括号,右括号大于0并且大于左括号,下一个可以是右括号
    public static List<String> generate(int left, int right, String s, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if (left > 0) {
            generate(left - 1, right, s+"(", res);
        }
        if (right > 0 && right > left) {
            generate(left, right - 1, s+")", res);
        }
        return res;
    }
}
