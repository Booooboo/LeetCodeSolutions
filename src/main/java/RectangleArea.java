/**
 * Created by sunhongbo on 16/6/1.
 */
public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(0,0,0,0,-1,-1,1,1));
    }
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //A C E G 这四个点
        //B D F H 这四个点 可以确定判断大小的边界
        if (C < E || G < A) {
            return (G-E)*(H-F) + (C-A)*(D-B);
        }
        if (D < F || H < B) {
            return (G-E)*(H-F) + (C-A)*(D-B);
        }
        int left;
        int right;
        int high;
        int low;
        left = Math.max(A, E);
        right = Math.min(C, G);
        high = Math.min(D, H);
        low = Math.max(B, F);
        return (G-E)*(H-F) + (C-A)*(D-B) - (right-left) * (high - low);
    }
}
