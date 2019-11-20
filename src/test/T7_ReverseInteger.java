package test;

public class T7_ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(10));
		System.out.println(reverse(-10));
		System.out.println(reverse(-210));
		System.out.println(reverse(1234567890));
		System.out.println(reverse(1234567896));
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			if ((ans * 10) / 10 != ans) {
				ans = 0;
				break;
			}
			ans = ans * 10 + x % 10;
			x = x / 10;
		}
		return ans;
	}

	public static int reverse1(int x) {
//		boolean lessthan0 = x > 0 ? false : true;
//		int loopx = x > 0 ? x : -x;
		int loopx = x;
		int ans = 0;
		while (loopx != 0) {
			if ((ans * 10) / 10 != ans) {
				ans = 0;
				break;
			}
//			if (Integer.MAX_VALUE >= ans * 10 + loopx % 10 && Integer.MIN_VALUE <= ans * 10 + loopx % 10)
			ans = ans * 10 + loopx % 10;
//			else {
//				ans = 0;
//				break;
//			}
			loopx = loopx / 10;
		}
		return ans;
	}

	public static int reverse10(int x) {
		String snum = String.valueOf(x);
		String reverseStr = "";
		for (int i = snum.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + snum.charAt(i);
		}
		if (reverseStr.endsWith("-"))
			reverseStr = "-" + reverseStr.substring(0, reverseStr.length() - 1);
		try {
			return Integer.parseInt(reverseStr);
		} catch (Exception e) {
			return 0;
		}
	}

}
