/**
 * Created by sunhongbo on 16/3/25.
 */
public class NimGames {
    public static void main(String[] args) {
        boolean win = canWinNim(20);
        System.out.print(win);
    }
    public static boolean canWinNim(int n) {
        if (n%4 == 0) {
            return false;
        }
        return true;
    }
}
