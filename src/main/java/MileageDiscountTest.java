/**
 * Created by sunhongbo on 16/10/11.
 */
public class MileageDiscountTest {
    public static void main(String[] args) {
        System.out.println(test(10, 8, 39, 39, 10, 10, 5));
        System.out.println(test(10, 8, 39, 39, 10, 10, 10));
        System.out.println(test(10, 15, 39, 59, 10, 10, 18));
        System.out.println(test(10, 15, 39, 59, 10, 10, 13));
        System.out.println(test(10, 25, 39, 79, 10, 20, 23));
        System.out.println(test(5, 16, 39, 59, 5, 10, 11));
        System.out.println(test(5, 12, 39, 59, 5, 10, 11));
    }

    public static int test(int startDistance,
                           int totalDistance,
                           int startPrice,
                           int totalIncome,
                           int nextDis,
                           int nextPrice,
                           int mileage) {

        int discount;
        if (mileage <= startDistance) {
            // 里程券小于起步里程
            if (totalDistance <= startDistance || totalDistance < mileage) {
                //行驶里程小于等于起步里程, 费用全免
                discount = totalIncome;
            } else {
                //行驶里程大于起步里程, 减起步价
                discount = startPrice;
            }
        } else {
            if (totalDistance <= startDistance || totalDistance < mileage) {
                //行驶里程小于等于起步里程, 费用全免
                discount = totalIncome;
            } else {
                //int remainMileage = mileage - startDistance;
                //if (remainMileage < nextDis) {
                //    discount = startPrice;
                //} else {
                //    discount = (remainMileage/nextDis) * nextPrice + startPrice;
                //}

                int remainMileage = totalDistance - mileage;
                int count = remainMileage / nextDis;
                double span = remainMileage - count * nextDis;
                if (span > 0.1) {
                    count++;
                }
                int remainPay = count * nextPrice;
                discount = totalIncome - remainPay;
            }
        }
        return discount;
    }
}
