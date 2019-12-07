package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Difficult: Medium
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class T118_PascalsTriangle {
    public static void main(String[] args) {
        T118_PascalsTriangle t118 = new T118_PascalsTriangle();
        System.out.println(t118.generate(5));
    }

    /**
     * 执行用时 : 1 ms ,  98.46%
     * 内存消耗 : 34 MB ,  26.02%
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>(numRows);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        int leftUp, up;
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                leftUp = j > 0 ? ans.get(i - 1).get(j - 1) : 0;
                up = i == j ? 0 : ans.get(i - 1).get(j);
                list.add(leftUp + up);
            }
            ans.add(list);
        }
        return ans;
    }
}
