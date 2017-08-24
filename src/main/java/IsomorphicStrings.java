import java.util.HashMap;

/**
 * Created by sunhongbo on 16/5/31.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic1("ab", "ca"));
    }
    //判断字母的映射关系 是否一致 egg add 都是xyy形式的,即可返回true
    //使用的方法是获取每个字符,如果map里没有两个String里字符的映射,添加进map,
    // 1.如果存在,看是否符合当前映射,2.如果没有,看当前映射是否有该值的映射 如果存在其一条件 返回false
    //最后都符合返回true
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (hashMap.containsKey(a)) {
                if (hashMap.get(a) != b) {
                    return false;
                }
            } else {
                if (hashMap.containsValue(b)) { //切记 是使用的 containValue()这个函数!!!
                    return false;
                }
                hashMap.put(a, b);
            }
        }
        return true;
    }

    public static boolean isIsomorphic1(String s, String t) {
        if(s==null||t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();


        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)// if not consistant with previous ones
                    return false;
            }else{
                if(map.containsValue(c2)) //if c2 is already being mapped
                    return false;
                map.put(c1, c2);
            }
        }

        return true;
    }
}
