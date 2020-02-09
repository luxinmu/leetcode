package test;

/**
 * 567. Permutation in String
 * Difficult: Medium
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * <p>
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class T567_PermutationInString {

    public static void main(String[] args) {
        T567_PermutationInString test = new T567_PermutationInString();
        System.out.println(test.checkInclusion("abc", "cbeaebc"));
        System.out.println(test.checkInclusion("ab", "eidbaooo"));
        System.out.println(test.checkInclusion("hello", "ooolleoooleh"));
    }

    /**
     * 滑动窗口解法(数组优化版)
     * 执行用时 :5 ms, 96.95%
     * 内存消耗 :36 MB, 99.12%
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length())
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        //使用数组存放字符串中字符出现频率
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < len1; i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2 - len1; i++) {
            if (matches(s1map, s2map))
                return true;
            // 若不相等，s2在窗口内子串不重新计算频率数组
            // 当前子串头的字符频率减一，将要进入窗口的字符频率加一
            s2map[s2.charAt(i) - 'a']--;
            s2map[s2.charAt(i + len1) - 'a']++;
        }
        return matches(s1map, s2map);
    }

    /**
     * 使用数组存放字符串中字符出现频率，每次比较s2中s1长度的子串中频率是否相等。
     * 执行用时 :59 ms, 34.15%
     * 内存消耗 :37.6 MB, 49.24%
     */
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    /**
     * 布隆过滤器思想的解法
     * 执行用时 :105 ms, 24.03%
     * 内存消耗 :36.9 MB, 86.98%
     * 使用数组存放字符串中字符出现频率，同时，使用一个int存放每个字符是否出现，
     * 有布隆过滤器的意思，由于s1中可能包含重复字符，故相同bit位可能被多次置一，
     * 故每次根据s2子串计算的f2与f1相等时，需要继续比较s2中s1长度的子串中频率是否相等。
     * 若f2与f1不相等时，肯定f2与f1不相等。
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length())
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int f1 = 0x00;
        int[] s1map = new int[26];
        for (int i = 0; i < len1; i++) {
            f1 = f1 | (1 << s1.charAt(i) - 'a');
            s1map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= len2 - len1; i++) {
            int f2 = 0x00;
            for (int j = 0; j < len1; j++)
                f2 = f2 | (1 << s2.charAt(j + i) - 'a');
            if (f1 == f2 && makesure(s1map, s2, i, len1))
                return true;
        }
        return false;
    }

    private boolean makesure(int[] s1map, String s2, int i, int len1) {
        int[] s2map = new int[26];
        for (int j = 0; j < len1; j++)
            s2map[s2.charAt(j + i) - 'a']++;
        return matches(s1map, s2map);
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++)
            if (s1map[i] != s2map[i])
                return false;
        return true;
    }
}
