import java.math.BigDecimal;

/**
 * Created by sunhongbo on 17/6/5.
 */
public class BigDecimalDouble {

    public static void main(String[] args) {
        double a1 = 54.6;
        double b1 = 0.0;

        BigDecimal a2 = new BigDecimal(Double.toString(a1));
        BigDecimal b2 = new BigDecimal(Double.toString(b1));

        double c = a1 + b1;

        System.out.println(c);
        System.out.println(a2.add(b2));
    }
}
