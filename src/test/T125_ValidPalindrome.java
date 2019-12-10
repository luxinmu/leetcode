package test;

/**
 * 125. Valid Palindrome
 * Difficult: Easy
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * <p>
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class T125_ValidPalindrome {
    public static void main(String[] args) {
        T125_ValidPalindrome t125 = new T125_ValidPalindrome();
        System.out.println(t125.isPalindrome1("0P"));
        System.out.println(t125.isPalindrome1("A man, a plan, a canal: Panama"));
        System.out.println(t125.isPalindrome1("race a car"));
    }

    /**
     * 执行用时 : 3 ms ,  95.68%
     * 内存消耗 : 36.6 MB ,  96.86%
     * 统一转大写 ch & 0b11011111 同 ch & 0xDF
     * 统一转小写 ch | 0b00100000 同 ch | 0x20
     */
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (isSkip(s.charAt(left)))
                right++;
            else if (isSkip(s.charAt(right)))
                left--;
            else if ((s.charAt(left) | 0x20) != (s.charAt(right) | 0x20))  //KEYPOINT
                return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * 执行用时 : 4 ms ,  88.86%
     * 内存消耗 : 37 MB ,  96.32%
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        int diff = Math.abs('a' - 'A');
        while (left < right) {
            if (isSkip(s.charAt(left)))
                right++;
            else if (isSkip(s.charAt(right)))
                left--;
            else if (s.charAt(left) != s.charAt(right)) {
                if (s.charAt(left) >= '0' && s.charAt(left) <= '9') return false;
                if (s.charAt(right) >= '0' && s.charAt(right) <= '9') return false;
                if (Math.abs(s.charAt(left) - s.charAt(right)) != diff)
                    return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isSkip(char ch) {
        return (ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9');
    }
}
