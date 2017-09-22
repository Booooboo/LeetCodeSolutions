/**
 * Created by sunhongbo on 17/9/14.
 */
public class Sort {

    public static void main(String[] args) {
        int[] a = {48, 6, 57, 42, 60, 72, 83, 73, 88, 85};
        quickSort(a, 0, 9);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

        bubbleSort1(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    //快排
    public static void quickSort(int[] data, int start, int end) {
        if (start < end) {

            int tmp = data[start];
            int i = start;
            int j = end;
            while (i < j && tmp < data[j]) {
                j--;
            }
            if (i < j) {
                data[i] = data[j];
                i++;
            }
            while (i < j && tmp > data[i]) {
                i++;
            }
            if (i < j) {
                data[j] = data[i];
                j--;
            }

            data[i] = tmp;
            quickSort(data, start, i - 1);
            quickSort(data, j + 1, end);

        }
    }

    //冒泡排序
    public static void bubbleSort(int[] data) {
        int len = data.length;
        int tmp;
        for (int i = len; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    //冒泡排序优化1  设置标志位,某一趟没有交换,说明排序完成
    public static void bubbleSort1(int[] data) {
        int len = data.length;
        boolean flag = true;
        int tmp;
        while (flag) {
            flag = false;
            for (int j = 0; j < len - 1; j++) {
                if (data[j] > data[j + 1]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = true;
                }
            }
            len--;
        }
    }


    // 插入排序, data[0]当成一个有序序列,每次从后面系列逐个取出一个放入当前有序序列中的适当位置
    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i-1] > data[i]) {
                int tmp = data[i];
                int j = i;
                // 给当前要插入的元素找一个适当的位置
                while (j > 0 && data[j-1] > tmp) {
                    data[j] = data[j-1];
                    j--;
                }
                data[j] = tmp;
            }

        }
    }






}
