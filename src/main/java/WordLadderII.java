import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunhongbo on 16/8/15.
 */

public class WordLadderII {
    //记录每个单词所在的层数
    static HashMap<String, Integer> path = new HashMap<String, Integer>();

    //bfs生成path
    static void bfs(String start, String end, HashSet<String> dict) {
        Queue queue = new LinkedList<String>();
        queue.add(start);
        path.put(start, 0);
        String current;
        while (!queue.isEmpty()) {
            current = (String) queue.poll();
            if (current == end) {
                continue;
            }
            for (int i = 0; i < current.length(); i++) {
                char[] strCharArr = current.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) { // 广度优先遍历,把每个位置的字母由a排到z, 看当前dict中是否存在此单词
                    if (strCharArr[i] == ch) {
                        continue;
                    }
                    strCharArr[i] = ch;
                    String newWord = new String(strCharArr);
                    if (newWord.equals(end) == true || dict.contains(newWord)) {
                        //每个单词在path中只能出现一次，也就是每个单词只能出现在一层中，这样就很巧妙的解决了环的问题。
                        if (path.get(newWord) == null) { // 如果当前单词不在path中, 添加进去,并且存入对应的层次
                            int depth = (int) path.get(current);
                            path.put(newWord, depth + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
    }

    //从目标单词往回找开始单词，记录所有路径
    static void dfs(String start,
                    String end,
                    HashSet<String> dict,
                    ArrayList<String> pathArray,
                    ArrayList<ArrayList<String>> result) {
        //找到了，需要reverse加入的所有单词
        if (start.equals(end) == true) {
            pathArray.add(start);
            Collections.reverse(pathArray);
            result.add(pathArray);
            return;
        }
        if (path.get(start) == null) {
            return;
        }
        pathArray.add(start);
        int nextDepth = (int) path.get(start) - 1;
        for (int i = 0; i < start.length(); i++) {
            char[] strCharArr = start.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (strCharArr[i] == ch) {
                    continue;
                }
                strCharArr[i] = ch;
                String newWord = new String(strCharArr);
                //只相差一个字母同时这个单词所在的层数也是当前单词的上一层
                if (path.get(newWord) != null && (path.get(newWord) == nextDepth)) {
                    ArrayList<String> newPathArray = new ArrayList<String>(pathArray);
                    dfs(newWord, end, dict, newPathArray, result); // 继续往前查找 ; 递归调用, 能遍历所有符合条件的路径
                }
            }
        }
    }

    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        if (start == null || end == null || start.length() != end.length()) {
            return result;
        }
        bfs(start, end, dict);
        dfs(end, start, dict, path, result);
        return result;
    }

    public static void main(String[] args) {
        // 思路 : 先用bfs 把跟上一个单词只差一个字母的单词放到path里,并且记上层次, 同时放到quene里实现广度优先遍历
        // 最后 从后往前使用深度优先遍历, 使用递归实现深度优先遍历, 每次从end往前找到只差一个字符,并且层析减少1的单词放到结果数组,
        // 当等于start时候,放在结果ArrayList数组

        String start = "hit";
        String end = "cog";
        //hot","dot","dog","lot","log
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        ArrayList<ArrayList<String>> result = findLadders(start, end, dict);
    }

}
