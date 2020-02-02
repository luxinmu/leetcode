package test;

import java.util.HashMap;
import java.util.Map;

/**
 * 28. Implement strStr()
 * Difficult: Easy
 * <p>
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class T28_ImplementstrStr {

    public static void main(String[] args) {
        T28_ImplementstrStr t28 = new T28_ImplementstrStr();
        System.out.println(t28.strStr("hello", "ll"));  //2
        System.out.println(t28.strStr("hello", "aa"));  //-1
        System.out.println(t28.strStr("bbbdbbbcabc", "bbc"));  //5
        System.out.println(t28.strStr("", ""));  //0
        System.out.println(t28.strStr("mississippi", "a"));  //-1
        System.out.println(t28.strStr("a", "a"));  //0
        System.out.println(t28.strStr("mississippi", "issip"));  //4
        System.out.println(t28.strStr("mississippi", "issipi"));  //-1
    }

    /**
     * Sunday解法，时空供参考
     * 执行用时 :1 ms, 77.41%
     * 内存消耗 :36.1 MB, 95.48%
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null)
            return -1;
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int len = haystack.length();
        int slen = needle.length();
        int k = 0;
        //shift记录needle中，每个字符到字符串最右端的距离，相同字符取靠右的值，
        //用处为，当needle与haystack的子串不匹配时，
        //设当前haystack子串的下一位置字符为α，分两种情况处理：
        //1 若α存在于needle中，则右移shift[α]个单位进行对齐；
        //2 若α不在needle中，则右移needle.length长度。
        //然后继续比较。该解法与暴力解法相比，无需退至needle头重新比较。
        int[] shift = new int[256];
        for (char c : needle.toCharArray())
            shift[c] = slen - k++;
        int i = 0;
        while (i + slen <= len) {
            if (iequals(haystack, i, needle))
                return i;
            else {
                if (i + slen < len && shift[haystack.charAt(i + slen)] != 0)
                    i += shift[haystack.charAt(i + slen)];
                else
                    i += slen;
            }
        }
        return -1;
    }

    //避免使用substring取子串，生成过多的String对象
    private boolean iequals(String str1, int offset, String str2) {
        for (int i = 0; i < str2.length(); i++)
            if (str2.charAt(i) != str1.charAt(i + offset))
                return false;
        return true;
    }

    /* Sunday method */
    public static int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        Map<Character, Integer> shift = new HashMap<>();
        int i = 0;
        int plen = needle.length();
        int len = haystack.length();
        int k = 0;
        for (char c : needle.toCharArray()) {
            shift.put(c, plen - k++);
        }
        while (i + plen <= len) {
            if (needle.equals(haystack.substring(i, i + plen)))
                return i;
            else {
                if (i + plen < len && shift.get(haystack.charAt(i + plen)) != null)
                    i = i + shift.get(haystack.charAt(i + plen));
                else
                    i = i + plen;
            }
        }
        return -1;
    }

    /* force method enhanced */
    public static int strStr11(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        int i;
        int j = 0;
        int plen = needle.length();
        for (i = 0; i <= haystack.length() - plen; i++)
            if (haystack.charAt(i) == needle.charAt(j))
                if (needle.equals(haystack.substring(i, i + plen)))
                    return i;
        return -1;
    }

    /* force method */
    public static int strStr10(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j++ == needle.length() - 1)
                    return i - needle.length() + 1;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }

}
