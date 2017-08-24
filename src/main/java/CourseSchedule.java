import java.util.LinkedList;

/**
 * Created by sunhongbo on 16/6/21.
 */
public class CourseSchedule {
    public static void main(String[] args) {

    }
    // 二维数组代表有被限制课程的课程 第一个参数代表总的课程数
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //考虑prerequisites为空等情况
        if (prerequisites == null) return true;
        int len = prerequisites.length;
        if (len == 0 || numCourses == 0) return true;
        int[] courceLimit = new int[numCourses];
        //
        for (int i = 0; i < len; i++) {
            courceLimit[prerequisites[i][0]]++; // 记录有限制课程的 限制科目总数
        }

        LinkedList<Integer> courceNoLimit = new LinkedList<Integer>(); // 记录没有限制的课程
        for (int i = 0; i < numCourses; i++) {
            if (courceLimit[i] == 0) { // courceLimit数组中为0的课程是不被限制的课程
                courceNoLimit.add(i);
            }
        }

        int numCourceNoLimit = courceNoLimit.size();
        // 如果被限制课程的 限制课程在 courceNoLimit里,则可以释放被限制课程一门课
        while (!courceNoLimit.isEmpty()) {
            int top = courceNoLimit.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == top) {
                    courceLimit[prerequisites[i][0]]--;
                    if (courceLimit[prerequisites[i][0]] == 0) {
                        numCourceNoLimit++;
                        courceNoLimit.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourceNoLimit == numCourses;

    }
}
