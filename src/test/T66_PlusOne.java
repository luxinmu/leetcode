package test;

import java.util.Arrays;

public class T66_PlusOne {
    public static void main(String[] args) {
        T66_PlusOne t66 = new T66_PlusOne();
        Tools.printArray(t66.plusOne(new int[]{1, 2, 4}));
        Tools.printArray(t66.plusOne(new int[]{1, 9, 9}));
        Tools.printArray(t66.plusOne(new int[]{9, 9, 9}));
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :34.8 MB, 50.44%
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int len = digits.length;
        int carry = 0;
        if (digits[len - 1] != 9) {
            digits[len - 1] += 1;
            return digits;
        } else {
            digits[len - 1] = 0;
            carry = 1;
        }
        int tmp = 0;
        int i = len - 2;
        while (i >= 0) {
            tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp % 10;
            i--;
        }
        if (carry == 1) {
            int ans[] = new int[len + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, len);
            return ans;
        } else
            return digits;
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :35 MB, 40.04%
     */
    public int[] plusOne1(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int len = digits.length;
        int ans[] = new int[len + 1];
        int carry = 0;
        int tmp = 0;
        int i = len;
        while (i-- >= 0) {
            tmp = (i >= 0 ? digits[i] : 0) + carry + ((i == len - 1) ? 1 : 0);
            carry = tmp / 10;
            ans[i + 1] = tmp % 10;
        }
        return ans[0] == 1 ? ans : Arrays.copyOfRange(ans, 1, ans.length);
    }
}
