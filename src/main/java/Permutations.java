import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/4/21.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] x= new int[]{1,2,3};
        List<List<Integer>> exa = permute1(x);
    }
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList();
        perm(0,num,res);
        return res;
    }
    public static void swap(int arr[],int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void perm(int start,int[] num,List<List<Integer>> res){
        if(start >= num.length){
            List<Integer> tmp = new ArrayList<Integer>(num.length);
            for(int n:num)tmp.add(n);
            res.add(tmp);
            return;
        }
        for(int i=start; i<num.length; i++){
            swap(num, start, i);
            perm(start+1,num,res);
            swap(num, start, i);
        }
    }





    public static List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        perm1(0, num, res);
        return res;
    }
    public static void perm1(int start, int[] num, List<List<Integer>> res) {
        if (start >= num.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int n : num) temp.add(n);
            res.add(temp);
        }
        for (int i = start; i < num.length; i++) {
            swap1(num, start, i);
            perm1(start+1, num, res);
            swap1(num, start, i);
        }
    }
    public static void swap1(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
