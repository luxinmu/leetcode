package test;

import java.util.ArrayList;
import java.util.List;

/*
 * 120. Triangle
 * Difficult: Medium
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * */
public class T120_Triangle {
    public static void main(String[] args) {
        T120_Triangle t120 = new T120_Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);
        System.out.println(t120.minimumTotal(triangle));
        System.out.println(t120.minimumTotal1(triangle));
    }

    /**
     * 自顶向下, 需要考虑边界的特殊情况, 且最后还需要求最小值
     * 执行用时 : 3 ms ,  87.44%
     * 内存消耗 : 37.1 MB ,  77.89%
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++)
            for (int j = i; j >= 0; j--)
                if (j == 0)
                    dp[j] += triangle.get(i).get(j);
                else if (j == i)
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
        int min = dp[0];
        for (int i = 1; i < size; i++)
            min = Math.min(min, dp[i]);
        return min;
    }

    /**
     * 自底向上法, 最终得到的值即是最小和
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int size = triangle.size();
        int[][] dp = new int[size + 1][size + 1]; //dp数组定义为+1是避免数组越界
        for (int i = size - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                //dp[i][j]表示i、j这个位置的最小路径和，由当前位置的权重triangle.get(i).get(j)
                //加上上一层相邻位置最小和的较小值。[i][j]上一层相邻位置为[i+1][j]和[i+1][j+1]。
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        return dp[0][0];
    }

    /**
     * 自底向上法优化, 最终得到的值即是最小和
     * 执行用时 : 3 ms ,  87.44%
     * 内存消耗 : 37.4 MB ,  68.33%
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        int[] dp = new int[size + 1];
        for (int i = size - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];
    }
}
