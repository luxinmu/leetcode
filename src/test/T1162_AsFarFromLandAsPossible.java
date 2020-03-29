package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. As Far from Land as Possible
 * Difficult: Medium
 * <p>
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land,
 * find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 * The distance used in this problem is the Manhattan distance:
 * the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * If no land or water exists in the grid, return -1.
 * <p>
 * Example 1:
 * Input:
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * Output: 2
 * Explanation:
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 * <p>
 * Example 2:
 * Input:
 * [1,0,0],
 * [0,0,0],
 * [0,0,0]
 * Output: 4
 * Explanation:
 * The cell (2, 2) is as far as possible from all the land with distance 4.
 * <p>
 * Note:
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] is 0 or 1
 *
 * @see T200_NumberOfIslands
 */
public class T1162_AsFarFromLandAsPossible {
    public static void main(String[] args) {
        T1162_AsFarFromLandAsPossible test = new T1162_AsFarFromLandAsPossible();
        System.out.println(test.maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
        System.out.println(test.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        /*
         * 1, 0, 0, 0, 0    1, 2, 0, 0, 0   1, 2, 3, 0, 0   1, 2, 3, 4, 5
         * 0, 0, 0, 0, 0    2, 0, 0, 0, 0   2, 3, 0, 0, 0   2, 3, 4, 5, 4
         * 0, 0, 0, 0, 0    0, 0, 0, 0, 0   3, 0, 0, 0, 3   3, 4, 5, 4, 3
         * 0, 0, 0, 0, 0    2, 0, 0, 0, 2   2, 3, 0, 3, 2   2, 3, 4, 3, 2
         * 1, 0, 0, 0, 1    1, 2, 0, 2, 1   1, 2, 3, 2, 1   1, 2, 3, 2, 1
         */
        System.out.println(test.maxDistance(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 1}}));
    }

    /**
     * ��Դ���BFS�ⷨ
     * ִ����ʱ :16 ms, 89.75%
     * �ڴ����� :42.1 MB, 99.00%
     */
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid.length != grid[0].length)
            return -1;
        int[] dx = {1, 0, -1, 0};   //x������������
        int[] dy = {0, 1, 0, -1};   //y������������
        int N = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        // �Ȱ����е�½�ض����
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (grid[i][j] == 1)
                    queue.offer(new int[]{i, j});

        // �Ӹ���½�ؿ�ʼ��һȦһȦ�ı����������������ĺ��������½����Զ�ĺ���
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            // ����point[x][y]�����������ĸ���
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];
                if (newX < 0 || newX >= N || newY < 0 || newY >= N || grid[newX][newY] != 0)
                    continue;
                hasOcean = true;
                grid[newX][newY] = grid[point[0]][point[1]] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        //��½��Ϊ�ջ���Ϊ�գ�����-1������������Զ����
        return point == null || !hasOcean ? -1 : grid[point[0]][point[1]] - 1;
    }
}
