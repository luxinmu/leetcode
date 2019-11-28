package test;

/**
 * 91. Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class T91_DecodeWays {
    public static void main(String[] args) {
        T91_DecodeWays t91 = new T91_DecodeWays();
        System.out.println(t91.numDecodings("226"));    //3
        System.out.println(t91.numDecodings("2262"));   //3
        System.out.println(t91.numDecodings("22622"));  //6
        System.out.println(t91.numDecodings("226220")); //3
        System.out.println(t91.numDecodings("226250")); //0
        System.out.println(t91.numDecodings("814"));    //2
        System.out.println(t91.numDecodings("2222"));   //5
        System.out.println(t91.numDecodings("100"));    //0
        System.out.println(t91.numDecodings("101"));    //1
        System.out.println(t91.numDecodings("301"));    //0
    }

    /**
     * dp[i]的意思是到第i个字符有多少种解法，从最后一个字符看，如果最后一个字符单独解码(只有一种)，
     * 根据排列组合乘法原理,为dp[i-1]*1种，如果最后一个字符和第i-1个字符联合解码，也只有一种，dp[i-2]*1，
     * 合起来就是dp[i] = dp[i-1] + dp[i-2]
     * 执行用时 :1 ms, 99.97%
     * 内存消耗 :34.4 MB, 50.56%
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        else if (s.length() == 1)
            return 1;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if (s.charAt(1) == '0' && s.charAt(0) - '0' > 2)
            return 0;
        if (s.charAt(1) - '0' + 10 * (s.charAt(0) - '0') > 26 || s.charAt(1) == '0')
            dp[1] = 1;
        else
            dp[1] = 2;
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')
                return 0;               // in 00 or [30...90]
            if (s.charAt(i) - '0' + 10 * (s.charAt(i - 1) - '0') > 26 || s.charAt(i - 1) == '0')
                dp[i] = dp[i - 1];      // more than 26 or in [01...09]
            else if (s.charAt(i) == '0')
                dp[i] = dp[i - 2];      // 10 or 20
            else
                dp[i] = dp[i - 1] + dp[i - 2]; // less than 26 and not in [01...09]
        }
        return dp[len - 1];
    }

    /**
     * 执行用时 :1 ms, 99.97%
     * 内存消耗 :34.4 MB, 50.56%
     */
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        else if (s.length() == 1)
            return 1;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(1) == '0' && s.charAt(0) - '0' > 2)
            return 0;
        if (s.charAt(1) - '0' + 10 * (s.charAt(0) - '0') > 26 || s.charAt(1) == '0')
            dp[1] = 1;
        else
            dp[1] = 2;
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) - '0' + 10 * (s.charAt(i - 1) - '0') > 26)
                if (s.charAt(i) == '0')
                    return 0;
                else dp[i] = dp[i - 1];
            else if (s.charAt(i) == '0')
                if (s.charAt(i - 1) == '0')
                    return 0;
                else
                    dp[i] = dp[i - 2];
            else {
                if (s.charAt(i - 1) == '0')
                    dp[i] = dp[i - 1];
                else
                    dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}
