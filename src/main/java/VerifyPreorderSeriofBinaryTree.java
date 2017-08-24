import java.util.Stack;

/**
 * Created by sunhongbo on 16/5/23.
 */

//Verify Preorder Serialization of a Binary Tree
public class VerifyPreorderSeriofBinaryTree {
    public static void main(String[] args) {
        String exa = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(exa));
    }

    //java中默认基本类型的数据是分配在栈上,如果你想把它包装成一个类的对象,让它分配在堆上,就需要用到包装类,Character就是char的包装类。

    //9,3,4,#,#,1,#,#,2,#,6,#,#
    //9,#,#,1
    //public static boolean isValidSerialization(String preorder) {
    //    preorder = preorder.replaceAll(",", "");
    //    char[] charSet = preorder.toCharArray();
    //    Stack<Character> stack = new Stack<Character>();
    //    for (int i = 0; i < charSet.length - 1; i++) {
    //        stack.push(charSet[i]);
    //        if (stack.size() >= 3) {
    //            while (stack.peek() == '#') {
    //                stack.pop();
    //                if (stack.peek() == '#') {
    //                    stack.pop();
    //                    if (stack.peek() != '#') {
    //                        stack.push('#');
    //                    } else {
    //                        stack.push('#');
    //                    }
    //                } else {
    //                    stack.push('#');
    //                    break;
    //                }
    //            }
    //        }
    //    }
    //    if (stack.size() == 1 && stack.peek() == '#') {
    //        return true;
    //    } else {
    //        return false;
    //    }
    //}

    //9,3,4,#,#,1,#,#,2,#,6,#,#
    //9,#,#,1

    public static boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<String>();
        String[] num = preorder.split(",");

        for (int i = 0; i < num.length; i++) {
            if (!num[i].equals("#")) {
                stack.push(num[i]);
            } else if (num[i].equals("#") && stack.size() > 0) {
                stack.pop();
            } else if (stack.size() == 0 && num[num.length - 1].equals("#") && i == num.length - 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
