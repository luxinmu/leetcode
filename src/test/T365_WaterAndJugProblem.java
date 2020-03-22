package test;

/**
 * 365. Water and Jug Problem
 * Difficult: Medium
 * <p>
 * You are given two jugs with capacities x and y litres.
 * There is an infinite amount of water supply available.
 * You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one
 * or both buckets by the end.
 * <p>
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely
 * full or the first jug itself is empty.
 * <p>
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * <p>
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public class T365_WaterAndJugProblem {

    public static void main(String[] args) {
        T365_WaterAndJugProblem test = new T365_WaterAndJugProblem();
        System.out.println(test.canMeasureWater(3, 5, 4));
        System.out.println(test.canMeasureWater(3, 5, 5));
        System.out.println(test.canMeasureWater(3, 5, 7));
        System.out.println(test.canMeasureWater(2, 6, 5));
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了13.93%的用户
     * */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        else if (z == 0 || x + y == z)
            return true;
        if (x == 0 || y == 0)
            return false;
        int d = gcd(x, y);
        return z % d == 0;
    }

    /**
     * 辗转相除法求最大公约数
     *
     * @see T1071_GreatestCommonDivisorOfStrings
     */
    private int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }
}
