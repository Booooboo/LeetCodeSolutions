/**
 * Created by sunhongbo on 16/4/7.
 */
public class MaxProductOfWordsLength {
    public static void main(String[] args) {
        String[] exa = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(exa));
    }

    public static int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int[] bit = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bit[i] = 0;
            for (int j = 0; j < words[i].length(); j++) {
                bit[i] |= (1 << words[i].charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++)  {
                if (((bit[i] & bit[j]) == 0) && words[i].length() * words[j].length() > maxProduct) {
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }
}
