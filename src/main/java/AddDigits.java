/**
 * Created by sunhongbo on 16/3/28.
 */
public class AddDigits {
    public static void main(String[] args) {
        int ret = addDigits(8);
        //System.out.print(ret);
        String s = "null";
        System.out.println(test(s));
        System.out.println(func(3));
    }
    public static int addDigits(int num) {
        return num%9;
    }

    public static boolean test(String s) {
        return s == null || s.equals("null");
    }

    // 斐波那契数列
    public  static int fun(int num){
        if(num<0){
            num=0;
        }else if(num==0 || num==1){
            num=1;
        }else{
            num= fun(num-1)+ fun(num-2);
        }
        return num;
    }

    public static int func(int num) {
        int a = 1;
        int b = 1;
        int c = 1;

        for (int i = 0; i < num- 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
