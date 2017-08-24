import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by sunhongbo on 17/5/11.
 */
public class testNull {

    //public static ArrayList<Integer> arrayList;  //1---wrong NLP
    private static ArrayList<Integer> sIntegerArrayList = new ArrayList<Integer>(); //2-- ok
    public static void main(String[] args) {

        //System.out.println("arraylist is " + arrayList.size()); // 1---
        System.out.println("arraylist is " + sIntegerArrayList.size()); // 2--
    }

}
