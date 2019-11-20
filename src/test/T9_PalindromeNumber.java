package test;

public class T9_PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(1221));
		System.out.println(isPalindrome(2147483647));
		System.out.println(isPalindrome(2147447412));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int i = 0, j;
		int nums[] = new int[12];
		while (x > 0) {
			nums[i++] = x % 10;
			x = x / 10;
		}
		for (j = 0; j < i / 2; j++) {
			if (nums[j] != nums[i - j - 1])
				return false;
		}
		return true;
	}

	public static boolean isPalindrome0(int x) {
		if (x < 0)
			return false;
		int i = 0, j;
		int nums[] = new int[12];
		while (x > 0) {
			nums[i++] = x % 10;
			x = x / 10;
		}
		for (j = 0; j < i; j++) {
			if (nums[j] != nums[i - j - 1])
				return false;
		}
		return true;
	}

}
