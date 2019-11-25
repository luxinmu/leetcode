package test;

import java.sql.SQLOutput;
import java.util.Arrays;

public class T67_AddBinary {
    public static void main(String[] args) {
        T67_AddBinary t67 = new T67_AddBinary();
        System.out.println(t67.addBinary("101", "1110"));
        System.out.println(t67.addBinary("101", "10"));
    }

    /**
     * 执行用时 :1 ms, 100.00%
     * 内存消耗 :36.1 MB, 55.19%
     * */
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;
        int len = Math.max(len1, len2) + 1;
        char[] ans = new char[len];
        int c1, c2;
        while (len1 >= 0 || len2 >= 0) {
            c1 = --len1 < 0 ? 0 : a.charAt(len1) - '0';
            c2 = --len2 < 0 ? 0 : b.charAt(len2) - '0';
            ans[--len] = (c1 ^ c2 ^ carry) == 1 ? '1' : '0';
            carry = (c1 + c2 + carry) > 1 ? 1 : 0;
        }
        return ans[0] == '0' ? new String(Arrays.copyOfRange(ans, 1, ans.length)) : new String(ans);
    }

    /**
     * 执行用时 :2 ms, 98.26%
     * 内存消耗 :35.6 MB, 57.86%
     */
    public String addBinary1(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;
        int len = Math.max(len1, len2) + 1;
        char[] ans = new char[len];
        int c1, c2;
        while (len1 >= 0 || len2 >= 0) {
            c1 = len1 - 1 < 0 ? 0 : a.charAt(len1 - 1) - '0';
            c2 = len2 - 1 < 0 ? 0 : b.charAt(len2 - 1) - '0';
            ans[len - 1] = (c1 ^ c2 ^ carry) == 1 ? '1' : '0';
            carry = (c1 + c2 + carry) > 1 ? 1 : 0;
            len1--;
            len2--;
            len--;
        }
        if (ans[0] == '1') {
            return new String(ans);
        } else
            return new String(Arrays.copyOfRange(ans, 1, ans.length));
    }
}
