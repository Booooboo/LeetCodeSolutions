/**
 * Created by sunhongbo on 16/12/22.
 */

public class testdevide {
    public static void main(String[] args) {
        System.out.println(divide(4,3));
        System.out.println(divide(5,8));
        double a = 4.7;
        double b = 4.2;
        System.out.println((int)(a));
        System.out.println((int)b);
        System.out.println((int)(0.2222/5));
    }

    private static int divide(int a, int b) {
        return a/b;
    }
}
