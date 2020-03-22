package test;

import java.util.Objects;

/**
 * 1071. Greatest Common Divisor of Strings
 * Difficult: Easy
 * <p>
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T
 * (T concatenated with itself 1 or more times)
 * Return the largest string X such that X divides str1 and X divides str2.
 * <p>
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * <p>
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * <p>
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 */
public class T1071_GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        T1071_GreatestCommonDivisorOfStrings test = new T1071_GreatestCommonDivisorOfStrings();
        System.out.println(test.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(test.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(test.gcdOfStrings("LEET", "CODE"));
    }

    /**
     * 利用数学求解
     * 需要知道一个性质：
     * 如果 str1 和 str2 拼接后等于 str2和 str1拼接起来的字符串（注意拼接顺序不同），
     * 那么一定存在符合条件的字符串 X.
     * 执行用时 :1 ms, 93.98%
     * 内存消耗 :38.7 MB, 8.80%
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null)
            return "";
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0)
            return "";
        if (!Objects.equals(str1 + str2, str2 + str1))
            return "";
        return str1.substring(0, gcd(len1, len2));
    }

    // 求最大公约数，辗转相除法
    // 辗转相除法， 又名欧几里得算法（Euclidean algorithm），
    // 目的是求出两个正整数的最大公约数。它是已知最古老的算法，
    // 其可追溯至公元前300年
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
