package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Difficult: Easy
 * <p>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 * <p>
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class T119_PascalsTriangleII {
    public static void main(String[] args) {
        T119_PascalsTriangleII t119 = new T119_PascalsTriangleII();
        System.out.println(t119.getRow(0));
        System.out.println(t119.getRow(3));
        System.out.println(t119.getRow(4));
    }

    /**
     * 执行用时 : 2 ms ,  68.83%
     * 内存消耗 : 33.8 MB ,  22.67%
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 0; i < rowIndex; i++) {
            ans.add(1);
            for (int j = ans.size() - 2; j > 0; j--)
                ans.set(j, ans.get(j) + ans.get(j - 1));
        }
        return ans;
    }
}
