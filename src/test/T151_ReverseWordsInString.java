package test;

/**
 * 151. Reverse Words in a String
 * Difficult: Medium
 * <p>
 * Given an input string, reverse the string word by word.
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up:
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class T151_ReverseWordsInString {

    public static void main(String[] args) {
        T151_ReverseWordsInString t = new T151_ReverseWordsInString();
        System.out.println(t.reverseWords("  hello world!  "));
    }


    /**
     * 执行用时 :8 ms, 在所有 Java 提交中击败了44.47% 的用户
     * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了94.16%的用户
     */
    public String reverseWords(String s) {
        if (s == null)
            return null;
        String[] ss = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            sb.append(ss[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
