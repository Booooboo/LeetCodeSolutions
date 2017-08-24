import java.util.HashMap;

/**
 * Created by sunhongbo on 16/6/3.
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hashMap = new HashMap<Character, String>();
        char[] set = pattern.toCharArray();
        String[] des = str.split(" ");
        if (set.length != des.length) return false;
        for (int i = 0; i < set.length; i++) {
            if (hashMap.containsKey(set[i])) {
                if (!hashMap.get(set[i]).equals(des[i])) {
                    return false;
                }
            }
            if (hashMap.containsValue(des[i]) && !hashMap.containsKey(set[i])) {
                return false;
            }
            hashMap.put(set[i], des[i]);
        }
        return true;
    }
}
